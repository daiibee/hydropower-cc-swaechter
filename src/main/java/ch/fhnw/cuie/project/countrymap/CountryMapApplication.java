package ch.fhnw.cuie.project.countrymap;

import ch.fhnw.cuie.project.countrymap.model.Canton;
import ch.fhnw.cuie.project.countrymap.utils.CantonUtils;
import ch.fhnw.cuie.project.countrymap.view.CountryView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;

public class CountryMapApplication extends Application {

    private CountryView countryView;

    private ColorPicker activeCantonColorPicker;

    private ColorPicker inactiveCantonColorPicker;

    private ColorPicker borderColorPicker;

    private ColorPicker backgroundColorPicker;

    private Label activeCantonColorLabel;

    private Label inactiveCantonColorLabel;

    private Label borderColorLabel;

    private Label backgroundColorLabel;

    private VBox vBox;

    private BorderPane borderPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initializeParts();
        layoutParts(primaryStage);
        setupBinding();
        setupColors();
    }

    private void initializeParts() {
        List<Canton> cantonList = CantonUtils.getAllCantons();
        countryView = new CountryView(cantonList);

        activeCantonColorPicker = new ColorPicker();
        activeCantonColorPicker.setValue(countryView.getActiveCantonColor());

        inactiveCantonColorPicker = new ColorPicker();
        inactiveCantonColorPicker.setValue(countryView.getInactiveCantonColor());

        borderColorPicker = new ColorPicker();
        borderColorPicker.setValue(countryView.getBorderColor());

        backgroundColorPicker = new ColorPicker();
        backgroundColorPicker.setValue(countryView.getBackgroundColor());

        activeCantonColorLabel = new Label("Canton Active");

        inactiveCantonColorLabel = new Label("Canton Inactive");

        borderColorLabel = new Label("Border");

        backgroundColorLabel = new Label("Background");
    }

    private void layoutParts(Stage stage) {
        vBox = new VBox();
        vBox.getChildren().addAll(activeCantonColorLabel, activeCantonColorPicker, inactiveCantonColorLabel, inactiveCantonColorPicker, borderColorLabel, borderColorPicker, backgroundColorLabel, backgroundColorPicker);

        borderPane = new BorderPane();
        borderPane.setCenter(countryView);
        borderPane.setRight(vBox);

        Scene scene = new Scene(borderPane, 1000, 600);
        stage.setTitle("Switzerland <3");
        stage.setScene(scene);
        stage.show();
    }

    private void setupBinding() {
        activeCantonColorPicker.setOnAction(actionEvent -> countryView.setActiveCantonColor(activeCantonColorPicker.getValue()));
        inactiveCantonColorPicker.setOnAction(actionEvent -> countryView.setInactiveCantonColor(inactiveCantonColorPicker.getValue()));
        borderColorPicker.setOnAction(actionEvent -> countryView.setBorderColor(borderColorPicker.getValue()));
        backgroundColorPicker.setOnAction(actionEvent -> updateBackground());
    }

    private void setupColors() {
        updateBackground();
    }

    private void updateBackground() {
        Color color = backgroundColorPicker.getValue();
        color = new Color(color.getRed(), color.getGreen(), color.getBlue(), 1);

        countryView.setBackgroundColor(color);
        borderPane.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.setBackground(Background.EMPTY);
    }
}
