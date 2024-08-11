package com.example.CreativeCar.controller;

import com.example.CreativeCar.dto.comment.CreateCommentDTO;
import com.example.CreativeCar.entity.Comment;
import com.example.CreativeCar.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/{userId}/{carId}")
    public ResponseEntity<Comment> saveCommen(@RequestBody CreateCommentDTO createCommentDTO, @PathVariable Long userId, @PathVariable Long carId) {
        return ResponseEntity.ok(commentService.saveComment(createCommentDTO,userId,carId));
    }

}
