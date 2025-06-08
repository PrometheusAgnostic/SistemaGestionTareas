package com.angel.spring.proyecto.prueba.springboot_prueba.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.angel.spring.proyecto.prueba.springboot_prueba.models.dto.User;
import com.angel.spring.proyecto.prueba.springboot_prueba.models.dto.UserDto;
import com.angel.spring.proyecto.prueba.springboot_prueba.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Qualifier("ImpServiceUser")
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser2(@RequestBody User user) {
        
        return Optional.ofNullable(userService.createUser(user))
        .map(userDto -> ResponseEntity.ok(userDto))
        .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}

