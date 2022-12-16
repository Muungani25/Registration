package com.example.registration.exceptions;

public class ValidationRequestException extends RuntimeException{
    public ValidationRequestException(String message) {
        super(message);
    }

}
