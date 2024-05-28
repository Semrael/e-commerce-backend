package com.workintech.eTicaret.secondHandMarket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(UserNotFoundException userNotFoundException){
        ErrorResponse response = new ErrorResponse(userNotFoundException.getMessage(),
                Instant.now());
        return new ResponseEntity<>(response, userNotFoundException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exception){
        ErrorResponse response = new ErrorResponse(exception.getMessage(),
                Instant.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
