package com.example.CreativeCar.mapper;

import com.example.CreativeCar.dto.CreateUserDTO;
import com.example.CreativeCar.entity.Users;
import com.example.CreativeCar.enums.Role;

public class UserMapper {

    public static Users dtoToEntity(CreateUserDTO createUserDTO) {
        return Users.builder()
                .name(createUserDTO.getName())
                .phone(createUserDTO.getPhone())
                .email(createUserDTO.getEmail())
                .balance(0.0)
                .role(Role.USER)
                .username(createUserDTO.getUsername())
                .licence(createUserDTO.getLicence())
                .build();
    }
}
