package com.example.CreativeCar.controller;

import com.example.CreativeCar.dto.CreateUserDTO;
import com.example.CreativeCar.entity.Users;
import com.example.CreativeCar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("create")
    public ResponseEntity<Users> createUser(@RequestBody CreateUserDTO user) {
         return ResponseEntity.ok(userService.save(user));

    }
}
