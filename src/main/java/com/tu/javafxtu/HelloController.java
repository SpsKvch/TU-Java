package com.tu.javafxtu;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;

import java.util.HashSet;
import java.util.Set;

public class HelloController {

    private BMICalculator bmiCalculator = new BMICalculator();
    private static final int STROKE_WIDTH = 7;
    private static final double CENTER_X = 50.0f;
    private static final double CENTER_Y = 50.0f;

    @FXML
    private Label welcomeText;
    @FXML
    private TextField heightField;
    @FXML
    private TextField weightField;
    @FXML
    private Group group = new Group();
    @FXML
    private Line arrow = bmiLine(0.0f);

    public void initialize() {
        var children = group.getChildren().add(arrow);
        var children2 = group.getChildren().addAll(drawMultiColouredArcs());
    }

    @FXML
    protected void onCalculateBMIClick() {
        double bmi = bmiCalculator.calculateBMI(getHeight(), getWeight());
        welcomeText.setText(bmiCalculator.getBMIMessage(bmi));
        moveArrow(bmi);
    }

    @FXML
    protected void onCalculateIBWClick() {
        double bmi = bmiCalculator.calculateBMI(getHeight(), getWeight());
        String message = bmiCalculator.calculateIBW(getHeight());
        welcomeText.setText(message);
        moveArrow(bmi);
    }

    @FXML
    protected void onCalculateLBWClick() {
        double bmi = bmiCalculator.calculateBMI(getHeight(), getWeight());
        String message = bmiCalculator.calculateLBW(getHeight(), getWeight());
        welcomeText.setText(message);
        moveArrow(bmi);
    }

    private double getHeight() {
        return Double.parseDouble(heightField.getText());
    }

    private double getWeight() {
        return Double.parseDouble(weightField.getText());
    }

    private void moveArrow(double bmi) {
        double bmiWithinConstraint = bmi;
        if (bmi < 0) {
            bmiWithinConstraint = 10;
        } else if (bmi > 40) {
            bmiWithinConstraint = 40.0f;
        }
        double bmiDegrees = (bmiWithinConstraint-10)*6.0f;
        setArrow(bmiLine(bmiDegrees));
    }

    private void setArrow(Line line) {
        group.getChildren().set(0, line);
    }

    protected Set<Arc> drawMultiColouredArcs() {
        Set<Arc> arcs = new HashSet<>();
        Arc obeseArc = new Arc(CENTER_X, CENTER_Y, CENTER_X, CENTER_Y, 0, 60);
        obeseArc.setStroke(Color.RED);
        obeseArc.setStrokeWidth(STROKE_WIDTH);
        obeseArc.setFill(Color.TRANSPARENT);
        arcs.add(obeseArc);

        Arc overweightArc = new Arc(CENTER_X, CENTER_Y, CENTER_X, CENTER_Y, 60, 30);
        overweightArc.setStroke(Color.ORANGE);
        overweightArc.setStrokeWidth(STROKE_WIDTH);
        overweightArc.setFill(Color.TRANSPARENT);
        arcs.add(overweightArc);

        Arc healthyArc = new Arc(CENTER_X, CENTER_Y, CENTER_X, CENTER_Y, 90, 40);
        healthyArc.setStroke(Color.GREEN);
        healthyArc.setStrokeWidth(STROKE_WIDTH);
        healthyArc.setFill(Color.TRANSPARENT);
        arcs.add(healthyArc);

        Arc underWeightArc = new Arc(CENTER_X, CENTER_Y, CENTER_X, CENTER_Y, 130, 50);
        underWeightArc.setStroke(Color.YELLOW);
        underWeightArc.setStrokeWidth(STROKE_WIDTH);
        underWeightArc.setFill(Color.TRANSPARENT);
        arcs.add(underWeightArc);

        return arcs;
    }

    protected Line bmiLine(double degrees) {
        double xEnd = (degrees/90) * CENTER_X;
        double yEnd = (Math.abs(degrees-90)/90) * CENTER_Y;
        Line line = new Line(CENTER_X, CENTER_Y, xEnd, yEnd);
        line.setVisible(true);
        line.setStrokeWidth(STROKE_WIDTH/2.0f);
        return line;
    }
}