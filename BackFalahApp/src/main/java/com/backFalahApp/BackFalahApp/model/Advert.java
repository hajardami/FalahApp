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
public class Advert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false)
    private LocalDateTime createdat;


//    @Column(nullable = false)
//    private String category;//PARTNERSHIP, PROJECT, INFORMATION, INVESTMENT

    @Column(nullable = false)
    private String type;// premium, normal

    private String image;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "userid"
    )
    private AppUser appUser;

    public Advert(String title,
              String description,
              LocalDateTime createdat,
              String type,
              AppUser appUser,
                  String image) {
        this.title = title;
        this.description = description;
        this.createdat = createdat;
        this.type = type;
        this.appUser = appUser;
        this.image = image;
    }
}
