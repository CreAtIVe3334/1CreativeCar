package com.example.CreativeCar.mapper.user;

import com.example.CreativeCar.dto.Users.UpdateUserDTO;
import com.example.CreativeCar.entity.Users;

public class UserUpdateMapper {

    public static Users dtoToEntity(UpdateUserDTO updateUserDTO) {
        return Users.builder()
                .phone(updateUserDTO.getUsername())
                .email(updateUserDTO.getEmail())
                .name(updateUserDTO.getName())
                .balance(updateUserDTO.getBalance())
                .licence(updateUserDTO.getLicence())
                .username(updateUserDTO.getUsername())
                .build();
    }
}
