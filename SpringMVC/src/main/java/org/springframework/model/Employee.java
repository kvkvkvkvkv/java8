package org.springframework.model;

import lombok.Data;

@Data
public class Employee {
    String name;
    String age;

    public Employee(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Employee() {
    }
}
