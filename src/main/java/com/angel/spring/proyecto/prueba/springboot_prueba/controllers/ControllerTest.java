package com.angel.spring.proyecto.prueba.springboot_prueba.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class ControllerTest {


    @GetMapping("/test")
    public Map<String,Object> testMessage(){

        return Collections.singletonMap("message", "testeando Excepcion General");
    }
}



