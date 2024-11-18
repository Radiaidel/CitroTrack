package com.aidar.citrotrack.model.enums;

import java.time.LocalDate;

public enum Seasons {
    SPRING,
    SUMMER ,
    WINTER ,
    FALL;

    public static Seasons fromDate(LocalDate date) {
        int month = date.getMonthValue();
        if (month == 3 || month == 4 || month == 5) {
            return SPRING;
        } else if (month == 6 || month == 7 || month == 8) {
            return SUMMER;
        } else if (month == 9 || month == 10 || month == 11) {
            return FALL;
        } else {
            return WINTER;
        }
    }
}
