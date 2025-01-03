package com.hexagonal.tasks.infrastructure.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexagonal.tasks.application.services.TaskService;
import com.hexagonal.tasks.domain.models.AdditionalTaskInfo;
import com.hexagonal.tasks.domain.models.Task;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;





@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long taskId) {
        return taskService.getTask(taskId)
                .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity(tasks, HttpStatus.OK);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task updatedTask) {
        return taskService.updateTask(taskId, updatedTask)
                .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
                
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Long taskId) {
        if (taskService.deleteTask(taskId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/{taskId}/additionalInfo")
    public ResponseEntity<AdditionalTaskInfo> getAdditionalTaskInfo(@PathVariable Long taskId) {
        AdditionalTaskInfo additionalTaskInfo = taskService.GetAdditionalTaskInfo(taskId);
        return new ResponseEntity<>(additionalTaskInfo, HttpStatus.OK);
    }
    

    

}
