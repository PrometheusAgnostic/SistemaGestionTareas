package com.angel.spring.proyecto.prueba.springboot_prueba.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.angel.spring.proyecto.prueba.springboot_prueba.models.dto.User;
import com.angel.spring.proyecto.prueba.springboot_prueba.models.dto.UserDto;
import com.angel.spring.proyecto.prueba.springboot_prueba.repository.interfaces.RepositoryUser;

@Service
public class ImpServiceUser implements UserService {

    @Qualifier("ImpRepositoryUser")
    private final RepositoryUser repositoryUser;

    public ImpServiceUser(RepositoryUser repositoryUser) {
        this.repositoryUser = repositoryUser;
    }

    @Override
    public UserDto createUser(User user) {
        User userSaved = repositoryUser.save(user);
        if (userSaved != null) {
            UserDto userDto = new UserDto();
            userDto.setId(userSaved.getId());
            userDto.setUsername(userSaved.getUsername());
            userDto.setEmail(userSaved.getEmail());
            return userDto;
        }
        return null;
    }

    @Override
    public UserDto findById(Long id_User) {
        Optional<User> user = repositoryUser.findById(id_User);
        if (user.isPresent()) {
            UserDto userDto = new UserDto();
            userDto.setId(user.get().getId());
            userDto.setUsername(user.get().getUsername());
            userDto.setEmail(user.get().getEmail());

            return userDto;
        }
        return null;

    }

    @Override
    public UserDto findByUsername(String username) {
       Optional<User> user = repositoryUser.findByUsername(username);
       if(user.isPresent()){
        UserDto userDto = new UserDto();
        userDto.setId(user.get().getId());
        userDto.setUsername(user.get().getUsername());  
        userDto.setEmail(user.get().getEmail());
        return userDto;
       }
       return null;
    }

    @Override
    public UserDto findByEmail(String email) {
        Optional<User> user = repositoryUser.findByEmail(email);
        if(user.isPresent()){
            UserDto userDto = new UserDto();
            userDto.setId(user.get().getId());
            userDto.setUsername(user.get().getUsername());
            userDto.setEmail(user.get().getEmail());
            return userDto;
        }
        return null;
    }
}
