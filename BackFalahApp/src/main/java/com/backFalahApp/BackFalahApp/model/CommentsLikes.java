package com.backFalahApp.BackFalahApp.model;

import javax.persistence.*;

@Entity
@Table(name="commentslikes")
public class CommentsLikes {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable=false)
	private int id;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", nullable = false)
	private AppUser appuser;
	
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

	

	public CommentsLikes(int id, AppUser user, Posts post, Comments comment, boolean like) {
		super();
		this.id = id;
		this.appuser = user;
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
		return "CommentsLikes [id=" + id + ", user=" + appuser + ", post=" + post + ", comment=" + comment + ", like="
				+ commentsLike + "]";
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AppUser getAppuser() {
		return appuser;
	}

	public void setAppuser(AppUser user) {
		this.appuser = user;
	}

	public Posts getPost() {
		return post;
	}

	public void setPost(Posts post) {
		this.post = post;
	}

	public Comments getComment() {
		return comment;
	}

	public void setComment(Comments comment) {
		this.comment = comment;
	}
	
	
	
}
