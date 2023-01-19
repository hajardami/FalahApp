package com.backFalahApp.BackFalahApp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Indexed;

import java.util.Date;

@Entity
@Indexed
@Table(name="posts")
public class Posts extends Auditable<String>{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable=false)
	private int id;

	public Posts() {
		super();
	}


	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_user",nullable=false)
	private AppUser appUser;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_category",nullable=false)
	private Category category;


	@Column(name="title",nullable=false)
	private String title;

	@Column(name="has_comments",nullable=false)
	private boolean hasComments;


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




	public Posts(int id, AppUser user, Category category, String title, boolean hasComments, String postContent,
				 int likesCount, boolean anonymous, int commentsCount, boolean likes, Date created) {
		super(created);

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


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isHasComments() {
		return hasComments;
	}

	public void setHasComments(boolean hasComments) {
		this.hasComments = hasComments;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}



	public int getLikesCount() {
		return likesCount;
	}



	public void setLikesCount(int likesCount) {
		this.likesCount = likesCount;
	}

	public int getCommentsCount() {
		return commentsCount;
	}



	public void setCommentsCount(int commentsCount) {
		this.commentsCount = commentsCount;
	}

	public boolean isLikes() {
		return likes;
	}

	public void setLikes(boolean likes) {
		this.likes = likes;
	}

	public boolean isAnonymous() {
		return anonymous;
	}

	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
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