package org.springframework.controller.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmployeeException {
    String statusCode;
    String message;
    LocalDateTime timestamp;

    public EmployeeException() {
    }
}
