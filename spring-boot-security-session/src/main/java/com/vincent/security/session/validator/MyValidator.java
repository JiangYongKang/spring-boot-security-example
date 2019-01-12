package com.vincent.security.session.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: vincent
 * Date: 2019-01-12 12:35:00
 * Comment:
 */

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyConstraint.class)
@Target(value = { ElementType.FIELD, ElementType.METHOD })
public @interface MyValidator {

    String message() default "{javax.validation.constraints.NotBlank.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
