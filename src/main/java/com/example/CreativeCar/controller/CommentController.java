package com.example.CreativeCar.controller;

import com.example.CreativeCar.dto.comment.CreateCommentDTO;
import com.example.CreativeCar.entity.Comment;
import com.example.CreativeCar.service.CommentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/{userId}/{carId}")
    public ResponseEntity<Comment> saveComment(@RequestBody CreateCommentDTO createCommentDTO,
                                               @PathVariable Long userId,
                                               @PathVariable Long carId) {

        return ResponseEntity.ok(commentService.saveComment(createCommentDTO, userId, carId));
    }


    @GetMapping("/car/{carId}")  // statusu A olani verir
    public List<Comment> getCommentsByCarId(@PathVariable Long carId) {
        return commentService.getCommentsByCarId(carId);
    }

    @PostMapping("/update/{carid}/{userid}")
    public ResponseEntity<Void> updateComment(@PathVariable Long carid, @PathVariable Long userid, @RequestBody String newComment) {
        commentService.updateCommentByCarAndUser(carid, userid, newComment);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {

            commentService.deleteComment(id);
            return ResponseEntity.noContent().build();

    }


    @GetMapping("/user/{userId}")
    public List<Comment> getCommentsByUserId(@PathVariable Long userId) {
        return commentService.getCommentsByUserId(userId);
    }
}
