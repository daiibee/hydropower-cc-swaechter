package ch.fhnw.cuie.project.countrymap;

import ch.fhnw.cuie.project.countrymap.model.Canton;
import ch.fhnw.cuie.project.countrymap.model.CantonUtils;
import ch.fhnw.cuie.project.countrymap.view.CountryView;
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

    private ObservableList<Canton> observableCantonList;

    private CountryView countryView;

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
        setupBinding();
        setupColors();
    }

    private void initializeParts() {
        observableCantonList = CantonUtils.getAllCantons();
        countryView = new CountryView(observableCantonList);

        activeCantonColorLabel = new Label("Canton Active");
        activeCantonColorPicker = new ColorPicker();
        activeCantonColorPicker.setValue(countryView.getActiveCantonColor());

        inactiveCantonColorLabel = new Label("Canton Inactive");
        inactiveCantonColorPicker = new ColorPicker();
        inactiveCantonColorPicker.setValue(countryView.getInactiveCantonColor());

        borderColorLabel = new Label("Border");
        borderColorPicker = new ColorPicker();
        borderColorPicker.setValue(countryView.getBorderColor());

        backgroundColorLabel = new Label("Background");
        backgroundColorPicker = new ColorPicker();
        backgroundColorPicker.setValue(countryView.getBackgroundColor());

        cantonListViewLabel = new Label("Current Canton");
        cantonListView = new ListView<>(observableCantonList);
        cantonListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    private void layoutParts(Stage stage) {
        vBox = new VBox();
        vBox.getChildren().addAll(activeCantonColorLabel, activeCantonColorPicker, inactiveCantonColorLabel, inactiveCantonColorPicker, borderColorLabel, borderColorPicker, backgroundColorLabel, backgroundColorPicker, cantonListViewLabel, cantonListView);

        borderPane = new BorderPane();
        borderPane.setCenter(countryView);
        borderPane.setRight(vBox);

        Scene scene = new Scene(borderPane, 1000, 600);
        stage.setTitle("Switzerland <3");
        stage.setScene(scene);
        stage.show();
    }

    private void setupValueChangeListeners() {
        cantonListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList<Canton> selectedCantons =  cantonListView.getSelectionModel().getSelectedItems();
            for(Canton canton : observableCantonList) {
                canton.setIsActive(selectedCantons.contains(canton));
            }
        });

        countryView.setCountryClickCallback(canton -> {
            System.out.println("Country clicked: " + canton);
            //canton.setIsActive(!canton.isIsActive());
        });
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
