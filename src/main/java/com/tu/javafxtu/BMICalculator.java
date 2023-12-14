package com.tu.javafxtu;

public class BMICalculator {

    private static final double BMI_CONSTANT = 10000;
    private static final double IBW_CONSTANT = 2.3;
    private static final double IBW_DIVIDE_CONSTANT = 2.54;
    private static final double LBW_FIRST_CONSTANT = 1.07;
    private static final double LBW_SECOND_CONSTANT = 148;

    public double calculateBMI(double height, double weight) {
        return weight/Math.pow(height/100,2);
    }

    public String getBMIMessage(double bmi) {
        if (bmi < 18.5) {
            return String.format("BMI is %.2f, you are underweight", bmi);
        } else if (bmi < 25) {
            return String.format("BMI is %.2f, you have normal weight", bmi);
        } else if (bmi < 30) {
            return String.format("BMI is %.2f, you are overweight", bmi);
        } else {
            return String.format("BMI is %.2f, you are obese", bmi);
        }
    }

    public String calculateIBW(double height) {
        return String.format("IBW is: %.2f",
                50 + (IBW_CONSTANT*(height/IBW_DIVIDE_CONSTANT-60)));
    }

    public String calculateLBW(double height, double weight) {
        return String.format("LBW is: %.2f",
                LBW_FIRST_CONSTANT*weight - LBW_SECOND_CONSTANT*(Math.pow(weight,2)/Math.pow(height,2)));
    }

}
