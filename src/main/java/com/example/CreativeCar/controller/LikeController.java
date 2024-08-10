package com.example.CreativeCar.controller;

import com.example.CreativeCar.entity.Like;
import com.example.CreativeCar.service.LikeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping("/{userId}/{carId}")
    @Transactional
    public ResponseEntity<Like> like(@PathVariable Long userId, @PathVariable Long carId){
        return ResponseEntity.ok(likeService.save(userId, carId));
    }
}
