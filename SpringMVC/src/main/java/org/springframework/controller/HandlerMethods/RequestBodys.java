package org.springframework.controller.HandlerMethods;

import org.springframework.model.Customer;
import org.springframework.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("request")
public class RequestBodys {

    Logger log = Logger.getLogger("RequestBodys");

    @PostMapping(value = "/requestBody", consumes = "application/json", produces = "application/json")
    public void requestBody(@RequestBody Employee employee){
        log.info("Customer from request"+employee.toString());
    }
}
