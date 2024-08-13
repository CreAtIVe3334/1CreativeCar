package com.example.CreativeCar.controller;

import com.example.CreativeCar.dto.Users.CreateUserDTO;
import com.example.CreativeCar.dto.Users.GetUserDTO;
import com.example.CreativeCar.entity.Users;
import com.example.CreativeCar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("create")
    public ResponseEntity<Users> createUser(@RequestBody CreateUserDTO user) {
         return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.delete(userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<GetUserDTO> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserDTOById(userId));
    }

}
