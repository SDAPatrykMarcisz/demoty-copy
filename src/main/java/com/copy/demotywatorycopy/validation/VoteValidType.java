package com.copy.demotywatorycopy.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = VoteTypeValidator.class)
@Target( { ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface VoteValidType {
    String message() default "niepoprawna wartość";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
