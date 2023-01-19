package com.backFalahApp.BackFalahApp.controller;

import com.backFalahApp.BackFalahApp.Dto.CommentsDto;
import com.backFalahApp.BackFalahApp.Dto.CommentsLikesDto;
import com.backFalahApp.BackFalahApp.model.Comments;
import com.backFalahApp.BackFalahApp.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api")
public class CommentController {

    private CommentsService commentsService ;

    @Autowired
    public CommentController(CommentsService theCommentsService)
    {
        commentsService = theCommentsService;
    }

    @PostMapping("/createcomment")
    public ResponseEntity<CommentsDto> createComment(@RequestBody CommentsDto commentDto)
    {
        commentDto.setId(0);
        CommentsDto theCommentsDto = commentsService.createComments(commentDto);
        return new ResponseEntity<>(theCommentsDto, HttpStatus.OK);
    }

    @GetMapping("/getcomments/{postId}")
    public ResponseEntity<List<CommentsDto>> getCommentByPostId(@PathVariable int postId)
    {

        List<CommentsDto> commentsDto = commentsService.getAllCommentsByPostId(postId);
        return new ResponseEntity<>(commentsDto,HttpStatus.OK);

    }

    @PutMapping("/updatecomment")
    public ResponseEntity<CommentsDto> updateComment(@RequestBody Comments comment)
    {
        commentsService.updateComments(comment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deletecomment/{commentId}")
    public ResponseEntity<CommentsDto> deleteComment(@PathVariable int commentId)
    {
        commentsService.deleteComments(commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/likecomment")
    public ResponseEntity<?> likeComment(@RequestBody CommentsLikesDto commentsLikesDto)
    {
        int commentsLikesCount = commentsService.likesComment(commentsLikesDto);
        return new ResponseEntity<>(commentsLikesCount, HttpStatus.OK);
    }
}
