package com.edstem.book.validation.publication;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class PublicationValidator implements ConstraintValidator<ValidPublication, LocalDate> {

    @Override
    public boolean isValid(LocalDate publicationDate, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate limitDate = LocalDate.of(2025, 12, 31);
        return publicationDate != null && !publicationDate.isAfter(limitDate);
    }
}
