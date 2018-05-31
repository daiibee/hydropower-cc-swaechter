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
import javafx.scene.text.Font;

import java.io.InputStream;

public class HydroToolBar extends ToolBar {

    private Font customFont;

    private Button createButton;

    private Button editButton;

    private Button deleteButton;

    private Region horizontalRegionSpacer;

    private Button germanLanguageButton;

    private Button englishLanguageButton;

    private TextField searchTextField;

    public HydroToolBar() {
        initializeSelf();
        initializeParts();
        layoutParts();
    }

    private void initializeSelf() {
        //String fonts = getClass().getResource("/fonts/fonts.css").toExternalForm();
        //getStylesheets().add(fonts);

        InputStream font = HydroToolBar.class.getResourceAsStream("/fonts//fontawesome-webfont.ttf");
        customFont = Font.loadFont(font, 14);

        String stylesheet = getClass().getResource("toolbar-control.css").toExternalForm();
        getStylesheets().add(stylesheet);
        getStyleClass().add("toolbar-control");
    }

    private void initializeParts() {
        horizontalRegionSpacer = new Region();
        createButton = createButton("create-button", '\uf040');
        editButton = createButton("edit-button", '\uf040');
        deleteButton = createButton("delete-button", '\uf040');
        germanLanguageButton = createButton("german-language-button", '\uf040');
        englishLanguageButton = createButton("english-language-button", '\uf040');
        searchTextField = createTextField("search-textfield");
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

    private Button createButton(String cssName, char iconName) {
        Button button = new Button();
        button.setText(String.valueOf(iconName));
        button.setFont(customFont);
        button.getStyleClass().add(cssName);
        return button;
    }

    private TextField createTextField(String cssName) {
        TextField textField = new TextField();
        textField.getStyleClass().add(cssName);
        return textField;
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
