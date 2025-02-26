package com.example.harel.exception;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s not found with the given input data %s : '%s'", resourceName, fieldName, fieldValue));
    }
}
