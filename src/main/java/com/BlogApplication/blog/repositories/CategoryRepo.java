package com.BlogApplication.blog.repositories;

import com.BlogApplication.blog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
