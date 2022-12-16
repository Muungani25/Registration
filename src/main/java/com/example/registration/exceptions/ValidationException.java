package com.example.registration.exceptions;

public class ValidationException {
    private final String message;
    public ValidationException(String message)

    {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

}
