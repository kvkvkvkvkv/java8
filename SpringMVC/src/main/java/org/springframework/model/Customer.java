package org.springframework.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Customer {

    String firstName;

    @NotNull(message = "Req field")
    @Size(min = 1,message = "Min length 1")
    String lastName;

}
