package com.developer.tarefas_api.application.domain;

import com.developer.tarefas_api.application.domain.enums.UserStatus;

import java.time.LocalDateTime;
import java.util.List;

public class UserDomain {

    private Long id;
    private String email;
    private String cpf;
    private String nome;
    private List<TaskDomain> tasks;
    private UserStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserDomain() {
    }

    public UserDomain(Long id, String email, String cpf, String nome, List<TaskDomain> tasks, UserStatus status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.email = email;
        this.cpf = cpf;
        this.nome = nome;
        this.tasks = tasks;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<TaskDomain> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDomain> tasks) {
        this.tasks = tasks;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
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
}
