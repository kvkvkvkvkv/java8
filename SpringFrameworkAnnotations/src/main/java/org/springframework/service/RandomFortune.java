package org.springframework.service;

import org.springframework.models.Fortune;
import org.springframework.stereotype.Component;

@Component
public class RandomFortune implements Fortune {
    @Override
    public String getDailyFortune() {
        return "Random Fortune called";
    }
}
