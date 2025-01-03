package com.hexagonal.tasks.domain.models;

import java.time.LocalDateTime;

public class Task {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime crationDate;
    private boolean completed;

    public Task(Long id, String title, String description, boolean completed, LocalDateTime creationDate){
        this.id = id;
        this.title= title;
        this.description= description;
        this.crationDate=creationDate;
        this.completed= completed;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCrationDate() {
        return crationDate;
    }

    public void setCrationDate(LocalDateTime crationDate) {
        this.crationDate = crationDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    

}
