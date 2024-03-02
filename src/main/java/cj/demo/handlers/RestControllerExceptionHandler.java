package cj.demo.handlers;

import cj.demo.exceptions.EmployeeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(EmployeeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleEmployeeException(EmployeeException employeeException) {
        String body = String.format("The employee with Id %s have inconsistent data",
            employeeException.getEmployeeId());
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(body);
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleIllegalStateException(IllegalStateException illegalStateException) {

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(illegalStateException.getMessage());
    }


}
