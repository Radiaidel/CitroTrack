package com.aidar.citrotrack.validation;

import com.aidar.citrotrack.model.Field;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FieldValidator implements ConstraintValidator<com.aidar.citrotrack.validation.ValidField, Field> {

    @Override
    public boolean isValid(Field field, ConstraintValidatorContext context) {
        boolean isValid = true;
        context.disableDefaultConstraintViolation();

        double totalFarmArea = field.getFarm().getTotalArea();
        double maxAllowedArea = totalFarmArea * 0.5;
        double usedArea = field.getFarm().getFields().stream()
                .mapToDouble(Field::getArea).sum();
        double remainingSpace = totalFarmArea - usedArea;

        if (field.getArea() > maxAllowedArea) {
            context.buildConstraintViolationWithTemplate(
                            "Error: Field area cannot exceed 50% of the total farm area ("
                                    + maxAllowedArea + " hectares).")
                    .addPropertyNode("area")
                    .addConstraintViolation();
            isValid = false;
        }

        if (field.getFarm().getFields().size() >= 10) {
            context.buildConstraintViolationWithTemplate(
                            "Error: A farm cannot contain more than 10 fields.")
                    .addPropertyNode("farm")
                    .addConstraintViolation();
            isValid = false;
        }

        if (field.getArea() > remainingSpace) {
            context.buildConstraintViolationWithTemplate(
                            "Error: The field area exceeds the remaining space in the farm ("
                                    + remainingSpace + " hectares available).")
                    .addPropertyNode("area")
                    .addConstraintViolation();
            isValid = false;
        }

        return isValid;
    }
}
