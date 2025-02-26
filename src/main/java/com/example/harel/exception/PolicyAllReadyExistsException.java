package com.example.harel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PolicyAllReadyExistsException extends RuntimeException {

    public PolicyAllReadyExistsException(String message) {
        super(message);
    }

}
