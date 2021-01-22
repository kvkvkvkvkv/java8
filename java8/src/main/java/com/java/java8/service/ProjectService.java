package com.java.java8.service;

import com.java.java8.Java8Application;
import com.java.java8.model.Employee;
import com.java.java8.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    EmployeeService employeeService;

    Predicate<Project> periodGreaterThan5 = project -> project.getPeriod().getYears() >= 5;

    Function<List<Project>,List<Project>> getProjectsPeriodGreaterThan5Years = projects -> projects.stream()
            .filter(proj -> periodGreaterThan5.test(proj))
            .collect(Collectors.toList());

    public List<Project> getAllProjects() {
        return Java8Application.projects;
    }

    //function
    //predicate
    public List<Project> getProjectsPeriodGreaterThan5Years (List<Project> project){
        return getProjectsPeriodGreaterThan5Years.apply(project);
    }

    //Function chaining
    public List<Employee> getMalesInProject1AndProject2 (List<Project> project){
        //male emp
        Function<List<Employee>,List<Employee>> male = employees -> employees.stream().
                filter(employee -> !employeeService.female.test(employee))
                .collect(Collectors.toList());

        //proj > 5 years and male
        Function<List<Employee>,List<Employee>> proj = employees -> employees.stream().
                filter(employee -> employee.getProject().getName().equalsIgnoreCase("Project 1")||employee.getProject().getName().equalsIgnoreCase("Project 2"))
                .collect(Collectors.toList());

        return male.andThen(proj).apply(Java8Application.employees);
    }

    //Supplier - get
    public List<Project> addNewProject(List<Project> project){
        Supplier<LocalDate> startDate = () -> LocalDate.of(2020,1,20);
        Supplier<Period> period = () -> Period.between(startDate.get(),LocalDate.now());
        Supplier<Project> proj4 = () -> new Project("Project 4",startDate.get(),period.get(),20);
        project.add(proj4.get());

        return project;
    }
}
