package com.backFalahApp.BackFalahApp.model;



import com.backFalahApp.BackFalahApp.enumerations.AppUserRole;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class SuperUser extends AppUser{




    public SuperUser() {

    }

    public SuperUser(String firstname, String lastname, String email, String password, AppUserRole role, String profession, boolean isActive) {
        super(firstname, lastname, email, password, AppUserRole.ADMIN, profession, true);
    }
}

