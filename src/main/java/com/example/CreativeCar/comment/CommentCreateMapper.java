package com.example.CreativeCar.comment;

import com.example.CreativeCar.dto.comment.CreateCommentDTO;
import com.example.CreativeCar.entity.Car;
import com.example.CreativeCar.entity.Comment;
import com.example.CreativeCar.entity.Users;

public class CommentCreateMapper {

    public static Comment dtoToEntity(CreateCommentDTO createCommentDTO, Users user, Car car) {
        return Comment.builder()
                .comment(createCommentDTO.getComment())
                .user(user)
                .car(car)
                .build();
    }
}
