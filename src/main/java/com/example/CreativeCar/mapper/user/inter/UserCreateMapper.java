package com.example.CreativeCar.mapper.user.inter;


import com.example.CreativeCar.dto.Users.CreateUserDTO;
import com.example.CreativeCar.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserCreateMapper {
     Users dtoToEntity(CreateUserDTO createUserDTO);
}
