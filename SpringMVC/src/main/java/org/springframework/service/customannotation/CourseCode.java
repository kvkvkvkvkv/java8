package org.springframework.service.customannotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD})
public @interface CourseCode {

//    uncommnet for single value check
//    public String value() default "LUV";

    public String message() default "Start with LUV";

    public String[] value() default {"LUV"};

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
