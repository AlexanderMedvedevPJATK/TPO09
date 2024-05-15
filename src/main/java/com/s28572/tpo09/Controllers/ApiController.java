package com.s28572.tpo09.Controllers;

import com.s28572.tpo09.Models.BMI;
import com.s28572.tpo09.Models.BMR;
import com.s28572.tpo09.Services.BMIService;
import com.s28572.tpo09.Services.BMRService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ApiController {

    private final BMIService bmiService;
    private final BMRService bmrService;

    public ApiController(BMIService bmiService, BMRService bmrService) {
        this.bmiService = bmiService;
        this.bmrService = bmrService;
    }

    @GetMapping("/")
    public String index() {
        return "Welcome to the BMI and BMR calculator!";
    }
    
    @GetMapping("/BMI")
    public ResponseEntity<BMI> getBMI(@RequestParam double weight, @RequestParam double height) {
        return bmiService.calculateBMI(weight, height)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest()
                        .header("Reason",
                                "invalid data, weight and height parameters must be positive numbers")
                        .build());
    }

    @GetMapping("/BMR/{gender}")
    public ResponseEntity<BMR> getBMR(@PathVariable String gender,
                                      @RequestParam double weight,
                                      @RequestParam double height,
                                      @RequestParam int age) {
        if (!bmrService.validateGender(gender)) {
            return ResponseEntity.badRequest().header("Reason", "Invalid gender data").build();
        }
        return bmrService.calculateBMR(gender, weight, height, age)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest()
                        .header("Reason",
                                "invalid data, weight, height and age parameters must be positive numbers")
                        .build());
    }
}
