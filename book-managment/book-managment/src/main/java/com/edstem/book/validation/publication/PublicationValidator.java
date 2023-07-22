package com.edstem.book.validation.publication;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class PublicationValidator implements ConstraintValidator<ValidPublication, LocalDate> {

    @Override
    public boolean isValid(
            LocalDate publicationDate, ConstraintValidatorContext constraintValidatorContext) {
        return publicationDate != null && !publicationDate.isAfter(LocalDate.now());
    }
}
