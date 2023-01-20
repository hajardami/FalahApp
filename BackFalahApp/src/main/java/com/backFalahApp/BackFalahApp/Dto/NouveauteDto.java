package com.backFalahApp.BackFalahApp.Dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class NouveauteDto {
    Long id;
    String title;
    String description;

    LocalDateTime createdat;
    String image;
}
