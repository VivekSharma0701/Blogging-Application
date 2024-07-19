package com.BlogApplication.blog.services;


import com.BlogApplication.blog.payloads.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto, Integer postId);

	void deleteComment(Integer commentId);

	CommentDto updateComment(Integer commentId, CommentDto comment);

}
