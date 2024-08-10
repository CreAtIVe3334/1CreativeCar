package com.example.CreativeCar.mapper.user;

import com.example.CreativeCar.dto.Users.CreateUserDTO;
import com.example.CreativeCar.dto.Users.GetUserDTO;
import com.example.CreativeCar.entity.Car;
import com.example.CreativeCar.entity.Users;
import com.example.CreativeCar.enums.Role;

public class UserCreateMapper {

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

    public static GetUserDTO entityToDto(Users users, Car car) {
        return GetUserDTO.builder()
                .name(users.getName())
                .balance(users.getBalance())
                .carName(car.getBrand()).build();
    }
}
