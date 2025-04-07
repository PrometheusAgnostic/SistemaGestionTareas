package com.angel.spring.proyecto.prueba.springboot_prueba.exceptions.general;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.angel.spring.proyecto.prueba.springboot_prueba.models.dto.Error;



@RestControllerAdvice
public class ControllerExcepctionGeneral {

@ExceptionHandler(NoResourceFoundException.class)
public ResponseEntity<Error> notFound(NoResourceFoundException e) {
   Error dtoError = new Error();
   dtoError.setMessage("Pagina inexistente");
   dtoError.setStatus(HttpStatus.NOT_FOUND.value());
   dtoError.setExceptionMessage(e.getMessage());
   dtoError.setDateError(new Date());

    return ResponseEntity.status(404).body(dtoError);
}

}
