package org.springframework.controller.rest;

import org.springframework.controller.exception.EmployeeNotFoundException;
import org.springframework.model.Employee;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/rest")
public class RestCon {

    List<Employee> emps = new ArrayList<>();
    Logger log = Logger.getLogger(RestCon.class.getName());

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

        if (id >= emps.size() && id < 0){
            throw new EmployeeNotFoundException("Employee Not found for id "+id);
        }
        return emps.get(id);
    }

    @PostMapping("/emp")
    public Employee addEmp(@RequestBody Employee employee){
        emps.add(employee);
        return  employee;
    }

    @PutMapping("/emp")
    public Employee putEmp(@RequestBody Employee employee){
        for (Employee emp : emps){
            if (emp.getName().equalsIgnoreCase(employee.getName())){
                emp.setAge(employee.getAge());
            }
        }

        return employee;
    }

    @DeleteMapping("/emp/{id}")
    public List<Employee> delete(@PathVariable Integer id){

        if (id < emps.size() && id >= 0){
            log.info("remove......");
            emps.remove((int)id);
            log.info("remove......"+emps);
        } else {
            throw new EmployeeNotFoundException("Cannot delete for id "+id);
        }

        return emps;
    }

    @PatchMapping("/emp/{id}")
    public Employee putEmployee(@PathVariable Integer id, @RequestBody Employee employee){

        if (id < emps.size() && id >= 0){
            emps.get(id).setName(employee.getName());
        } else {
            throw new EmployeeNotFoundException("Cannot delete for id "+id);
        }

        return emps.get(id);
    }
}
