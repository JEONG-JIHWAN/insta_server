package com.example.instaserver.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler({IllegalArgumentException.class, HttpMediaTypeNotAcceptableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleBadRequestException(Exception e){
        log.debug("Bad request exception occurred: {}", e.getMessage());
        return new ExceptionResponse(HttpStatus.BAD_REQUEST, e);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleNotFoundException(NotFoundException e){
        log.debug("Bad request exception occurred: {}", e.getMessage());
        return new ExceptionResponse(HttpStatus.NOT_FOUND, e);
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ExceptionResponse handleNotFoundException(UnauthorizedException e){
        log.debug("Bad request exception occurred: {}", e.getMessage());
        return new ExceptionResponse(HttpStatus.UNAUTHORIZED, e);
    }

    @ExceptionHandler({Exception.class, RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handlerException(Exception e) {
        log.error("Unexpected exception occurred: {}", e.getMessage(), e);
        return new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, e);
    }
}
