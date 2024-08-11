package com.example.CreativeCar.service;

import com.example.CreativeCar.dto.comment.CreateCommentDTO;
import com.example.CreativeCar.entity.Car;
import com.example.CreativeCar.entity.Comment;
import com.example.CreativeCar.entity.Users;
import com.example.CreativeCar.mapper.comment.CommentCreateMapper;
import com.example.CreativeCar.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;



    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    public Comment saveComment(CreateCommentDTO createCommentDTO,Long userId,Long carId) {
        Users user = userService.getUserById(userId);
        Car car = carService.getCarById(carId);
        Comment comment = CommentCreateMapper.dtoToEntity(createCommentDTO,user,car);
        return commentRepository.save(comment);
    }



    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id).get();
        comment.setStatus("D");
        commentRepository.save(comment);
    }


}
