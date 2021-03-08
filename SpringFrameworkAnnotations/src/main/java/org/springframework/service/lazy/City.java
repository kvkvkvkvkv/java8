package org.springframework.service.lazy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@Component
@Lazy
public class City {

    Logger log = Logger.getLogger("City");

    @PostConstruct
    public void init() {
        log.info("initttt city");
    }
}
