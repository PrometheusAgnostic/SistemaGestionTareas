package com.angel.spring.proyecto.prueba.springboot_prueba.service;

import com.angel.spring.proyecto.prueba.springboot_prueba.models.dto.User;
import com.angel.spring.proyecto.prueba.springboot_prueba.models.dto.UserDto;


public interface UserService {

    UserDto createUser(User user);
    UserDto findById(Long id_User);
    UserDto findByUsername(String username);
    UserDto findByEmail(String email);
    
}
