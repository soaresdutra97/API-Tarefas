package com.developer.tarefas_api.adapters.in.dto.user.response;

import com.developer.tarefas_api.application.domain.TaskDomain;

import java.time.LocalDateTime;
import java.util.List;

public record UserResponseDTO(Long id,
                              String email,
                              String cpf,
                              String nome,
                              List<TaskDomain> tasks,
                              LocalDateTime createdAt,
                              LocalDateTime updatedAt) {
}