package org.springframework.service.FortuneServiceTypes;

import org.springframework.models.Fortune;

public class HappyFortuneService implements Fortune {

    @Override
    public String getDailyFortune() {
        return "Happy day.......";
    }
}
