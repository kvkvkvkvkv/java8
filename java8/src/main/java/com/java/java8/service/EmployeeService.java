package com.java.java8.service;

import com.java.java8.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    Predicate<Employee> female = employee -> employee.getGender().equalsIgnoreCase("F");
    Predicate<Employee> age = employee -> employee.getAge() >= 25;


    public List<Employee> getEmployeeNames(List<Employee> employees){
        return employees;
    }

    //predicate
    public List<Employee> getFemaleEmployees(List<Employee> employees){
        return employees.stream().filter(employee -> female.test(employee)).collect(Collectors.toList());
    }

    //predicate
    public List<Employee> getMaleEmployees(List<Employee> employees){
        return employees.stream().filter(employee -> female.test(employee)==false).collect(Collectors.toList());
    }

    //predicate
    public List<Employee> getEmployeesAbove25Age(List<Employee> employees){
        return employees.stream().filter(employee -> age.test(employee)).collect(Collectors.toList());
    }

    //predicate pairing
    //function
    public List<Employee> getFemaleEmpAbove25(List<Employee> employees){
        Function<List<Employee>,List<Employee>> getFemaleEmpAbove25 = employee -> employee.stream()
                .filter(emp -> female.and(age).test(emp))
                .collect(Collectors.toList());
        return getFemaleEmpAbove25.apply(employees);
    }

    //function chaining
    public List<Employee> getFemaleEmpAbove25(List<Employee> employees){
        Function<List<Employee>,List<Employee>> getFemaleEmpAbove25 = employee -> employee.stream()
                .filter(emp -> female.and(age).test(emp))
                .collect(Collectors.toList());
        return getFemaleEmpAbove25.apply(employees);
    }

}
