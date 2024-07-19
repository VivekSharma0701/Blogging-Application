package com.BlogApplication.blog.repositories;

import com.BlogApplication.blog.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

;

public interface CommentRepo  extends JpaRepository<Comment, Integer> {

}
