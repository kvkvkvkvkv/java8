package com.java.java8;

import com.java.java8.model.Employee;
import com.java.java8.model.Project;
import com.java.java8.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Java8Application {

	public static List<Employee> employees = new ArrayList();

	public static void main(String[] args) {
		SpringApplication.run(Java8Application.class, args);
	}

	@PostConstruct
	public void init(){
	    new Project("Macd", LocalDate.of(2000,9,12), Period.between(,LocalDate.now()));

		employees.add(new Employee("Sonia", (long) 1000,"HR",20,"F"));
		employees.add(new Employee("Rob", (long) 2000,"Dev",22,"M"));
		employees.add(new Employee("Dom", (long) 1500,"Support",30,"M"));
		employees.add(new Employee("Rash", (long) 3000,"Dev",20,"F"));
		employees.add(new Employee("Ankita", (long) 1200,"HR",26,"F"));
		employees.add(new Employee("Deeps", (long) 2000,"HR",29,"F"));
		employees.add(new Employee("Praj", (long) 1800,"Support",27,"F"));
		employees.add(new Employee("Sheldon", (long) 3500,"Dev",30,"M"));
	}
}
