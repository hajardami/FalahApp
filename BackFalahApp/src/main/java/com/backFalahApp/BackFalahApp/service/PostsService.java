package com.backFalahApp.BackFalahApp.service;


import com.backFalahApp.BackFalahApp.Dto.*;
import com.backFalahApp.BackFalahApp.model.*;
import com.backFalahApp.BackFalahApp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostsService {
	
	private PostsRepository postsRepository;
	private CommentsRepository commentsRepository;
	private CategoryRepository categoryRepository;
	private PostsLikesRepository postsLikesRepository;
	private CommentsService commentsService;
	private CommentsLikesRepository commentsLikesRepository;
	@Autowired

	private  UserRepository<AppUser> userRepository;


	@Autowired
	public PostsService(PostsRepository thePostsRepository,
                        CommentsRepository theCommentsRepository,
                        CategoryRepository thecategoryRepository,
                        PostsLikesRepository thepostsLikesRepository,
                        CommentsService theCommentsService,
						UserRepository<AppUser> userRepository,
                        CommentsLikesRepository thecommentsLikesRepository)
	{
		postsRepository = thePostsRepository;
		commentsRepository = theCommentsRepository;

		categoryRepository = thecategoryRepository;
		postsLikesRepository = thepostsLikesRepository;
		commentsService = theCommentsService;
userRepository=userRepository;
		commentsLikesRepository = thecommentsLikesRepository;
	}
	
	public PostsService()
	{
		
	}
	
	//create new post
	public PostsDto createPost(PostsDto postsDto)
	{
		long userId = postsDto.getUserId();
		int categoryId = postsDto.getCategoryId();
		//find user from user Repository by userId
		Optional<AppUser> resultUser = userRepository.findById(userId);
		AppUser theUser = null;
		if(resultUser.isPresent())
		{ theUser=userRepository.getById(userId);
			//theUser=resultUser.get();
		}
		else
		{
			throw new RuntimeException("Did not find user id - " + userId);
		}
		//find category from category Repository by categoryId
		Optional<Category> resultCategory = categoryRepository.findById(categoryId);
		Category theCategory =null;
		if(resultCategory.isPresent())
		{
			theCategory = resultCategory.get();
		}
		else
		{
			throw new RuntimeException("Did not find category id - " + categoryId);
		}
		//set posts class variables and save it in post Repository
		if(postsDto.isAnonymous())
		{
			postsDto.setCreatedBy("Anonymous");
		}
		postsDto.setUser(ToDtoConverter.userToDtoConverter(theUser));
		postsDto.setCategory(ToDtoConverter.categoryToDtoConverter(theCategory));

		postsDto.setHasComments(false);
		Date date = new Date();
		postsDto.setCreatedDate(date);
		System.out.println(postsDto);
		Posts thePosts = postsRepository.save(FromDtoConverter.fromPostsDtoConverter(postsDto));
		thePosts.setCreatedDate(date);
		postsDto.setCreatedDate(thePosts.getCreatedDate());
		postsDto.setLastModifiedDate(thePosts.getLastModifiedDate());
		postsDto.setCreatedBy(thePosts.getCreatedBy());
		postsDto.setId(thePosts.getId());
		return postsDto;
		
	}
	
	//get all posts in most recently created order
	
	  public List<PostsDto> getAllPosts() {
	  
	  List<Posts> posts = postsRepository.findAllSortedByDateReverse();
	  return posts.stream().sorted(Comparator.comparing(Posts::getCreatedDate).reversed())
			  .map(ToDtoConverter::postsToDtoConverter).collect(Collectors.toList());
	  
	  }


	
	public List<PostsDto> getAllPosts(UserDto userDto) {
		 
		//find the posts from postsLikes Repository which a user has liked
		/*List<PostsLikes> postsLikes = postsLikesRepository.findByIdUser(userDto.getId());
		List<Posts> posts = postsRepository.findAllSortedByDateReverse();
		for(PostsLikes thePostsLikes:postsLikes) {
			for(Posts thePosts:posts) {
				if(thePostsLikes.getPosts().getId()==thePosts.getId()) {
					thePosts.setLikes(true);
					break;
				}
			}
		}*/
		
		//Added by Akshay for Optimization
		LinkedHashMap<Integer,Posts> theMap = new LinkedHashMap<>();
		List<Posts> posts = postsRepository.findAllSortedByDateReverse();
		for(Posts thePosts:posts)
		{
			theMap.put(thePosts.getId(), thePosts);
		}
		List<PostsLikes> postsLikes = postsLikesRepository.findByIdUser((int) userDto.getId());
		for(PostsLikes thePostsLikes:postsLikes)
		{
			int postId = thePostsLikes.getPosts().getId();
			Posts theMapPosts = theMap.get(postId);
			theMapPosts.setLikes(true);
		}
		List<Posts> resultPosts = new ArrayList<>();
		for(Map.Entry<Integer,Posts> entry :theMap.entrySet())
		{
			resultPosts.add(entry.getValue());
		}
		//End Added by Akshay for Optimization
		  return resultPosts.stream().sorted(Comparator.comparing(Posts::getCreatedDate).reversed())
				  .map(ToDtoConverter::postsToDtoConverter).collect(Collectors.toList()); 
  }
	
	
	//get post by postId
	public PostsDto getPostById(int theId)
	{
		Optional<Posts> result = postsRepository.findById(theId);
		
		Posts thePosts = null;
		if(result.isPresent())
		{
			thePosts = result.get();
		}
		else
		{	
			throw new RuntimeException("Did not find post id - " + theId);
		}
		List<CommentsDto> relatedComments;
		relatedComments = commentsService.getAllCommentsByPostId(theId);
		PostsDto thePostsDto = ToDtoConverter.postsToDtoConverter(thePosts);
		thePostsDto.setComments(relatedComments);
		return thePostsDto;
	}
	
	public PostsDto getPostById(int theId, UserDto userDto)
	{
		Optional<Posts> result = postsRepository.findById(theId);
		
		Posts thePosts = null;
		if(result.isPresent())
		{
			thePosts = result.get();
		}
		else
		{	
			throw new RuntimeException("Did not find post id - " + theId);
		}
		//List<CommentsDto> commentsDto = commentsService.getAllCommentsByPostId(theId);

		PostsDto thePostsDto = ToDtoConverter.postsToDtoConverter(thePosts);
		List<Comments> comments = commentsRepository.findByPosts(theId);
		List<CommentsLikes> commentsLikes = commentsLikesRepository.findByIdUser((int) userDto.getId());
		for(CommentsLikes theCommentsLikes:commentsLikes) {
			for(Comments thecomments:comments) {
				if(theCommentsLikes.getComment().getId()==thecomments.getId()) {
					thecomments.setLikes(true);
					break;
				}
			}
		}
		
		List<CommentsDto> commentsDto = ToDtoConverter.listofCommentsToDtoConverter(comments);
		thePostsDto.setComments(commentsDto);
		return thePostsDto;
	}
	
	//edit or update post by postId
	//@PreAuthorize("hasRole('USER')")
	public PostsDto updatePosts(Posts posts)
	{
		Optional<Posts> result = postsRepository.findById(posts.getId());
		
		Posts thePosts = null;
		if(result.isPresent())
		{
			thePosts = result.get();
		}
		else
		{
			throw new RuntimeException("Did not find the post id -" + posts.getId());
		}
	  	
		posts.setCreatedDate(thePosts.getCreatedDate());
		if(thePosts.isAnonymous())
		{
			posts.setCreatedBy("Anonymous");
		}
		else
		{
			posts.setCreatedBy(thePosts.getCreatedBy());
		}
		
		posts.setLastModifiedDate(thePosts.getLastModifiedDate());
		posts.setLastModifiedBy(thePosts.getLastModifiedBy());
		posts.setCategory(thePosts.getCategory());
		posts.setAppUser(thePosts.getAppUser());
		
		postsRepository.save(posts);
		return ToDtoConverter.postsToDtoConverter(posts);
	}
	
	//delete post by postId
	//@PreAuthorize("hasRole('USER')")
	public void deletePosts(int theId)
	{
		Optional<Posts> result = postsRepository.findById(theId);
		if(result.isPresent() == false)
		{
			throw new RuntimeException("Did not find the post id -" + theId);
		}
		List<Comments> relatedComments = commentsRepository.findByPosts(theId);
		if(relatedComments.size() > 0)
		{
			for(Comments comments : relatedComments)
			{
				commentsRepository.deleteById(comments.getId());
			}
		}
		postsRepository.deleteById(theId);
	}  
	
	//like and unlike post 
	public int likePosts(PostsLikesDto postLikeDto)
	{
		Optional<Posts> resultPost = postsRepository.findById(postLikeDto.getPostId());
		Posts findPost = null;
		PostsLikes postLikes = new PostsLikes();

		Optional<AppUser> resultUser = userRepository.findById((long) postLikeDto.getUserId());
		AppUser findUser = null;
		if(resultUser.isPresent()) {
			findUser = resultUser.get();
		}
		else {
			throw new RuntimeException("Did not find the user id -" + postLikeDto.getUserId());
		}
		
		if(resultPost.isPresent())
		{
			findPost = resultPost.get();
			PostsLikes post = postsLikesRepository.findByIdUserAndIdPosts(postLikeDto.getUserId(),postLikeDto.getPostId());
			//find if there is an entry in the postsLikesRepository, if not found then add it and increase the likes count in posts
			//prevents from having duplicate entries in the postsLikesRepository
			if(post==null && postLikeDto.isPostslikes()) {
				
					postLikes.setPosts(findPost);
					postLikes.setAppUser(findUser);
					postLikes.setPostsLikes(true);
					findPost.setLikesCount(findPost.getLikesCount()+1);
					postsRepository.save(findPost);
					postsLikesRepository.save(postLikes);
			
			}
			//if user has disliked the post and there is an entry in the postsLikesRepository
			//if the user had liked the post then there has to be an entry in the postsLikesRepository
			else if (!postLikeDto.isPostslikes() && post != null)
			{
				if(findPost.getLikesCount()>0)findPost.setLikesCount(findPost.getLikesCount()-1);
				postsRepository.save(findPost);
				//PostsLikes post = postsLikesRepository.findByIdUserAndIdPosts(postLikeDto.getUserId(),postLikeDto.getPostId());
				if(post != null)postsLikesRepository.delete(post);
				
			}
		}
		else
		{
			throw new RuntimeException("Did not find the post id -" + postLikeDto.getPostId());
		}
		
		return findPost.getLikesCount();
	}
	
	//comments count 
	public void commentsCount(int postId)
	{
		Optional<Posts> result = postsRepository.findById(postId);
		Posts findPost = null;
		if(result.isPresent())
		{
			findPost = result.get();
			List<Comments> comments = commentsRepository.findByPosts(postId);
			if(comments.isEmpty())
			{
				findPost.setCommentsCount(0);
			}
			else
			{
				findPost.setCommentsCount(comments.size());
			}
		}   
		else
		{
			throw new RuntimeException("Did not find the post id -" + postId);
		}
		postsRepository.save(findPost);
	}
	
	//get all posts by userId
	public List<PostsDto> getAllPostsByUserId(int theUserId)
	{
		List<Posts> posts = postsRepository.findByIdUser(theUserId);
		return posts.stream().sorted(Comparator.comparing(Posts::getCreatedDate).reversed())
				.map(ToDtoConverter::postsToDtoConverter).collect(Collectors.toList());
		
	}
	
	//get all posts by categoryId
	public List<PostsDto> getAllPostsByCategoryId(int theCategoryId)
	{
		List<Posts> posts = postsRepository.findByCategory(theCategoryId);
		return posts.stream().sorted(Comparator.comparing(Posts::getCreatedDate).reversed())
				.map(ToDtoConverter::postsToDtoConverter).collect(Collectors.toList());
		
	}
	

}
