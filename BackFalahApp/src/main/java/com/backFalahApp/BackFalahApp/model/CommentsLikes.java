package com.backFalahApp.BackFalahApp.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name="commentslikes")
public class CommentsLikes {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",nullable=false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private AppUser appUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_posts", nullable = false)
    private Posts post;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_comments", nullable = false)
    private Comments comment;

    @Column(name="comments_likes")
    private boolean commentsLike;



    public CommentsLikes() {
    }

    public CommentsLikes(int id, AppUser appUser, Posts post, Comments comment, boolean like) {
        super();
        this.id = id;
        this.appUser = appUser;
        this.post = post;
        this.comment = comment;
        this.commentsLike = like;
    }


    public boolean isLike() {
        return commentsLike;
    }

    public void setLike(boolean like) {
        this.commentsLike = like;
    }

    @Override
    public String toString() {
        return "CommentsLikes [id=" + id + ", user=" + appUser + ", post=" + post + ", comment=" + comment + ", like="
                + commentsLike + "]";
    }



}
