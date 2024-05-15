package com.s28572.tpo09.Models;

public class BMR {

    private static final double WEIGHT_CONSTANT_MEN = 13.397;
    private static final double HEIGHT_CONSTANT_MEN = 4.799;
    private static final double AGE_CONSTANT_MEN = 5.677;
    private static final double FINAL_CONSTANT_MEN = 88.362;

    private static final double WEIGHT_CONSTANT_WOMEN = 9.247;
    private static final double HEIGHT_CONSTANT_WOMEN = 3.098;
    private static final double AGE_CONSTANT_WOMEN = 4.330;
    private static final double FINAL_CONSTANT_WOMEN = 447.593;

    private String gender;
    private double weight;
    private double height;
    private int age;
    private int BMR;

    private BMR() {

    }

    public String getGender() {
        return gender;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public int getBMR() {
        return BMR;
    }

    public static BMR getInstance(String gender, double weight, double height, int age) {
        BMR bmr = new BMR();
        bmr.gender = gender;
        bmr.weight = weight;
        bmr.height = height;
        bmr.age = age;
        bmr.BMR = bmr.calculateBMR();
        return bmr;
    }

    private int calculateBMR() {
        if (gender.equals("man")) {
            return (int) (WEIGHT_CONSTANT_MEN*weight + HEIGHT_CONSTANT_MEN*height - AGE_CONSTANT_MEN*age + FINAL_CONSTANT_MEN);
        }
        return (int) (WEIGHT_CONSTANT_WOMEN*weight + HEIGHT_CONSTANT_WOMEN*height - AGE_CONSTANT_WOMEN*age + FINAL_CONSTANT_WOMEN);
    }
}
