package org.springframework.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeException> handleException(EmployeeNotFoundException employeeNotFoundException){

        EmployeeException employeeException = new EmployeeException();
        employeeException.setStatusCode(HttpStatus.NOT_FOUND.name());
        employeeException.setMessage(employeeNotFoundException.getMessage());
        employeeException.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(employeeException,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeException> handleException(Exception exception){

        EmployeeException employeeException = new EmployeeException();
        employeeException.setStatusCode(HttpStatus.BAD_REQUEST.name());
        employeeException.setMessage(exception.getMessage());
        employeeException.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(employeeException,HttpStatus.BAD_REQUEST);
    }
}
