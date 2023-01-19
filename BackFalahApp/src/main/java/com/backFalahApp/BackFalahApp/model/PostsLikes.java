package com.backFalahApp.BackFalahApp.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name="postslikes")
public class PostsLikes {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_posts", nullable=false)
    private Posts posts;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_user", nullable=false)
    private AppUser appUser;


    @Column(name="posts_likes")
    private boolean postsLikes;


    @Override
    public String toString() {
        return "PostsLikes [id=" + id + ", posts=" + posts + ", user=" + appUser + ", postsLikes=" + postsLikes + "]";
    }

    public PostsLikes(int id, Posts posts, AppUser appUser, boolean postsLikes) {
        super();
        this.id = id;
        this.posts = posts;
        this.appUser = appUser;
        this.postsLikes = postsLikes;
    }

    public PostsLikes() {
        super();
    }

}
