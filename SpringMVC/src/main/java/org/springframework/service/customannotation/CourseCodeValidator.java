package org.springframework.service.customannotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeValidator implements ConstraintValidator<CourseCode,String> {

    String[] prefix;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        prefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value != null){
            for (String pre : prefix){
                if (value.startsWith(pre)){
                    return true;
                }
            }
        }
        return false;
    }

// uncomment for single message check
//    String prefix;
//
//    @Override
//    public void initialize(CourseCode constraintAnnotation) {
//        prefix = constraintAnnotation.value();
//    }
//
//    @Override
//    public boolean isValid(String value, ConstraintValidatorContext context) {
//        return value!= null?value.startsWith(prefix):false;
//    }
//



}
