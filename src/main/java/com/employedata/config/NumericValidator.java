package com.employedata.config;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumericValidator implements ConstraintValidator<Numeric, Double> {
    @Override
    public void initialize(Numeric numeric) {
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true; // Null values are considered valid, as they are not required
        }

        try {
            Double.parseDouble(String.valueOf(value)); // Try to parse the value as a double
            return true; // If parsing succeeds, it's a valid numeric value
        } catch (NumberFormatException e) {
            return false; // Parsing failed, so it's not a valid numeric value
        }
    }
}
