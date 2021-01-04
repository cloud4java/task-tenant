package com.silva.tenant.controller;

import com.silva.tenant.domain.Task;
import com.silva.tenant.domain.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @PostMapping
    public Task create(Task task){
        return repository.save(task);
    }

    @GetMapping
    public List<Task> getAll(){
        return (List<Task>) repository.findAll();
    }
}
