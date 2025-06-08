package com.angel.spring.proyecto.prueba.springboot_prueba.service;

import java.util.Optional;

import com.angel.spring.proyecto.prueba.springboot_prueba.models.dto.User;
import com.angel.spring.proyecto.prueba.springboot_prueba.models.dto.UserDto;

public interface UserService {

    UserDto createUser(User user);

    Optional<UserDto> findById(Long id_User);

    Optional<UserDto> findByUsername(String username);

    Optional<UserDto> findByEmail(String email);

}
