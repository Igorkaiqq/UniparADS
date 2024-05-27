package org.example.pdvapi.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = SomenteLetrasValidator.class)
@Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface SomenteLetras {

    String message() default "O campo deve conter apenas letras";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}
