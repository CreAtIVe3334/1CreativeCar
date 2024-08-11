package com.example.CreativeCar.repository;

import com.example.CreativeCar.entity.Car;
import com.example.CreativeCar.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<List<Comment>> findAllByStatus(String status);
    Optional<List<Comment>> findAllBycar(Car car);
}
