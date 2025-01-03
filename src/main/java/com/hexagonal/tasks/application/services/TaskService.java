package com.hexagonal.tasks.application.services;

import java.util.List;
import java.util.Optional;

import com.hexagonal.tasks.domain.models.AdditionalTaskInfo;
import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.in.CreateTaskUseCase;
import com.hexagonal.tasks.domain.ports.in.DeleteTaskUseCase;
import com.hexagonal.tasks.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.tasks.domain.ports.in.RetrieveTaskUseCase;
import com.hexagonal.tasks.domain.ports.in.UpdateTaskUseCase;

public class TaskService implements CreateTaskUseCase, RetrieveTaskUseCase, UpdateTaskUseCase, DeleteTaskUseCase, GetAdditionalTaskInfoUseCase{

    private final CreateTaskUseCase createTaskUseCase;
    private final RetrieveTaskUseCase retrieveTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;

    

    public TaskService(CreateTaskUseCase createTaskUseCase, RetrieveTaskUseCase retrieveTaskUseCase,
            UpdateTaskUseCase updateTaskUseCase, DeleteTaskUseCase deleteTaskUseCase,
            GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.retrieveTaskUseCase = retrieveTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.getAdditionalTaskInfoUseCase = getAdditionalTaskInfoUseCase;
    }

    @Override
    public Task createTask(Task task) {
        
        return createTaskUseCase.createTask(task);
    }

    @Override
    public List<Task> getAllTasks() {
        
        return retrieveTaskUseCase.getAllTasks();
    }

    @Override
    public Optional<Task> getTask(Long id) {
        
        return retrieveTaskUseCase.getTask(id);
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
       
        return updateTaskUseCase.updateTask(id, updateTask);
    }

    @Override
    public boolean deleteTask(Long Id) {
        
        return deleteTaskUseCase.deleteTask(Id);
    }

    @Override
    public AdditionalTaskInfo GetAdditionalTaskInfo(Long id) {
        
        return getAdditionalTaskInfoUseCase.GetAdditionalTaskInfo(id);
    }
    
    
}

   
    
