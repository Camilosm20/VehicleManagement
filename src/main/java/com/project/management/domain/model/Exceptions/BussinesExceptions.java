package com.project.management.domain.model.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BussinesExceptions extends RuntimeException {

    public BussinesExceptions(String message) {
        super(message);
    }

}
