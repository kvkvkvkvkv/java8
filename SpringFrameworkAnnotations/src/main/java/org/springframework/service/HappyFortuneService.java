package org.springframework.service;

import org.springframework.models.Fortune;

public class HappyFortuneService implements Fortune {

    @Override
    public String getDailyFortune() {
        return "Happy day.......";
    }
}
