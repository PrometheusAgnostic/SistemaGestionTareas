package com.angel.spring.proyecto.prueba.springboot_prueba.models.dto;

public class ListTasks {

    private Long idListTask;
    private String nameTask;
    private Task task;
    private User user;


    public Long getIdListTask() {
        return idListTask;
    }

    public void setIdListTask(Long idListTask) {
        this.idListTask = idListTask;
    }

    public Task getTask() {
        return task;
    }

    public User getUser() {
        return user;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    

}
