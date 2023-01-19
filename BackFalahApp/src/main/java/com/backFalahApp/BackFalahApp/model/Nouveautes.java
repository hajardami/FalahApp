package com.backFalahApp.BackFalahApp.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class Nouveautes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false)
    private LocalDateTime createdat;

    private String image;

    public Nouveautes(String title, String description, LocalDateTime createdat) {
        this.title = title;
        this.description = description;
        this.createdat = createdat;
    }
}
