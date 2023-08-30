package com.nikas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nikas.model.Task;
import com.nikas.repository.TaskRepository;


@RestController
@RequestMapping("/api/todolist")
public class TaskController {
	
	@Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<Task> listarTasks() {
        return taskRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskRepository.findById(id).orElse(null);
    }
    
    @PostMapping
    public Task criarTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }
    
    @PutMapping("/{id}")
    public Task atualizarTask(@PathVariable Long id, @RequestBody Task task) {
        if (taskRepository.existsById(id)) {
            task.setId(id);
            return taskRepository.save(task);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletarTask(@PathVariable Long id) {
    	taskRepository.deleteById(id);
    }

}
