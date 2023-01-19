package com.backFalahApp.BackFalahApp.Dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class NouveauteRequest {
    private final String title;
    private final String description;
    private final MultipartFile image;
}
