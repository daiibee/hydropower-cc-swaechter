package ch.fhnw.cuie.project.countrymap.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Canton {

    private StringProperty displayName;

    private StringProperty pathValue;

    private BooleanProperty isActive;

    public Canton(String displayName, String pathValue) {
        this.displayName = new SimpleStringProperty(displayName);
        this.pathValue = new SimpleStringProperty(pathValue);
        this.isActive = new SimpleBooleanProperty(false);
    }

    public String getDisplayName() {
        return displayName.get();
    }

    public StringProperty displayNameProperty() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName.set(displayName);
    }

    public String getPathValue() {
        return pathValue.get();
    }

    public StringProperty pathValueProperty() {
        return pathValue;
    }

    public void setPathValue(String pathValue) {
        this.pathValue.set(pathValue);
    }

    public boolean isIsActive() {
        return isActive.get();
    }

    public BooleanProperty isActiveProperty() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive.set(isActive);
    }
}
