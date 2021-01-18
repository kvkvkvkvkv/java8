package com.java.java8.cmdLineRunner;

import com.java.java8.Java8Application;
import com.java.java8.model.Employee;
import com.java.java8.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class CmdLineRunner implements CommandLineRunner {

    @Autowired
    EmployeeService employeeService;

    static Logger log = LoggerFactory.getLogger(CmdLineRunner.class);

    @Override
    public void run(String... args) {
        Consumer<Employee> print = employee -> log.info("Emp name = "+employee.toString());

        log.info("***********************All EMP***********************");
        employeeService.getEmployeeNames(Java8Application.employees).forEach(employee -> print.accept(employee));

        log.info("***********************Female EMP***********************");
        employeeService.getFemaleEmployees(Java8Application.employees).forEach(employee -> print.accept(employee));

        log.info("***********************Male EMP***********************");
        employeeService.getMaleEmployees(Java8Application.employees).forEach(employee -> print.accept(employee));

        log.info("***********************EMP Age > 25***********************");
        employeeService.getEmployeesAbove25Age(Java8Application.employees).forEach(employee -> print.accept(employee));

        log.info("***********************Female Emp Age > 25***********************");
        employeeService.getFemaleEmpAbove25(Java8Application.employees).forEach(employee -> print.accept(employee));
    }
}
