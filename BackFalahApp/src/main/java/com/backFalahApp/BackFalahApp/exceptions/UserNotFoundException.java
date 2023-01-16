package com.backFalahApp.BackFalahApp.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String accountType, long id){
        super(accountType+" not found with id : " + id);
    }
    public UserNotFoundException(String accountType, String email){
        super(accountType+" not found with email : " + email);
    }
    public UserNotFoundException(long id) {
        this("User",id);
    }

    public UserNotFoundException(String email) {
        this("User",email);
    }
}
