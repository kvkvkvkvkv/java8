package org.springframework.model;

import lombok.Data;

@Data
public class Student {

    String firstName;
    String lastName;
    String country;

    public Student() {
    }
}
