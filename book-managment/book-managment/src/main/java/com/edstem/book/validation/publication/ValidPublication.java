package com.edstem.book.validation.publication;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PublicationValidator.class)
@Documented
public @interface ValidPublication {

    String message() default "Publication Date provided is not valid, should be before 2025-12-31";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
