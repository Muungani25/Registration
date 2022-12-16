package com.example.registration.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ValidationExceptionHandler {
    @ExceptionHandler(value={IllegalStateException.class})
    public ResponseEntity<Object> handleValidationException(IllegalStateException v){

       ValidationException validationException= new ValidationException(
                v.getMessage()
        );
       return new ResponseEntity<>(validationException, HttpStatus.BAD_REQUEST) ;
    }
}
