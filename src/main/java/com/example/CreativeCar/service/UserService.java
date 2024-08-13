package com.example.CreativeCar.service;

import com.example.CreativeCar.dto.Users.CreateUserDTO;
import com.example.CreativeCar.dto.Users.GetUserDTO;
import com.example.CreativeCar.dto.Users.UpdateUserDTO;
import com.example.CreativeCar.entity.Users;
import com.example.CreativeCar.exception.NotFoundException;
import com.example.CreativeCar.mapper.user.UserCreateMapper;
import com.example.CreativeCar.mapper.user.UserGetMapper;
import com.example.CreativeCar.mapper.user.UserUpdateMapper;
import com.example.CreativeCar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.CreativeCar.enums.ExceptionMessage.NOT_FOUND;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Users save(CreateUserDTO createUserDTO) {
        Users user = UserCreateMapper.dtoToEntity(createUserDTO);
        return userRepository.save(user);
    }

    public Users getUserById(Long id) {
        return userRepository.findByIdAndStatus(id, "A")
                .stream()
                .findFirst()
                .orElseThrow(() ->new NotFoundException(
                        format(
                               NOT_FOUND.getMessage(),
                                id
                        )));
    }

    public GetUserDTO getUserDTOById(Long id) {
        Users user = getUserById(id);
        return UserGetMapper.entityToDto(user);
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

    public Users updateUser(UpdateUserDTO updateUserDTO) {
        Users user = UserUpdateMapper.dtoToEntity(updateUserDTO);
        return userRepository.save(user);
    }
}
