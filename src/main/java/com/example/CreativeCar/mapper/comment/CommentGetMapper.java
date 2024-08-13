package com.example.CreativeCar.mapper.comment;

import com.example.CreativeCar.dto.comment.GetCommentDTO;
import com.example.CreativeCar.entity.Comment;

public class CommentGetMapper {
    public static GetCommentDTO entityToDto(Comment comment) {
        return GetCommentDTO.builder()
                .id(comment.getId())
                .comment(comment.getComment())
                .userId(comment.getUser().getId())
                .carId(comment.getCar().getId())
                .build();
    }
}
