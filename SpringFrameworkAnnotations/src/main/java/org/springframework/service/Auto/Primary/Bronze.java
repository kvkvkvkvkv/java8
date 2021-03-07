package org.springframework.service.Auto.Primary;

import org.springframework.context.annotation.Primary;
import org.springframework.models.Medalist;
import org.springframework.service.customQualifier.Medal;
import org.springframework.service.customQualifier.Winner;
import org.springframework.service.customQualifier.Won;
import org.springframework.stereotype.Component;

@Component
@Medal
public class Bronze implements Medalist {

    @Override
    public String medal() {
        return "Bronze in da house";
    }
}
