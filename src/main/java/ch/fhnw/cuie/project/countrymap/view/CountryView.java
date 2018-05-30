package ch.fhnw.cuie.project.countrymap.view;

import ch.fhnw.cuie.project.countrymap.model.Canton;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CountryView extends AbstractView {

    private final List<Canton> cantonList;

    private Map<SVGPath, Canton> cantonSvgMap;

    private Color activeCantonColor;

    private Color inactiveCantonColor;

    private Color borderColor;

    private Color backgroundColor;

    public CountryView(List<Canton> cantonList) {
        this.cantonList = cantonList;

        initializeSelf();
        initializeParts();
        layoutParts();
        setupValueChangeListeners();
        setupBinding();
    }

    private void initializeSelf() {
        cantonSvgMap = new LinkedHashMap<>();
        activeCantonColor = Color.valueOf("#990000");
        inactiveCantonColor = Color.valueOf("#006666");
        borderColor = Color.valueOf("#339999");
        backgroundColor = Color.valueOf("#CCE6FF");
    }

    private void initializeParts() {
        for (Canton canton : cantonList) {
            SVGPath svgPath = new SVGPath();
            cantonSvgMap.put(svgPath, canton);
        }

        drawBackground();
        drawCantonsAndBorders();
    }

    private void layoutParts() {
        for (Map.Entry<SVGPath, Canton> entry : cantonSvgMap.entrySet()) {
            getPane().getChildren().add(entry.getKey());
        }
        getChildren().add(getPane());
    }

    private void setupValueChangeListeners() {
        for (Map.Entry<SVGPath, Canton> entry : cantonSvgMap.entrySet()) {
            entry.getKey().setOnMouseClicked(mouseEvent -> {
                Canton canton = entry.getValue();
                canton.setIsActive(!canton.isIsActive());
                System.out.println("State clicked: " + canton.getDisplayName());
                drawCantonsAndBorders();
            });
        }
    }

    private void setupBinding() {
        // No-op
    }

    private void drawCantonsAndBorders() {
        for (Map.Entry<SVGPath, Canton> entry : cantonSvgMap.entrySet()) {
            SVGPath svgPath = entry.getKey();
            Canton canton = entry.getValue();
            svgPath.setContent(canton.getPathValue());
            svgPath.setFill(canton.isIsActive() ? activeCantonColor : inactiveCantonColor);
            svgPath.setStroke(borderColor);
        }
    }

    private void drawBackground() {
        setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public Color getActiveCantonColor() {
        return activeCantonColor;
    }

    public void setActiveCantonColor(Color activeCantonColor) {
        this.activeCantonColor = new Color(activeCantonColor.getRed(), activeCantonColor.getGreen(), activeCantonColor.getBlue(), 1);
        drawCantonsAndBorders();
    }

    public Color getInactiveCantonColor() {
        return inactiveCantonColor;
    }

    public void setInactiveCantonColor(Color inactiveCantonColor) {
        this.inactiveCantonColor = new Color(inactiveCantonColor.getRed(), inactiveCantonColor.getGreen(), inactiveCantonColor.getBlue(), 1);
        drawCantonsAndBorders();
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = new Color(borderColor.getRed(), borderColor.getGreen(), borderColor.getBlue(), 1);
        drawCantonsAndBorders();
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = new Color(backgroundColor.getRed(), backgroundColor.getGreen(), backgroundColor.getBlue(), 1);
        drawBackground();
    }
}
