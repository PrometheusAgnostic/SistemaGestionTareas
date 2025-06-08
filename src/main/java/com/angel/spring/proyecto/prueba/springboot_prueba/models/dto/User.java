package com.angel.spring.proyecto.prueba.springboot_prueba.models.dto;

public class User {

    private Long id_User;
    private String username;
    private String password;
    private String email;

    public Long getId() {
        return id_User;
    }

    public void setId(Long id) {
        this.id_User = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
