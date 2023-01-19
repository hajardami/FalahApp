package com.backFalahApp.BackFalahApp.Dto;


import com.backFalahApp.BackFalahApp.model.AppUser;
import com.backFalahApp.BackFalahApp.model.Category;
import com.backFalahApp.BackFalahApp.model.Comments;
import com.backFalahApp.BackFalahApp.model.Posts;

import java.util.ArrayList;
import java.util.List;

public class ToDtoConverter {

	public static UserDto userToDtoConverter(final AppUser user)
	{
		UserDto resultUser = new UserDto(
				user.getId(),
				user.getFirstname(),
				user.getLastname(),
				user.getEmail(),
				user.getPassword(),
				user.getCreatedDate(),
				user.getLastModifiedDate()

				);
		return resultUser;
	}
	
	public static PostsDto postsToDtoConverter(final Posts posts)
	{
		PostsDto resultPosts = new PostsDto(posts.getId(),
				userToDtoConverter(posts.getAppUser()),
				Math.toIntExact(posts.getAppUser().getId()),
				categoryToDtoConverter(posts.getCategory()),
				posts.getCategory().getId(),
				posts.getTitle(),
				posts.isHasComments(),
				posts.getPostContent(),
				posts.getLikesCount(),
				posts.isAnonymous(),
				posts.getCommentsCount(),
				posts.getCreatedDate(),
				posts.getLastModifiedDate(),
				posts.getCreatedBy(),
				posts.isLikes());
		return resultPosts;
				
	}
	
	public static CommentsDto commentsToDtoConverter(final Comments comments)
	{
		CommentsDto resultComments = new CommentsDto(comments.getId(),
				userToDtoConverter(comments.getAppUser()),
				Math.toIntExact(comments.getAppUser().getId()),
				postsToDtoConverter(comments.getPosts()),
				comments.getPosts().getId(),
				comments.getCommentsContent(),
				comments.getLikesCount(),
				comments.isAnonymous(),
				comments.getCreatedDate(),
				comments.getLastModifiedDate(),
				comments.getCreatedBy(),
				comments.isLikes());
		return resultComments;
	}
	
	
	public static List<CommentsDto> listofCommentsToDtoConverter(final List<Comments> theComments){
		List<CommentsDto> commentsDto = new ArrayList<CommentsDto>();
		CommentsDto tempCommentsDto = new CommentsDto();
		for(Comments comments:theComments) {
			tempCommentsDto = new CommentsDto(comments.getId(),
					userToDtoConverter(comments.getAppUser()),
					Math.toIntExact(comments.getAppUser().getId()),
					postsToDtoConverter(comments.getPosts()),
					comments.getPosts().getId(),
					comments.getCommentsContent(),
					comments.getLikesCount(),
					comments.isAnonymous(),
					comments.getCreatedDate(),
					comments.getLastModifiedDate(),
					comments.getCreatedBy(),
					comments.isLikes());
			commentsDto.add(tempCommentsDto);
		}
		return commentsDto;
		
	}
	
	
	public static CategoryDto categoryToDtoConverter(final Category category)
	{
		CategoryDto resultCategory = new CategoryDto(category.getId(),
				category.getCategoryName()
				);
		return resultCategory;
	}
	
	
	
	//public static LikesDto likesToDtoConverter(final Likes likes) {
		
		
	//}
}
