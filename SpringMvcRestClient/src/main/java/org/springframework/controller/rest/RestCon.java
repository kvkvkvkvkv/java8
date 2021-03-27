package org.springframework.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.model.Employee;
import org.springframework.service.RestClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restClient")
public class RestCon {

    @Autowired
    RestClient restClient;

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable Integer id){
        return restClient.getEmployee(id);
    }

    @GetMapping("/emp")
    public List<Employee> getEmps(){
        return restClient.getEmployees();
    }

    @PostMapping("/emp")
    public Employee postEmps(@RequestBody Employee employee){
        return restClient.postEmp(employee);
    }

}
