package com.silva.tenant.controller;

import com.silva.tenant.domain.Task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

public class TaskDTO implements Serializable {
    private Long id;
    private String title;
    private Integer status;


    public TaskDTO(Task task) {
//        TaskDTO dto = new TaskDTO();
        setStatus(task.getStatus());
        setTittle(task.getTitle());
        setId(task.getId());
    }

    public TaskDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTittle(String tittle) {
        this.title = tittle;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Task toTask(){
        Task task = new Task();
        task.setId(this.id);
        task.setTitle(this.title);
        task.setStatus(this.status);
    return  task;
    }
}
