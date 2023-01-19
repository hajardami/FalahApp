package com.backFalahApp.BackFalahApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name="comments")
public class Comments extends Auditable<String>{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_user",nullable=false)
    private AppUser appUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_posts",nullable=false)
    private Posts posts;

    @Column(name="comments_content")
    private String commentsContent;

    @Column(name="likes")
    private int likesCount;

    @Column(name="is_anonymous")
    private boolean isAnonymous;

    @Column(name="has_likes", nullable=false)
    private boolean likes;



    public Comments() {

    }

    public Comments(int id, AppUser appUser, Posts posts, String commentsContent, int likesCount, boolean isAnonymous,
                    boolean likes) {
        super();
        this.id = id;
        this.appUser = appUser;
        this.posts = posts;
        this.commentsContent = commentsContent;
        this.likesCount = likesCount;
        this.isAnonymous = isAnonymous;
        this.likes = likes;
    }




}
