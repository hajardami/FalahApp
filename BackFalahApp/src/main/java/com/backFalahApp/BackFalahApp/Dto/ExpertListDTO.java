package com.backFalahApp.BackFalahApp.Dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
@Data
public class ExpertListDTO {
    Long id;
    String firstName;
    String lastName;
    String email;
    String profession;
    String description;
    String phone;
    String image;


    public ExpertListDTO(Long id, String firstName, String lastName, String email, String profession, String description, String phone,String image) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.profession = profession;
        this.description = description;
        this.phone = phone;
        this.image=image;
    }
}
