package ch.fhnw.cuie.project.toolbar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ToolBarApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        HydroToolBar toolBar = new HydroToolBar();
        toolBar.setStyle("-fx-background-color: blue;");
        toolBar.setCreateButtonOnAction(actionEvent -> System.out.println("Create button clicked!"));
        toolBar.setEditButtonOnAction(actionEvent -> System.out.println("Edit button clicked!"));
        toolBar.setDeleteButtonOnAction(actionEvent -> System.out.println("Delete button clicked!"));
        toolBar.setGermanLanguageButtonOnAction(actionEvent -> System.out.println("German button clicked!"));
        toolBar.setEnglishLanguageButtonOnAction(actionEvent -> System.out.println("English button clicked!"));
        toolBar.setSearchTextFieldOnAction(actionEvent -> System.out.println("Search text field submitted!"));
        toolBar.setSearchTextFieldOnKeyPressed(actionEvent -> System.out.println("Search text field typed!"));

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(toolBar);
        borderPane.setCenter(new TextArea());

        primaryStage.setTitle("Hydro Toolbar");
        primaryStage.setScene(new Scene(borderPane, 800, 600));
        primaryStage.toFront();
        primaryStage.show();
    }
}
