package com.blog.BoggingProject.repository;

import com.blog.BoggingProject.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post,Integer> {
}
