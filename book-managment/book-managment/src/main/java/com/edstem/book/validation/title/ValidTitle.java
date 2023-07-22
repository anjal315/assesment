package com.edstem.book.validation.title;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TitleValidator.class)
@Documented
public @interface ValidTitle {

    String message() default "Title should contain minimum 2 letters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
