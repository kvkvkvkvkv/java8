package com.java.java8.cmdLineRunner;

import com.java.java8.Java8Application;
import com.java.java8.model.Employee;
import com.java.java8.model.Project;
import com.java.java8.service.*;
import com.java.java8.service.methodreference.ConstructorMethodRef;
import com.java.java8.service.methodreference.InstanceMethod;
import com.java.java8.service.methodreference.StaticMethodReference;
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

    @Autowired
    PrimitivePredicates primitivePredicates;

    @Autowired
    PrimitiveFunction primitiveFunction;

    @Autowired
    PrimitiveBiFunction primitiveBiFunction;

    @Autowired
    PrimitiveConsumer primitiveConsumer;

    @Autowired
    PrimitiveSupplier primitiveSupplier;

    @Autowired
    UnaryOperatorFI unaryOperatorFI;

    @Autowired
    BinaryOperatorFI binaryOperatorFI;

    @Autowired
    StaticMethodReference staticMethodReference;

    @Autowired
    InstanceMethod instanceMethod;

    @Autowired
    ConstructorMethodRef constructorMethodRef;

    private static final Logger log = LoggerFactory.getLogger(CmdLineRunner.class);

    @Override
    public void run(String... args) {
        Consumer<Employee> print = employee -> log.info("Emp name = " + employee.toString());
        Consumer<Project> printProject = project -> log.info("Emp name = " + project.toString());
        objectiveTypeFunctionalInterface(print, printProject);
        primitivePredicateFI(print);
        primitiveFunctionFI(print);
        primitiveBiFunctionFI(print);
        primitiveConsumerFI();
        primitiveSupplierFI();
        unaryOperatorsFI(print);
        binaryOperatorsFI();
        staticMethodRef();
        instanceMethod(print);
        constructorMethodRef();
    }

    private void constructorMethodRef() {
        log.info("");

        log.info("*********************** Constructor Method Ref***********************");
        constructorMethodRef.constructorTestFI();

        log.info("*********************** Constructor Method Ref With Params***********************");
        constructorMethodRef.constructorTestFIWithParam();

        log.info("*********************** Test with predefined FI***********************");
        constructorMethodRef.constructorTestInbuiltFI();
    }

    private void instanceMethod(Consumer<Employee> print) {
        log.info("");

        log.info("*********************** Instance Method Ref***********************");
        print.accept(instanceMethod.staticTest());

        log.info("*********************** Instance Method Ref With Params***********************");
        print.accept(instanceMethod.staticTestWithParams());

        log.info("*********************** Test with predefined FI***********************");
        instanceMethod.staticTestWithPredefinedFI();

        log.info("*********************** Test with predefined FI - IntBinaryOperator***********************");
        log.info(String.valueOf(instanceMethod.staticTestWithPredefinedFIBinaryOperator()));

        log.info("*********************** Overloading methods ***********************");
        instanceMethod.staticTestWithOverloading();
    }

    private void staticMethodRef() {
        log.info("");

        log.info("*********************** Static Method Ref***********************");
        log.info(staticMethodReference.instanceTest().toString());

        log.info("*********************** Static Method Ref With Params***********************");
        log.info(staticMethodReference.instanceTestWithParams().toString());

        log.info("*********************** Test with predefined FI***********************");
        staticMethodReference.instanceTestWithPredefinedFI();

        log.info("*********************** Test with predefined FI - IntBinaryOperator***********************");
        log.info(String.valueOf(staticMethodReference.instanceTestWithPredefinedFIBinaryOperator()));

        log.info("*********************** Overloading static methods ***********************");
        staticMethodReference.instanceTestWithOverloading();
    }

    private void binaryOperatorsFI() {
        log.info("***********************Binary Op FI and Primitive***********************");

        log.info("*********************** Add age ***********************");
        log.info(String.valueOf(binaryOperatorFI.addAge(Java8Application.employees)));

        log.info("*********************** Age add ***********************");
        log.info(String.valueOf(binaryOperatorFI.ageAdd(Java8Application.employees)));

        log.info("*********************** min Emp ***********************");
        log.info(binaryOperatorFI.sortSalary(Java8Application.employees).toString());
    }

    private void unaryOperatorsFI(Consumer<Employee> print) {
        log.info("***********************Unary Op FI and Primitive***********************");

        log.info("*********************** Emp < 3000 ***********************");
        unaryOperatorFI.emp.apply(Java8Application.employees).forEach(print);

        log.info("*********************** Addition ***********************");
        unaryOperatorFI.sum.applyAsInt(10);
    }

    private void primitiveSupplierFI() {
        log.info("***********************Primitive Supplier***********************");

        log.info("*********************** OTP ***********************");
        log.info(String.valueOf(primitiveSupplier.supplyOTP.getAsInt()));
    }

    private void primitiveConsumerFI() {
        log.info("***********************Primitive Consumer and Bi Consumer***********************");

        log.info("***********************Salary***********************");
        primitiveConsumer.salary(Java8Application.employees);

        log.info("***********************Multiplication***********************");
        primitiveConsumer.multiplication.accept(20.4,5);
    }

    private void primitiveBiFunctionFI(Consumer<Employee> print) {
        log.info("***********************Primitive Bi Functional FI***********************");

        log.info("***********************Salary***********************");
        primitiveBiFunction.salary(Java8Application.employees).forEach(print);
    }

    private void primitiveFunctionFI(Consumer<Employee> print) {
        log.info("***********************Primitive Functional FI***********************");

        log.info("***********************Salary***********************");
        primitiveFunction.salary(Java8Application.employees).forEach(print);

        log.info("***********************  YEAR ***********************");
        log.info(String.valueOf(primitiveFunction.year()));

        log.info("***********************  PI ***********************");
        log.info(String.valueOf(primitiveFunction.number()));
    }

    private void primitivePredicateFI(Consumer<Employee> print) {
        log.info("***********************Primitive Predicate FI***********************");

        log.info("***********************Age > 20***********************");
        primitivePredicates.greaterThan20(Java8Application.employees).forEach(print);

        log.info("***********************Age > 20 and < 25***********************");
        primitivePredicates.greaterThan20AndLess25(Java8Application.employees).forEach(print);

        log.info("***********************Age > 20 or < 25***********************");
        primitivePredicates.greaterThan20OrLess25(Java8Application.employees).forEach(print);
    }

    private void objectiveTypeFunctionalInterface(Consumer<Employee> print, Consumer<Project> printProject) {
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
        projectService.getProjectsPeriodGreaterThan5Years(Java8Application.projects).forEach(printProject);

        log.info("***********************Proj 1 and 2 Males***********************");
        projectService.getMalesInProject1AndProject2(Java8Application.projects).forEach(print);

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
