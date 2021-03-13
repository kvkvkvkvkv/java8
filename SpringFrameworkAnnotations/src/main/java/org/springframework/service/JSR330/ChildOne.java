package org.springframework.service.JSR330;

import org.springframework.models.ParentInterface;
import org.springframework.stereotype.Component;

@Component
public class ChildOne implements ParentInterface {
    @Override
    public String name() {
        return "child one";
    }
}
