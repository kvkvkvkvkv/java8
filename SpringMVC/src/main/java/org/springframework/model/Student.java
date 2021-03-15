package org.springframework.model;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class Student {

    String firstName;
    String lastName;
    String country;
    String language;

    Map<String,String>values = new LinkedHashMap();

    public Student() {
        values.put("IN","INDIA");
        values.put("EU","EUROPE");
    }
}
