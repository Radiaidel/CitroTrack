package com.aidar.citrotrack.validation;

import com.aidar.citrotrack.model.HarvestDetail;
import com.aidar.citrotrack.model.enums.TreeProductivity;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class HarvestDetailValidator implements ConstraintValidator<ValidHarvestDetail, HarvestDetail> {

    @Override
    public boolean isValid(HarvestDetail harvestDetail, ConstraintValidatorContext context) {
        boolean isValid = true;
        context.disableDefaultConstraintViolation();

        LocalDate plantingDate = harvestDetail.getTree().getPlantingDate();
        if (plantingDate == null) {
            context.buildConstraintViolationWithTemplate(
                            "Error: Planting date is required for tree validation.")
                    .addPropertyNode("tree")
                    .addConstraintViolation();
            return false;
        }

        int treeAge = TreeProductivity.calculateAge(plantingDate);

        TreeProductivity productivity = TreeProductivity.getProductivityByAge(treeAge);
        if (productivity == TreeProductivity.NON_PRODUCTIVE) {
            context.buildConstraintViolationWithTemplate(
                            "Error: Trees older than 20 years are considered non-productive and cannot be harvested.")
                    .addPropertyNode("tree")
                    .addConstraintViolation();
            isValid = false;
        }

        double maxProductivity = productivity.getProductivity();
        if (harvestDetail.getQuantity() > maxProductivity) {
            context.buildConstraintViolationWithTemplate(
                            "Error: Harvest quantity exceeds the tree's annual productivity (" + maxProductivity + " kg).")
                    .addPropertyNode("quantity")
                    .addConstraintViolation();
            isValid = false;
        }
        if (harvestDetail.getId() != null) {
            return isValid;
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
