package com.java.java8.cmdLineRunner;

import com.java.java8.service.optionals.Optionals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionalsRunner {

    @Autowired
    Optionals optionals;

    public void run() {
        optionals.optionalTest();

    }
}
