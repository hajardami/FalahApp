package com.backFalahApp.BackFalahApp.Dto;

import lombok.Data;

import java.util.Date;
@Data
public class UserDto {
    private long id;


    private String firstName;


    private String lastName;


    private String email;


    private String password;


    private Date createdDate;

    private Date lastModifiedDate;


    public UserDto(long id, String firstName, String lastName, String email, String password, Date createdDate, Date lastModifiedDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }
}
