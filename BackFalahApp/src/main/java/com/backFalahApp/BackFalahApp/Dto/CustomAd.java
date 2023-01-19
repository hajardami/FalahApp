package com.backFalahApp.BackFalahApp.Dto;

import com.backFalahApp.BackFalahApp.model.AppUser;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
public interface CustomAd {
    String getId();
    String getTitle();
    LocalDateTime getCreatedat();
    String getDescription();
    String getType();
    String getEmail();
    String getFirstname();
    String getLastname();
    String getImage();
}