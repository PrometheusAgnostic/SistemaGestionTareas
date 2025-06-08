package com.angel.spring.proyecto.prueba.springboot_prueba.repository.interfaces;

import java.util.Optional;

import com.angel.spring.proyecto.prueba.springboot_prueba.models.dto.User;

public interface RepositoryUser {

    User save(User user);
    Optional<User> findById(Long id_User);
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    
}
