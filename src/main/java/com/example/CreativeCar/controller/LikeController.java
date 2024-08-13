package com.example.CreativeCar.controller;

import com.example.CreativeCar.entity.Like;
import com.example.CreativeCar.service.LikeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/{userId}/{carId}")
    @Transactional
    public ResponseEntity<Like> like(@PathVariable Long userId, @PathVariable Long carId){
        return ResponseEntity.ok(likeService.save(userId, carId));
    }

    @DeleteMapping("/{userId}/{carId}")
    public ResponseEntity<Void> delete(@PathVariable Long userId, @PathVariable Long carId){
        likeService.delete(userId, carId);
        return ResponseEntity.ok().build();
    }
}
