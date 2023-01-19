package com.backFalahApp.BackFalahApp.model;

import com.backFalahApp.BackFalahApp.enumerations.AppUserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "appuser")
public class AppUser {

    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;

    private String firstname;

    private String lastname;

    public AppUser(String firstname, String lastname, String email, String password, AppUserRole role, String profession, String personalphoto) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.profession = profession;
        this.personalphoto = personalphoto;
    }

    public AppUser(String firstname, String lastname, String email, String password, AppUserRole role, String profession) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.profession = profession;
    }
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AppUserRole role;


    private String status;

    private String profession;

    private String personalphoto;
    @Column(name = "isActive", columnDefinition = "BOOLEAN default TRUE")
    private boolean isActive;

    public AppUser(String firstname, String lastname, String email, String password, AppUserRole role, String profession, boolean isActive) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.profession = profession;
        this.isActive = isActive;
    }


    public boolean isActive() {
        return isActive;
    }





}
