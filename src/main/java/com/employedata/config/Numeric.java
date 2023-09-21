package com.employedata.config;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NumericValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Numeric {
    String message() default "Invalid numeric value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
