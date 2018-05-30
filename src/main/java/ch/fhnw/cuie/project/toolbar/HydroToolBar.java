package ch.fhnw.cuie.project.toolbar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class HydroToolBar extends ToolBar {

    private Button createButton;

    private Button editButton;

    private Button deleteButton;

    private Region horizontalRegionSpacer;

    private Button germanLanguageButton;

    private Button englishLanguageButton;

    private TextField searchTextField;

    public HydroToolBar() {
        initializeParts();
        layoutParts();
    }

    private void initializeParts() {
        createButton = new Button("Create");
        editButton = new Button("Edit");
        deleteButton = new Button("Delete");
        horizontalRegionSpacer = new Region();
        germanLanguageButton = new Button("German");
        englishLanguageButton = new Button("English");
        searchTextField = new TextField();
    }

    private void layoutParts() {
        getItems().clear();

        if (createButton.getOnAction() != null) {
            getItems().add(createButton);
        }

        if (editButton.getOnAction() != null) {
            getItems().add(editButton);
        }

        if (deleteButton.getOnAction() != null) {
            getItems().add(deleteButton);
        }

        HBox.setHgrow(horizontalRegionSpacer, Priority.ALWAYS);
        getItems().add(horizontalRegionSpacer);

        if (germanLanguageButton.getOnAction() != null) {
            getItems().add(germanLanguageButton);
        }

        if (englishLanguageButton.getOnAction() != null) {
            getItems().add(englishLanguageButton);
        }

        if (searchTextField.getOnAction() != null || searchTextField.getOnKeyTyped() != null) {
            getItems().add(searchTextField);
        }
    }

    public void setCreateButtonOnAction(EventHandler<ActionEvent> event) {
        createButton.setOnAction(event);
        layoutParts();
    }

    public void setEditButtonOnAction(EventHandler<ActionEvent> event) {
        editButton.setOnAction(event);
        layoutParts();
    }

    public void setDeleteButtonOnAction(EventHandler<ActionEvent> event) {
        deleteButton.setOnAction(event);
        layoutParts();
    }

    public void setGermanLanguageButtonOnAction(EventHandler<ActionEvent> event) {
        germanLanguageButton.setOnAction(event);
        layoutParts();
    }

    public void setEnglishLanguageButtonOnAction(EventHandler<ActionEvent> event) {
        englishLanguageButton.setOnAction(event);
        layoutParts();
    }

    public void setSearchTextFieldOnAction(EventHandler<ActionEvent> event) {
        searchTextField.setOnAction(event);
        layoutParts();
    }

    public void setSearchTextFieldOnKeyPressed(EventHandler<KeyEvent> event) {
        searchTextField.setOnKeyPressed(event);
        layoutParts();
    }
}
