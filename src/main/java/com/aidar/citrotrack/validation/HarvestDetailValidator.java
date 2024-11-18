package com.aidar.citrotrack.validation;

import com.aidar.citrotrack.model.HarvestDetail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class HarvestDetailValidator implements ConstraintValidator<ValidHarvestDetail, HarvestDetail> {

    @Override
    public boolean isValid(HarvestDetail harvestDetail, ConstraintValidatorContext context) {
        boolean isValid = true;
        context.disableDefaultConstraintViolation();

        LocalDate plantingDate = harvestDetail.getTree().getPlantingDate();
        if (plantingDate != null && plantingDate.plusYears(20).isBefore(LocalDate.now())) {
            context.buildConstraintViolationWithTemplate(
                            "Error: Trees older than 20 years are considered non-productive and cannot be harvested.")
                    .addPropertyNode("tree")
                    .addConstraintViolation();
            isValid = false;
        }
        double maxProductivity = harvestDetail.getTree().getProductivity().getProductivityAge(); // Productivité déjà calculée
        if (harvestDetail.getQuantity() > maxProductivity) {
            context.buildConstraintViolationWithTemplate(
                            "Error: Harvest quantity exceeds the tree's annual productivity (" + maxProductivity + " kg).")
                    .addPropertyNode("quantity")
                    .addConstraintViolation();
            isValid = false;
        }

        boolean alreadyHarvested = harvestDetail.getTree().getHarvestDetails()
                .stream()
                .anyMatch(hd -> hd.getHarvest().getSeason()
                        .equals(harvestDetail.getHarvest().getSeason()));

        if (alreadyHarvested) {
            context.buildConstraintViolationWithTemplate(
                            "Error: A tree cannot be included in more than one harvest for the same season.")
                    .addPropertyNode("tree")
                    .addConstraintViolation();
            isValid = false;
        }

        return isValid;
    }
}
