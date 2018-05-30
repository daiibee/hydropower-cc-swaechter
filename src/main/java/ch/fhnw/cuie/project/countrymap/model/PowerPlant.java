package ch.fhnw.cuie.project.countrymap.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PowerPlant {

    private StringProperty displayName;

    private DoubleProperty xPosition;

    private DoubleProperty yPosition;

    public PowerPlant(String displayName, double xPosition, double yPosition) {
        this.displayName = new SimpleStringProperty(displayName);
        this.xPosition = new SimpleDoubleProperty(xPosition);
        this.yPosition = new SimpleDoubleProperty(yPosition);
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

    public double getxPosition() {
        return xPosition.get();
    }

    public DoubleProperty xPositionProperty() {
        return xPosition;
    }

    public void setxPosition(double xPosition) {
        this.xPosition.set(xPosition);
    }

    public double getyPosition() {
        return yPosition.get();
    }

    public DoubleProperty yPositionProperty() {
        return yPosition;
    }

    public void setyPosition(double yPosition) {
        this.yPosition.set(yPosition);
    }
}
