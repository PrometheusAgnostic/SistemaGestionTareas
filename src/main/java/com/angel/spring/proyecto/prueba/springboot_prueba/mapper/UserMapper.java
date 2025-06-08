package com.angel.spring.proyecto.prueba.springboot_prueba.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.angel.spring.proyecto.prueba.springboot_prueba.models.dto.User;
import com.angel.spring.proyecto.prueba.springboot_prueba.models.dto.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    @Mapping(target = "password", ignore = true)  // Ignora password en el DTO
    User toEntity(UserDto userDto);
    
}
