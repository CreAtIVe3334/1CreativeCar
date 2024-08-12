package com.example.CreativeCar.mapper.user;

import com.example.CreativeCar.dto.Users.CreateUserDTO;
import com.example.CreativeCar.entity.Users;
import com.example.CreativeCar.enums.Role;

public class UserCreateMapper {

    public static Users dtoToEntity(CreateUserDTO createUserDTO) {
        return Users.builder()
                .username(createUserDTO.getUsername())
                .name(createUserDTO.getName())
                .phone(createUserDTO.getPhone())
                .email(createUserDTO.getEmail())
                .role(Role.USER)
                .licence(createUserDTO.getLicence())
                .balance(0.0)
                .build();
    }
}
