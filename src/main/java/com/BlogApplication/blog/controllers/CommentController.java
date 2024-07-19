package com.BlogApplication.blog.controllers;

import com.BlogApplication.blog.payloads.ApiResponse;
import com.BlogApplication.blog.payloads.CommentDto;
import com.BlogApplication.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@PostMapping("/post/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment, @PathVariable Integer postId) {

		CommentDto createComment = this.commentService.createComment(comment, postId);
		return new ResponseEntity<CommentDto>(createComment, HttpStatus.CREATED);
	}

	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId) {

		this.commentService.deleteComment(commentId);

		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted successfully !!", true), HttpStatus.OK);
	}

	@PutMapping("/comments/update/{commentId}")
	public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto comment,@PathVariable Integer commentId) {
		CommentDto commentDto = commentService.updateComment(commentId, comment);
		return new ResponseEntity<CommentDto>(commentDto, HttpStatus.OK);
	}




}
