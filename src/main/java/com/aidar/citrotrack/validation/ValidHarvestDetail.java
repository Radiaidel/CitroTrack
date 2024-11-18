package com.aidar.citrotrack.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = HarvestDetailValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidHarvestDetail {
    String message() default "Invalid harvest detail";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
