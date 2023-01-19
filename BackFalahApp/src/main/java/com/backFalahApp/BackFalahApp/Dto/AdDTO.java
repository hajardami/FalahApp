package com.backFalahApp.BackFalahApp.Dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AdDTO {
    Long id;
    String firstname;
    String lastname;
    String type;
    String title;
    String description;
    LocalDateTime createdat;
    String image;
}
