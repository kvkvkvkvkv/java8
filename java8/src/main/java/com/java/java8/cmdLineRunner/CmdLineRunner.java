package com.java.java8.cmdLineRunner;

import com.java.java8.Java8Application;
import com.java.java8.model.Employee;
import com.java.java8.model.Project;
import com.java.java8.service.EmployeeService;
import com.java.java8.service.ProjectService;
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

    @Autowired
    ProjectService projectService;

    private static Logger log = LoggerFactory.getLogger(CmdLineRunner.class);

    @Override
    public void run(String... args) {
        Consumer<Employee> print = employee -> log.info("Emp name = " + employee.toString());
        Consumer<Project> printProject = project -> log.info("Emp name = " + project.toString());

        log.info("***********************All EMP***********************");
        employeeService.getEmployeeNames(Java8Application.employees).forEach(print);

        log.info("***********************Female EMP***********************");
        employeeService.getFemaleEmployees(Java8Application.employees).forEach(print);

        log.info("***********************Male EMP***********************");
        employeeService.getMaleEmployees(Java8Application.employees).forEach(print);

        log.info("***********************EMP Age > 25***********************");
        employeeService.getEmployeesAbove25Age(Java8Application.employees).forEach(print);

        log.info("***********************Female Emp Age > 25***********************");
        employeeService.getFemaleEmpAbove25(Java8Application.employees).forEach(print);

        log.info("***********************All Projects***********************");
        Java8Application.projects.forEach(printProject);

        log.info("***********************Project Year >= 5***********************");
        projectService.getProjectsPeriodGreaterThan5Years(Java8Application.projects).forEach(printProject::accept);

        log.info("***********************Proj 1 and 2 Males***********************");
        projectService.getMalesInProject1AndProject2(Java8Application.projects).forEach(print::accept);

        log.info("***********************Proj 3 or Above 25***********************");
        employeeService.getEmployeesAbove25OrWorkingInProject3(Java8Application.employees).forEach(print);

        log.info("***********************Equal Pay Employees***********************");
        employeeService.getEqualPayEmployees(Java8Application.employees).forEach(print);

        log.info("***********************Salary Hike***********************");
        employeeService.salaryHikeForProject1orSalaryAbove1000(Java8Application.employees).forEach(print);

        log.info("***********************Salary Hike above 2000***********************");
        employeeService.salaryHikeForProject1orSalaryAbove2000(Java8Application.employees).forEach(print);

        log.info("***********************All EMP***********************");
        employeeService.getEmployeeNames(Java8Application.employees).forEach(print);

        log.info("***********************New Project***********************");
        projectService.addNewProject(Java8Application.projects).forEach(printProject);

        log.info("***********************Increment Age and Salary**********************");
        employeeService.incrementAgeAndSalary(Java8Application.employees).forEach(print);

        log.info("***********************HR in Project 1**********************");
        projectService.getHrinProject1(Java8Application.employees).forEach(print);

        log.info("***********************HR in Project 1 or Project 2**********************");
        projectService.getHrinProjec1orProject2(Java8Application.employees).forEach(print);

        log.info("***********************Not HR in Project 1**********************");
        projectService.getnotHrInProject1(Java8Application.employees).forEach(print);

        log.info("***********************HR in Project 1 and Sal above 3000**********************");
        projectService.getHrInProject1AndSalaryAbove3000(Java8Application.employees).forEach(print);

        log.info("***********************All EMP***********************");
        employeeService.getEmployeeNames(Java8Application.employees).forEach(print);

        log.info("***********************Period > 5***********************");
        projectService.getPeriodMoreThan5(Java8Application.employees).forEach(print);

        log.info("***********************Get All starts with S***********************");
        projectService.getAllInProject1AndNameStartsWithS(Java8Application.employees).forEach(print);

        log.info("***********************Update Age and Size***********************");
        projectService.updateAgeAndSize(Java8Application.employees);

        log.info("***********************Update Sal and Period***********************");
        projectService.updateSalandPeriod(Java8Application.employees);

        log.info("***********************All EMP***********************");
        employeeService.getEmployeeNames(Java8Application.employees).forEach(print);
    }
}
