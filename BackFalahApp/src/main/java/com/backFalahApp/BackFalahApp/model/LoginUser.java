package com.backFalahApp.BackFalahApp.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUser {

    private String userName;
    private String password;


    public LoginUser() {

    }
    public LoginUser(String userName, String password) {

        this.userName = userName;
        this.password = password;
    }


}

