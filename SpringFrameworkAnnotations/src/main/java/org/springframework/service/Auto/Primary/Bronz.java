package org.springframework.service.Auto.Primary;

import org.springframework.models.Medalist;
import org.springframework.stereotype.Component;

@Component
public class Bronz implements Medalist {

    @Override
    public String medal() {
        return "Bronze in da house";
    }
}
