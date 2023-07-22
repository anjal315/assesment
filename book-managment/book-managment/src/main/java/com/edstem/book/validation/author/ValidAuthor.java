package com.edstem.book.validation.author;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AuthorValidator.class)
@Documented
public @interface ValidAuthor {

    String message() default "Author provided is not valid, should have 2 names separated by space";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
