package com.tu.javafxtu;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController {

    private BMICalculator bmiCalculator = new BMICalculator();

    @FXML
    private Label welcomeText;
    @FXML
    private TextField heightField;
    @FXML
    private TextField weightField;

    @FXML
    protected void onCalculateBMIClick() {
        String message = bmiCalculator.calculateBMI(getHeight(), getWeight());
        welcomeText.setText(message);
    }

    @FXML
    protected void onCalculateIBWClick() {
        String message = bmiCalculator.calculateIBW(getHeight());
        welcomeText.setText(message);
    }

    @FXML
    protected void onCalculateLBWClick() {
        String message = bmiCalculator.calculateLBW(getHeight(), getWeight());
        welcomeText.setText(message);
    }

    private double getHeight() {
        return Double.parseDouble(heightField.getText());
    }

    private double getWeight() {
        return Double.parseDouble(weightField.getText());
    }
}