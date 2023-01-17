package com.backFalahApp.BackFalahApp.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class WrongPasswordException extends RuntimeException{
    public WrongPasswordException(String password){
        super(password);
    }
}