package com.s28572.tpo09.Services;

import com.s28572.tpo09.Models.BMR;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BMRService {


    public boolean validateGender(String gender) {
        return gender.equals("man") || gender.equals("woman");
    }

    public boolean validateParameters(double weight, double height, double age) {
        return weight > 0 && height > 0 & age > 0;
    }

    public Optional<BMR> calculateBMR(String gender, double weight, double height, int age) {
        if (!validateParameters(weight, height, age)) {
            return Optional.empty();
        }

        return Optional.of(BMR.getInstance(gender, weight, height, age));
    }
}
