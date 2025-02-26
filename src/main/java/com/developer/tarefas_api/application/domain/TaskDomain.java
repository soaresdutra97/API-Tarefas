package com.developer.tarefas_api.application.domain;

import com.developer.tarefas_api.application.domain.enums.TaskStatus;

import java.time.LocalDateTime;

public class TaskDomain {

    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private final UserDomain user;


    public TaskDomain(UserDomain user, LocalDateTime updatedAt, LocalDateTime createdAt, TaskStatus status, String description, String title, Long id) {
        this.user = user;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.status = status;
        this.description = description;
        this.title = title;
        this.id = id;
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

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UserDomain getUser() {
        return user;
    }
}