package com.backFalahApp.BackFalahApp.controller;

import com.backFalahApp.BackFalahApp.Dto.PostsDto;
import com.backFalahApp.BackFalahApp.Dto.PostsLikesDto;
import com.backFalahApp.BackFalahApp.Dto.UserDto;
import com.backFalahApp.BackFalahApp.model.Posts;
import com.backFalahApp.BackFalahApp.service.CommentsService;
import com.backFalahApp.BackFalahApp.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class PostController {

    private PostsService postsService;
    private CommentsService commentsService;



    @Autowired
    public PostController(PostsService thePostsService, CommentsService theCommentsService)
    {
        postsService = thePostsService;
        commentsService = theCommentsService;
    }



    @GetMapping("/getpostsr") public ResponseEntity<List<PostsDto>> findAllPosts()
    { List<PostsDto> posts = postsService.getAllPosts(); return new
            ResponseEntity<>(posts, HttpStatus.OK); }




    //create new post
    @PostMapping("/createpost")
    public ResponseEntity<PostsDto> createPost(@RequestBody PostsDto postsDto)
    {
        postsDto.setId(0);

        PostsDto resultPost = postsService.createPost(postsDto);
        return new ResponseEntity<>(resultPost,HttpStatus.OK);
    }


    //update or edit post
    @PostMapping("/updatepost")
    public ResponseEntity<PostsDto> updatePost(@RequestBody Posts posts)
    {
        PostsDto post = postsService.updatePosts(posts);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }


    //get post by postsId
    @PostMapping("/getpost/{postsId}")
    public ResponseEntity<?> findPostById(@PathVariable int postsId, @RequestBody UserDto userDto)
    {
        if(userDto.getId()>0) {
            PostsDto postsDto = postsService.getPostById(postsId, userDto);
            return new ResponseEntity<>(postsDto, HttpStatus.OK);
        }
        else{
            PostsDto postsDto = postsService.getPostById(postsId);
            return new ResponseEntity<>(postsDto, HttpStatus.OK);
        }

    }


    //delete post by postId
    @DeleteMapping("/deletepost/{postsId}")
    public ResponseEntity<PostsDto> deletePost(@PathVariable int postsId)
    {
        postsService.deletePosts(postsId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //like or dislike post
    @PostMapping("/likeposts")
    public ResponseEntity<?> likePost(@RequestBody PostsLikesDto postLikedto)
    {

        int likesCount = postsService.likePosts(postLikedto);
        return new ResponseEntity<>(likesCount, HttpStatus.OK);
    }


    //get posts by userId
    @GetMapping("/getposts-by-userid/{userId}")
    public ResponseEntity<List<PostsDto>> getPostsByUserId(@PathVariable int userId)
    {
        List<PostsDto> posts = postsService.getAllPostsByUserId(userId);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }


    //get posts by categoryId
    @GetMapping("/getposts-by-categoryid/{categoryId}")
    public ResponseEntity<List<PostsDto>> getPostsByCategoryId(@PathVariable int categoryId)
    {
        List<PostsDto> posts = postsService.getAllPostsByCategoryId(categoryId);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

}
