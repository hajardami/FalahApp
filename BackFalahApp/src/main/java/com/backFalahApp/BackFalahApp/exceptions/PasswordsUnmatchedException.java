package com.backFalahApp.BackFalahApp.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class PasswordsUnmatchedException extends RuntimeException{
    public PasswordsUnmatchedException(String password1, String password2){
        super(password1 + " != " + password2);
    }
}