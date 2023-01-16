package com.backFalahApp.BackFalahApp.Dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Data
public class ExpertDto
{
    String firstName;
    String lastName;
    Date birth_date;
    String email;
    String password;
    MultipartFile identityDocument;
    MultipartFile expertCertificate;
    MultipartFile image;
   String profession;



}
