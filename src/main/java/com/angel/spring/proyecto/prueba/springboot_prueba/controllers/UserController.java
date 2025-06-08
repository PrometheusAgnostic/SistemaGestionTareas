package com.angel.spring.proyecto.prueba.springboot_prueba.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<UserDto> createUser(@RequestBody User user) {
        return Optional.ofNullable(userService.createUser(user))
        .map(userDto -> ResponseEntity.ok(userDto))
        .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id){
        return userService.findById(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/findByUsername/{username}")
    public ResponseEntity<UserDto> findByUsername(@PathVariable String username){
        return userService.findByUsername(username)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<UserDto> findByEmail(@PathVariable String email){
        return userService.findByEmail(email)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
    }

}

