package com.s28572.tpo09.Models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.s28572.tpo09.Util.BMITypes;

@JsonPropertyOrder({"weight", "height", "BMI", "type"})
public class BMI {

    private double weight;
    private double height;
    private int BMI;
    private BMITypes type;

    private BMI() {

    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public int getBMI() {
        return BMI;
    }

    public BMITypes getType() {
        return type;
    }

    public static BMI getInstance(double weight, double height) {
        BMI bmi = new BMI();
        bmi.weight = weight;
        bmi.height = height;
        bmi.BMI = bmi.calculateBMI();
        bmi.type = bmi.determineType();
        return bmi;
    }

    private int calculateBMI() {
        return (int) (weight / (height * height));
    }

    private BMITypes determineType() {
        if (BMI < 18.5) {
            return BMITypes.UNDERWEIGHT;
        } else if (BMI < 24.9) {
            return BMITypes.NORMAL;
        } else if (BMI < 29.9) {
            return BMITypes.OVERWEIGHT;
        } else if (BMI < 34.9) {
            return BMITypes.OBESE;
        } else {
            return BMITypes.EXTREMELY_OBESE;
        }
    }
}
