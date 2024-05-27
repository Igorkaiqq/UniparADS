package org.example.pdvapi.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String> {

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            return value != null && value.matches("[a-zA-Z]*");
        }
}
