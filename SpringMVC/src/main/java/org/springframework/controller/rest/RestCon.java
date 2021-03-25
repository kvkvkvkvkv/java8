package org.springframework.controller.rest;

import org.springframework.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return emps.get(id);
    }
}
