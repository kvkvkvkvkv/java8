package org.springframework.service.Auto.Primary;

import org.springframework.models.Medalist;
import org.springframework.stereotype.Component;

@Component
public class Silver implements Medalist {

    @Override
    public String medal() {
        return "Silver in da house";
    }
}
