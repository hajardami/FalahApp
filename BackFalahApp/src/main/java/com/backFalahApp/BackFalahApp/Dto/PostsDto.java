package com.backFalahApp.BackFalahApp.Dto;

import java.util.Date;
import java.util.List;

public class PostsDto {
	
	private int id;
	
	private UserDto user;
	
	//Testing
	private long userId;
	
	private CategoryDto category;
	
	//Testing
	private int categoryId;
	
	private String title;
	
	private boolean hasComments;
	
	private String postContent;
	
	private int likesCount;
	
	private boolean anonymous;
	
	private int commentsCount;
	
	private Date createdDate;
	
	private Date lastModifiedDate;
	
	private String createdBy;
	

	//testing
	private boolean likes;

	private List<CommentsDto> comments;


	public PostsDto() {
		
	}

	

	public PostsDto(int id, UserDto user, int userId, CategoryDto category, int categoryId, String title,
                    boolean hasComments, String postContent, int likesCount, boolean anonymous, int commentsCount,
                    Date createdDate, Date lastModifiedDate, String createdBy, boolean likes) {
		
		this.id = id;
		this.user = user;
		this.userId = userId;
		this.category = category;
		this.categoryId = categoryId;
		this.title = title;
		this.hasComments = hasComments;
		this.postContent = postContent;
		this.likesCount = likesCount;
		this.anonymous = anonymous;
		this.commentsCount = commentsCount;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.createdBy = createdBy;
		this.likes = likes;
	}



	/*public PostsDto(int id, UserDto user, CategoryDto category, String title, boolean hasComments, String postContent,
			int likesCount, boolean isAnonymous, int commentsCount, Date createdDate, Date lastModifiedDate,
			String createdBy) {
		super();
		this.id = id;
		this.user = user;
		this.category = category;
		this.title = title;
		this.hasComments = hasComments;
		this.postContent = postContent;
		this.likesCount = likesCount;
		this.isAnonymous = isAnonymous;
		this.commentsCount = commentsCount;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.createdBy = createdBy;
	}*/
	
	


	public int getId() {
		return id;
	}


	

	//Added by Yashwant
	/*public PostsDto(int id, UserDto user, int userId, CategoryDto category, int categoryId, String title,
			boolean hasComments, String postContent, int likesCount, boolean isAnonymous, int commentsCount,
			Date createdDate, Date lastModifiedDate, String createdBy, boolean likes) {
		super();
		this.id = id;
		this.user = user;
		this.userId = userId;
		this.category = category;
		this.categoryId = categoryId;
		this.title = title;
		this.hasComments = hasComments;
		this.postContent = postContent;
		this.likesCount = likesCount;
		this.isAnonymous = isAnonymous;
		this.commentsCount = commentsCount;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.createdBy = createdBy;
		this.likes = likes;

	}*/


	/*public boolean isLikes() {
		return likes;
	}


	public void setLikes(boolean likes) {
		this.likes = likes;
	}*/


	public void setId(int id) {
		this.id = id;
	}


	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public CategoryDto getCategory() {
		return category;
	}


	public void setCategory(CategoryDto category) {
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


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}


	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	//Testing
	public long getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public List<CommentsDto> getComments() {
		return comments;
	}


	public void setComments(List<CommentsDto> comments) {
		this.comments = comments;
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
		return "PostsDto [id=" + id + ", user=" + user + ", userId=" + userId + ", category=" + category
				+ ", categoryId=" + categoryId + ", title=" + title + ", hasComments=" + hasComments + ", postContent="
				+ postContent + ", likesCount=" + likesCount + ", anonymous=" + anonymous + ", commentsCount="
				+ commentsCount + ", createdDate=" + createdDate + ", lastModifiedDate=" + lastModifiedDate
				+ ", createdBy=" + createdBy + ", likes=" + likes + ", comments=" + comments + "]";
	}

	
}
