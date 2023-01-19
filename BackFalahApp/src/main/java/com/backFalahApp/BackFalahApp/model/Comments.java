package com.backFalahApp.BackFalahApp.model;


import javax.persistence.*;

@Entity
@Table(name="comments")
public class Comments extends Auditable<String> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

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

	public Comments(int id, AppUser appsuer, Posts posts, String commentsContent, int likesCount, boolean isAnonymous,
                    boolean likes) {
		super();
		this.id = id;
		this.appUser = appsuer;
		this.posts = posts;
		this.commentsContent = commentsContent;
		this.likesCount = likesCount;
		this.isAnonymous = isAnonymous;
		this.likes = likes;
	}






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


	public String getCommentsContent() {
		return commentsContent;
	}


	public void setCommentsContent(String commentsContent) {
		this.commentsContent = commentsContent;
	}



	public boolean isAnonymous() {
		return isAnonymous;
	}


	public void setAnonymous(boolean isAnonymous) {
		this.isAnonymous = isAnonymous;
	}


	public int getLikesCount() {
		return likesCount;
	}


	public void setLikesCount(int likesCount) {
		this.likesCount = likesCount;
	}


	public boolean isLikes() {
		return likes;
	}

	public void setLikes(boolean likes) {
		this.likes = likes;
	}






	@Override
	public String toString() {
		return "Comments [id=" + id + ", user=" + appUser + ", posts=" + posts + ", commentsContent=" + commentsContent
				+ ", likesCount=" + likesCount + ", isAnonymous=" + isAnonymous + ", likes=" + likes + "]";
	}


	
	
	
	
}  