package com.example.CreativeCar.service;

import com.example.CreativeCar.dto.CreateUserDTO;
import com.example.CreativeCar.entity.Users;
import com.example.CreativeCar.mapper.UserMapper;
import com.example.CreativeCar.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users save(CreateUserDTO createUserDTO) {
        Users user = UserMapper.dtoToEntity(createUserDTO);
        return userRepository.save(user);
    }
}
