package com.example.CreativeCar.service;

import com.example.CreativeCar.dto.Users.CreateUserDTO;
import com.example.CreativeCar.entity.Users;
import com.example.CreativeCar.mapper.UserMapper;
import com.example.CreativeCar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users save(CreateUserDTO createUserDTO) {
        Users user = UserMapper.dtoToEntity(createUserDTO);
        return userRepository.save(user);
    }

    public Users getUserById(Long id) {
        return userRepository.findByIdAndStatus(id,"A").orElse(null);
    }

    public void delete(Long id) {
       Optional<Users> user = userRepository.findByIdAndStatus(id, "A");
       if(user.isPresent()){
           user.get().setStatus("D");
           userRepository.save(user.get());
       }
    }

    public Users getUserByUsername(String username) {
        Optional<Users> users = userRepository.findByUsernameAndStatus(username,"A");
        return users.orElse(null);
    }

    public Users updateUser(CreateUserDTO createUserDTO) {
        Users user = UserMapper.dtoToEntity(createUserDTO);
        return userRepository.save(user);
    }
}
