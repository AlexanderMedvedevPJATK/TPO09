package com.s28572.tpo09.Services;

import com.s28572.tpo09.Models.BMI;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BMIService {

    public boolean validateParameters(double weight, double height) {
        return weight > 0 && height > 0;
    }

    public Optional<BMI> calculateBMI(double weight, double height) {
        if (!validateParameters(weight, height)) {
            return Optional.empty();
        }
        return Optional.of(BMI.getInstance(weight, height / 100));
    }
}
