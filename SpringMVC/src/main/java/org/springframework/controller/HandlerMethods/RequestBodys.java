package org.springframework.controller.HandlerMethods;

import org.springframework.model.Customer;
import org.springframework.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@Controller
@RequestMapping("request")
public class RequestBodys {

    Logger log = Logger.getLogger("RequestBodys");

    @RequestMapping("/get")
    @ResponseBody
    public Employee getEmp(){
        return new Employee("Yo","2");
    }

    @RequestMapping("/post")
    @ResponseBody
    public Employee getEmp(@RequestBody Employee employee){
        return employee;
    }
}
