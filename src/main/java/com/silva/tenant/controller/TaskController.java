package com.silva.tenant.controller;

import com.silva.tenant.domain.Task;
import com.silva.tenant.domain.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Task create(@RequestBody TaskDTO dto) {
        Task task = new Task();
        task.setId(dto.getId());
        task.setTitle(dto.getTitle());
        task.setStatus(dto.getStatus());
        return repository.save(dto.toTask());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TaskDTO> getAll() {
        List<Task> all = (List<Task>) repository.findAll();
        return all.stream().map(it -> {
            TaskDTO dto = new TaskDTO();
            dto.setId(it.getId());
            dto.setTittle(it.getTitle());
            dto.setStatus(it.getStatus());
            return dto;
        }).collect(Collectors.toList()) ;
    }

    @GetMapping(path = "{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public TaskDTO getById(@PathVariable("id") Long id) {
        Task task = repository.findById(id).orElseThrow();
        return new TaskDTO(task);
    }
}
