package com.backFalahApp.BackFalahApp.model;

import javax.persistence.*;

@Entity
@Table(name="postslikes")
public class PostsLikes {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_posts", nullable=false)
	private Posts posts;

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_user", nullable=false)
	private AppUser appUser;
	
	@Column(name="posts_likes")
	private boolean postsLikes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Posts getPosts() {
		return posts;
	}

	public void setPosts(Posts posts) {
		this.posts = posts;
	}


	public boolean isPostsLikes() {
		return postsLikes;
	}

	public void setPostsLikes(boolean postsLikes) {
		this.postsLikes = postsLikes;
	}

	@Override
	public String toString() {
		return "PostsLikes [id=" + id + ", posts=" + posts + ", user=" + appUser + ", postsLikes=" + postsLikes + "]";
	}

	public PostsLikes(int id, Posts posts, AppUser user, boolean postsLikes) {
		super();
		this.id = id;
		this.posts = posts;
		this.appUser = user;
		this.postsLikes = postsLikes;
	}

	public PostsLikes() {
		super();
	}
	
}