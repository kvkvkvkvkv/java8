package org.springframework.controller.rest;

import org.springframework.controller.exception.EmployeeNotFoundException;
import org.springframework.model.Employee;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestCon {

    List<Employee> emps = new ArrayList<>();

    @PostConstruct
    public void init(){
        emps.add(new Employee("Yo","12"));
        emps.add(new Employee("Lo","22"));

    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }

    @GetMapping("/emp")
    public List<Employee> getEmps(){
        return emps;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmpsById(@PathVariable Integer id){

        if (id >= emps.size() || id <= emps.size()){
            throw new EmployeeNotFoundException("Employee Not found for id "+id);
        }
        return emps.get(id);
    }
}
