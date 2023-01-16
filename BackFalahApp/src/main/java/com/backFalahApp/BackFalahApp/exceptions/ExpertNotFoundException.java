package com.backFalahApp.BackFalahApp.exceptions;

public class ExpertNotFoundException extends UserNotFoundException{
    public ExpertNotFoundException(long id) {
        super("expert",id);
    }
    public ExpertNotFoundException(String email) {
        super("expert",email);
    }
}
