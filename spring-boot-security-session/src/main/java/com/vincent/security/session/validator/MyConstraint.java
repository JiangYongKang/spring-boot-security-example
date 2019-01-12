package com.vincent.security.session.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Author: vincent
 * Date: 2019-01-12 12:37:00
 * Comment:
 */

public class MyConstraint implements ConstraintValidator<MyValidator, String> {

    @Override
    public void initialize(MyValidator constraintAnnotation) {
        System.out.println(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        System.out.println(value);
        return false;
    }
}
