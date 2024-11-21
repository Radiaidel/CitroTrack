package com.aidar.citrotrack.model.enums;

import java.time.LocalDate;
import java.time.Period;

public enum TreeProductivity {
    YOUNG(2.5),
    MATURE(12),
    OLD(20),
    NON_PRODUCTIVE(0);

    private final double productivity;

    TreeProductivity(double productivity) {
        this.productivity = productivity;
    }

    public double getProductivity() {
        return productivity;
    }

    public static int calculateAge(LocalDate plantingDate) {
        if (plantingDate == null) {
            throw new IllegalArgumentException("Planting date cannot be null.");
        }
        return Period.between(plantingDate, LocalDate.now()).getYears();
    }

    public static TreeProductivity getProductivityByAge(int age) {
        if (age < 3) {
            return YOUNG;
        } else if (age >= 3 && age <= 10) {
            return MATURE;
        } else if (age > 10 && age < 20) {
            return OLD;
        } else {
            return NON_PRODUCTIVE;
        }
    }
}
