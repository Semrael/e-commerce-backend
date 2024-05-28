package com.workintech.eTicaret.secondHandMarket.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

@Getter
public class UserNotFoundException extends RuntimeException{
    private HttpStatus httpStatus;

    public UserNotFoundException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
