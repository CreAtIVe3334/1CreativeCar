package com.example.CreativeCar.mapper.user;

import com.example.CreativeCar.dto.Users.GetUserDTO;
import com.example.CreativeCar.entity.Users;

public class UserGetMapper {
    public static GetUserDTO entityToDto(Users user) {
        return GetUserDTO.builder()
                .balance(user.getBalance())
                .name(user.getName())
                .username(user.getUsername())
                .build();
    }
}
