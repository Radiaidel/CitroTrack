package com.aidar.citrotrack.Validation;

import com.aidar.citrotrack.model.Field;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FieldValidator implements ConstraintValidator<ValidField, Field> {

    @Override
    public boolean isValid(Field field, ConstraintValidatorContext context) {
        boolean isValid = true;
        context.disableDefaultConstraintViolation();

        double maxAllowedArea = field.getFarm().getTotalArea() * 0.5;

        if (field.getArea() > maxAllowedArea) {
            context.buildConstraintViolationWithTemplate("Error: Field area cannot exceed 50% of the total farm area ("
                            + maxAllowedArea + " hectares).")
                    .addPropertyNode("area")
                    .addConstraintViolation();
            isValid = false;
        }

        if (field.getFarm().getFields().size() >= 10) {
            context.buildConstraintViolationWithTemplate("Error: A farm cannot contain more than 10 fields.")
                    .addPropertyNode("farm")
                    .addConstraintViolation();
            isValid = false;
        }

        return isValid;
    }
}
