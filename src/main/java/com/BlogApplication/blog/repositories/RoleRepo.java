package com.BlogApplication.blog.repositories;


import com.BlogApplication.blog.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo  extends JpaRepository<Role, Integer> {

}
