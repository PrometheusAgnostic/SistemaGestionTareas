package com.angel.spring.proyecto.prueba.springboot_prueba.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.angel.spring.proyecto.prueba.springboot_prueba.models.dto.User;
import com.angel.spring.proyecto.prueba.springboot_prueba.models.dto.UserDto;
import com.angel.spring.proyecto.prueba.springboot_prueba.repository.interfaces.RepositoryUser;
import com.angel.spring.proyecto.prueba.springboot_prueba.mapper.UserMapper;

@Service
public class ImpServiceUser implements UserService {

    @Qualifier("ImpRepositoryUser")
    private final RepositoryUser repositoryUser;

    private final UserMapper userMapper;

    public ImpServiceUser(RepositoryUser repositoryUser, UserMapper userMapper) {
        this.repositoryUser = repositoryUser;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(User user) {
        User userSaved = repositoryUser.save(user);
        if (userSaved != null) {
            return userMapper.toDto(userSaved);
        }
        return null;
    }

    @Override
    public Optional<UserDto> findById(Long id_User) {
       return repositoryUser.findById(id_User)
               .map(userMapper::toDto);
               
    }

    @Override
    public Optional<UserDto> findByUsername(String username) {
        return repositoryUser.findByUsername(username)
                .map(userMapper::toDto);
    }

    @Override
    public Optional<UserDto> findByEmail(String email) {
        return repositoryUser.findByEmail(email)
                .map(userMapper::toDto);
    }

}
