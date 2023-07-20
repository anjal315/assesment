package com.edstem.book.validation.author;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class AuthorValidator implements ConstraintValidator<ValidAuthor, String> {

    @Override
    public boolean isValid(String author, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(author) && author.split(" ").length >= 2;
    }

}
