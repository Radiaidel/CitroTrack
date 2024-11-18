package com.aidar.citrotrack.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldValidator.class)
public @interface ValidField {
    String message() default "Les contraintes pour les champs ne sont pas respectées.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
