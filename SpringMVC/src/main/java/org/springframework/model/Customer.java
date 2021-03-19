package org.springframework.model;

import lombok.Data;
import org.springframework.service.customannotation.CourseCode;

import javax.validation.constraints.*;

@Data
public class Customer {

    String firstName;

    @NotNull(message = "Req field")
    @Size(min = 1,message = "Min length 1")
    String lastName;

    @NotNull(message = "Req field")
    @Min(value = 1,message = "min val = 1")
    @Max(value = 10,message = "max val = 10")
    Integer passes; //so you can use not null

    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "5 char")
    String postalCode;

    @CourseCode(value = {"K","LUV"}, message="Start with K or LUV")
    String courseCode;

}
