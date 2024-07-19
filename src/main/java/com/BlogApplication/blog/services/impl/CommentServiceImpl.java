package com.BlogApplication.blog.services.impl;

import com.BlogApplication.blog.entities.Comment;
import com.BlogApplication.blog.entities.Post;
import com.BlogApplication.blog.exceptions.ResourceNotFoundException;
import com.BlogApplication.blog.payloads.CommentDto;
import com.BlogApplication.blog.repositories.CommentRepo;
import com.BlogApplication.blog.repositories.PostRepo;
import com.BlogApplication.blog.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private CommentRepo commentRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {

		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "post id ", postId));

		Comment comment = this.modelMapper.map(commentDto, Comment.class);

		comment.setPost(post);

		Comment savedComment = this.commentRepo.save(comment);

		return this.modelMapper.map(savedComment, CommentDto.class);
	}


	@Override
	public void deleteComment(Integer commentId) {

		Comment com = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentId", commentId));
		this.commentRepo.delete(com);
	}

	@Override
	public CommentDto updateComment(Integer commentId, CommentDto comment) {
		Comment comment1 = commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment " + commentId + " not found"));
		comment1.setContent(comment.getContent());
		return modelMapper.map(commentRepo.save(comment1), CommentDto.class);
	}

}
