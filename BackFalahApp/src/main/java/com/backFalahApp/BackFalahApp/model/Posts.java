package com.backFalahApp.BackFalahApp.model;


import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;


@Setter
@Getter
@Entity
@Indexed
@Table(name="posts")
public class Posts extends Auditable<String>{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",nullable=false)
    private int id;


//    public void setId(Long id){
//        this.id=id;
//    }
//     public Long getId(){
//        return id;
//     }



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_user",nullable=false)
    private AppUser appUser;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_category",nullable=false)
    private Category category;

    @Field
    @Column(name="title",nullable=false)
    private String title;

    @Column(name="has_comments",nullable=false)
    private boolean hasComments;

    @Field
    @Column(name="posts_content",nullable=false)
    private String postContent;

    @Column(name="likes_count")
    private int likesCount;

    @Column(name="is_anonymous",nullable=false)
    private boolean anonymous;

    @Column(name="comments_count")
    private int commentsCount;

    @Column(name="has_like", nullable = false)
    private boolean likes;

    public Posts() {

    }

    public Posts(int id, AppUser user, Category category, String title, boolean hasComments, String postContent,
                 int likesCount, boolean anonymous, int commentsCount, boolean likes) {

        this.id = id;
        this.appUser = user;
        this.category = category;
        this.title = title;
        this.hasComments = hasComments;
        this.postContent = postContent;
        this.likesCount = likesCount;
        this.anonymous = anonymous;
        this.commentsCount = commentsCount;
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Posts [id=" + id + ", user=" + appUser + ", category=" + category + ", title=" + title + ", hasComments="
                + hasComments + ", postContent=" + postContent + ", likesCount=" + likesCount + ", anonymous="
                + anonymous + ", commentsCount=" + commentsCount + ", likes=" + likes + ", getCreatedBy()="
                + getCreatedBy() + ", getCreatedDate()=" + getCreatedDate() + ", getLastModifiedBy()="
                + getLastModifiedBy() + ", getLastModifiedDate()=" + getLastModifiedDate() + "]";
    }




}
