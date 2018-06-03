package ch.fhnw.cuie.project.countrymap;

import ch.fhnw.cuie.project.countrymap.model.Canton;
import ch.fhnw.cuie.project.countrymap.model.CantonUtils;
import ch.fhnw.cuie.project.countrymap.view.CountryCantonView;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CountryMapApplication extends Application {

    private CountryCantonView countryCantonView;

    private Label activeCantonColorLabel;

    private ColorPicker activeCantonColorPicker;

    private Label inactiveCantonColorLabel;

    private ColorPicker inactiveCantonColorPicker;

    private Label borderColorLabel;

    private ColorPicker borderColorPicker;

    private Label backgroundColorLabel;

    private ColorPicker backgroundColorPicker;

    private Label cantonListViewLabel;

    private ListView<Canton> cantonListView;

    private VBox vBox;

    private BorderPane borderPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initializeParts();
        layoutParts(primaryStage);
        setupValueChangeListeners();
        setupColors();
    }

    private void initializeParts() {
        ObservableList<Canton> observableCantonList = CantonUtils.getAllCantons();
        countryCantonView = new CountryCantonView(observableCantonList);

        activeCantonColorLabel = new Label("Canton Active");
        activeCantonColorPicker = new ColorPicker();
        activeCantonColorPicker.setValue(countryCantonView.getActiveCantonColor());

        inactiveCantonColorLabel = new Label("Canton Inactive");
        inactiveCantonColorPicker = new ColorPicker();
        inactiveCantonColorPicker.setValue(countryCantonView.getInactiveCantonColor());

        borderColorLabel = new Label("Border");
        borderColorPicker = new ColorPicker();
        borderColorPicker.setValue(countryCantonView.getBorderColor());

        backgroundColorLabel = new Label("Background");
        backgroundColorPicker = new ColorPicker();
        backgroundColorPicker.setValue(countryCantonView.getBackgroundColor());

        cantonListViewLabel = new Label("Current Canton");
        cantonListView = new ListView<>(observableCantonList);
        cantonListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    private void layoutParts(Stage stage) {
        vBox = new VBox();
        vBox.getChildren().addAll(activeCantonColorLabel, activeCantonColorPicker, inactiveCantonColorLabel, inactiveCantonColorPicker, borderColorLabel, borderColorPicker, backgroundColorLabel, backgroundColorPicker, cantonListViewLabel, cantonListView);

        borderPane = new BorderPane();
        borderPane.setCenter(countryCantonView);
        borderPane.setRight(vBox);

        Scene scene = new Scene(borderPane, 1000, 600);
        stage.setTitle("Switzerland <3");
        stage.setScene(scene);
        stage.show();
    }

    private void setupValueChangeListeners() {
        cantonListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList<Canton> selectedCantons = cantonListView.getSelectionModel().getSelectedItems();
            for (Canton canton : countryCantonView.getCantonList()) {
                canton.setIsActive(selectedCantons.contains(canton));
            }
        });

        countryCantonView.setCantonClickCallback(canton -> {
            System.out.println("Country clicked: " + canton);
            //canton.setIsActive(!canton.isIsActive());
        });

        activeCantonColorPicker.setOnAction(actionEvent -> countryCantonView.setActiveCantonColor(activeCantonColorPicker.getValue()));
        inactiveCantonColorPicker.setOnAction(actionEvent -> countryCantonView.setInactiveCantonColor(inactiveCantonColorPicker.getValue()));
        borderColorPicker.setOnAction(actionEvent -> countryCantonView.setBorderColor(borderColorPicker.getValue()));
        backgroundColorPicker.setOnAction(actionEvent -> updateBackground());
    }

    private void setupColors() {
        updateBackground();
    }

    private void updateBackground() {
        Color color = backgroundColorPicker.getValue();
        color = new Color(color.getRed(), color.getGreen(), color.getBlue(), 1);

        countryCantonView.setBackgroundColor(color);
        borderPane.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.setBackground(Background.EMPTY);
    }
}
