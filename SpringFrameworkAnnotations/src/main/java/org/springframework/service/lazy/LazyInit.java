package org.springframework.service.lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//over config over sutowired/component

@Component
public class LazyInit {

    @Lazy
    @Autowired
    City city;

    public City getCity() {
        return city;
    }
}
