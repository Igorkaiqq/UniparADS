package org.example.pdvapi.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SomenteLetrasValidator implements ConstraintValidator<SomenteLetras, String> {

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            return value != null && value.matches("[a-zA-Z]*");
        }
}
