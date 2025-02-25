package com.developer.tarefas_api.adapters.in.dto.response;

import com.developer.tarefas_api.application.domain.enums.TaskStatus;

import java.time.LocalDateTime;

public record TaskResponseDTO(Long id,
                              String title,
                              String description,
                              TaskStatus status,
                              LocalDateTime createdAt,
                              LocalDateTime updatedAt) {
}
