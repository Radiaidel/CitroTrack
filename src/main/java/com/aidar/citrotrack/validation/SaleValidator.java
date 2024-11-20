package com.aidar.citrotrack.validation;

import com.aidar.citrotrack.model.Harvest;
import com.aidar.citrotrack.model.Sale;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SaleValidator implements ConstraintValidator<ValidSale, Sale> {
    @Override
    public boolean isValid(Sale sale, ConstraintValidatorContext context) {
        boolean isValid = true;
        context.disableDefaultConstraintViolation();

        Harvest harvest = sale.getHarvest();
        if (harvest == null) {
            context.buildConstraintViolationWithTemplate("Error: Sale must be associated with a valid harvest.")
                    .addPropertyNode("harvest")
                    .addConstraintViolation();
            return false;
        }

        double totalQuantitySold = harvest.getSaleList().stream()
                .mapToDouble(Sale::getQuantitySold)
                .sum();

        double quantitySold = sale.getQuantitySold();
        double remainingQuantity = harvest.getTotalQuantity() - totalQuantitySold;

        if (quantitySold > remainingQuantity) {
            context.buildConstraintViolationWithTemplate(
                            "Error: The quantity sold (" + quantitySold +
                                    ") exceeds the remaining available quantity (" + remainingQuantity + ").")
                    .addPropertyNode("quantitySold")
                    .addConstraintViolation();
            isValid = false;
        }

        if (quantitySold <= 0) {
            context.buildConstraintViolationWithTemplate(
                            "Error: The quantity sold must be greater than 0.")
                    .addPropertyNode("quantitySold")
                    .addConstraintViolation();
            isValid = false;
        }

        return isValid;
    }
}
