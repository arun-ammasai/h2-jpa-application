package com.bcv.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserException extends Exception {

    public UserException() {
        super();
    }

    public UserException(String message) {
        super(message);
    }
}
