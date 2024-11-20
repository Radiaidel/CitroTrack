package com.aidar.citrotrack.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SaleValidator.class)
public @interface ValidSale {

    String message() default " invalid data for sale";

    Class<?>[] group() default {};

    Class<? extends Payload>[] payload() default{};
}
