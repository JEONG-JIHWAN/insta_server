package com.example.instaserver.common.exception;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
    private int status;
    private String message;

    public ExceptionResponse(HttpStatus status, Throwable throwable) {
        this.status = status.value();
        this.message = throwable.getMessage();
    }
}
