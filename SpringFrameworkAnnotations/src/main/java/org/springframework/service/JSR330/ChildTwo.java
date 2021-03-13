package org.springframework.service.JSR330;

import org.springframework.models.ParentInterface;
import org.springframework.stereotype.Component;

@Component
public class ChildTwo implements ParentInterface {
    @Override
    public String name() {
        return "child two";
    }
}
