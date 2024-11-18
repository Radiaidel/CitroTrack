package com.aidar.citrotrack.validation;

import com.aidar.citrotrack.model.Tree;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.Month;
import java.time.LocalDate;

public class TreeValidator implements ConstraintValidator<ValidTree, Tree> {

    @Override
    public boolean isValid(Tree tree, ConstraintValidatorContext context) {
        boolean isValid = true;

        if (tree.getField().getTrees().size() > tree.getField().getArea() * 100) {
            context.buildConstraintViolationWithTemplate(
                            "Error: The tree density cannot exceed 100 trees per hectare (100 trees per 10,000 m²).")
                    .addPropertyNode("numberOfTrees")
                    .addConstraintViolation();
            isValid = false;
        }

        LocalDate plantingDate = tree.getPlantingDate();
        if (plantingDate != null) {
            LocalDate startDate = LocalDate.of(plantingDate.getYear(), Month.MARCH, 1);
            LocalDate endDate = LocalDate.of(plantingDate.getYear(), Month.MAY, 31);

            if (plantingDate.isBefore(startDate) || plantingDate.isAfter(endDate)) {
                context.buildConstraintViolationWithTemplate("Error: Trees can only be planted between March 1st and May 31st.")
                        .addPropertyNode("plantingDate")
                        .addConstraintViolation();
                isValid = false;
            }
        }

        return isValid;
    }
}
