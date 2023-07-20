package com.edstem.book.validation.title;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class TitleValidator implements ConstraintValidator<ValidTitle, String> {

    @Override
    public boolean isValid(String title, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(title) && title.length() >= 2;
    }

}
