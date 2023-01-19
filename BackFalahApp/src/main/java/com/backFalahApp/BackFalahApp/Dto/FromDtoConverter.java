package com.backFalahApp.BackFalahApp.Dto;


import com.backFalahApp.BackFalahApp.model.AppUser;
import com.backFalahApp.BackFalahApp.model.Category;
import com.backFalahApp.BackFalahApp.model.Comments;
import com.backFalahApp.BackFalahApp.model.Posts;

import java.util.ArrayList;
import java.util.List;

public class FromDtoConverter {



	public static AppUser fromUsersDtoConverter(final UserDto userDto)
	{
		AppUser resultUser = new AppUser(userDto.getId(),userDto.getFirstName(),userDto.getLastName(),userDto.getEmail(),userDto.getPassword());
		return resultUser;
	}


	public static Posts fromPostsDtoConverter(final PostsDto postsDto)
	{
		Posts resultPosts = new Posts(postsDto.getId(),
				fromUsersDtoConverter(postsDto.getUser()),
				fromCategoryDtoConverter(postsDto.getCategory()),
				postsDto.getTitle(),
				postsDto.isHasComments(),
				postsDto.getPostContent(),
				postsDto.getLikesCount(),
				postsDto.isAnonymous(),
				postsDto.getCommentsCount(),
				postsDto.isLikes(),
				postsDto.getCreatedDate());
			return resultPosts;
	}
	
	public static Category fromCategoryDtoConverter(final CategoryDto categoryDto)
	{
		Category resultsCategory = new Category(categoryDto.getId(),
				categoryDto.getCategoryName()
				);
		return resultsCategory;
	}
	
	public static Comments fromCommentsDtoConverter(final CommentsDto commentsDto)
	{
		Comments resultComments = new Comments(commentsDto.getId(),
				fromUsersDtoConverter(commentsDto.getUser()),
				fromPostsDtoConverter(commentsDto.getPosts()),
				commentsDto.getCommentsContent(),
				commentsDto.getLikesCount(),
				commentsDto.isAnonymous(),
				commentsDto.isLikes());
		return resultComments;   
	}
	
	
	
	public static List<Comments> fromListofCommentsDtoConverter(final List<CommentsDto> commentsDto){
		List<Comments> resultComments = new ArrayList<Comments>() ;
		Comments tempComments = null;
		for(CommentsDto thecommentsDto:commentsDto) {
			tempComments = new Comments(thecommentsDto.getId(),
					fromUsersDtoConverter(thecommentsDto.getUser()),
					fromPostsDtoConverter(thecommentsDto.getPosts()),
					thecommentsDto.getCommentsContent(),
					thecommentsDto.getLikesCount(),
					thecommentsDto.isAnonymous(),
					thecommentsDto.isLikes());
			resultComments.add(tempComments);
		}
		return resultComments;
	}
}