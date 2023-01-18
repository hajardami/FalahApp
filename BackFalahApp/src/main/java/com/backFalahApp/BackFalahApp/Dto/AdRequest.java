package com.backFalahApp.BackFalahApp.Dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AdRequest {
    private final String title;
    private final String description;
    private final String emailUser;
    private final String type;
    private final String image;
    //i should add type -> create a premium ad -> decrease coins
}