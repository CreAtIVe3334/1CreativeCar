package com.example.CreativeCar.service;

import com.example.CreativeCar.dto.CreateUserDTO;
import com.example.CreativeCar.entity.Users;
import com.example.CreativeCar.mapper.UserMapper;
import com.example.CreativeCar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users save(CreateUserDTO createUserDTO) {
        Users user = UserMapper.dtoToEntity(createUserDTO);
        return userRepository.save(user);
    }

    public Users getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
