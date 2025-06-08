package com.angel.spring.proyecto.prueba.springboot_prueba.test;

import org.springframework.stereotype.Component;

import com.angel.spring.proyecto.prueba.springboot_prueba.test.bd.PruebaConexion;

import jakarta.annotation.PostConstruct;

@Component
public class ConexionInicial {

    private final PruebaConexion pruebaConexion;

    public ConexionInicial(PruebaConexion pruebaConexion) {
        this.pruebaConexion = pruebaConexion;
    }

    @PostConstruct
    public void inicializar() {
        pruebaConexion.probarConexion();  
    }
}
