package com.backFalahApp.BackFalahApp.Dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
public class AppUserDto {
    String firstName;
    String lastName;
    Date birth_date;
    String email;
    String password;
    MultipartFile image;
    String profession;
}
