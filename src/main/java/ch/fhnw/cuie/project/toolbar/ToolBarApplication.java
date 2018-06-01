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
        HydroToolBar toolBar = new HydroToolBar(18);
        toolBar.getSaveButton().setOnAction(mouseEvent -> System.out.println("Save button clicked!"));
        toolBar.getCreateButton().setOnAction(actionEvent -> System.out.println("Create button clicked!"));
        toolBar.getDeleteButton().setOnAction(actionEvent -> System.out.println("Delete button clicked!"));
        toolBar.getUndoButton().setOnAction(actionEvent -> System.out.println("Undo button clicked!"));
        toolBar.getRedoButton().setOnAction(actionEvent -> System.out.println("Redo button clicked!"));
        toolBar.getGermanLanguageButton().setOnAction(actionEvent -> System.out.println("German button clicked!"));
        toolBar.getEnglishLanguageButton().setOnAction(actionEvent -> System.out.println("English button clicked!"));
        toolBar.getSearchTextField().setOnAction(actionEvent -> System.out.println("Search text field submitted!"));
        toolBar.getSearchTextField().setOnKeyTyped(actionEvent -> System.out.println("Search text field typed!"));

        toolBar.getCreateButton().setDisable(true);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(toolBar);
        borderPane.setCenter(new TextArea());

        primaryStage.setTitle("Hydro Toolbar");
        primaryStage.setScene(new Scene(borderPane, 800, 600));
        primaryStage.toFront();
        primaryStage.show();
    }
}
