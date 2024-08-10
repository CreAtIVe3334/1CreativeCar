package com.example.CreativeCar.repository;

import com.example.CreativeCar.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
