package com.angel.spring.proyecto.prueba.springboot_prueba.test.bd;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PruebaConexion {

    private static final Logger logger = LoggerFactory.getLogger(PruebaConexion.class);

    @Autowired
    private DataSource dataSource;  

    public void probarConexion() {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Conexión exitosa: " + connection.isValid(2));
        } catch (SQLException e) {
            logger.error("Error de conexion a la base de datos", e);
        }
    }
}
