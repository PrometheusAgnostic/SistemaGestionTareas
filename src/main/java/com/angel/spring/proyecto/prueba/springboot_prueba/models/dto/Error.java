package com.angel.spring.proyecto.prueba.springboot_prueba.models.dto;

import java.util.Date;

public class Error {
 private String message;
 private int status;
 private String exceptionMessage;
 private Date dateError;
 
public String getMessage() {
    return message;
}

public void setMessage(String message) {
    this.message = message;
}

public int getStatus() {
    return status;
}
public void setStatus(int status) {
    this.status = status;
}


public String getExceptionMessage() {
    return exceptionMessage;
}
public void setExceptionMessage(String exceptionMessage) {
    this.exceptionMessage = exceptionMessage;
}


public Date getDateError() {
    return dateError;
}
public void setDateError(Date dateError) {
    this.dateError = dateError;
}



}
