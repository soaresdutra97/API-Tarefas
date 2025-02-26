package com.developer.tarefas_api.adapters.in.dto.task.request;

import com.developer.tarefas_api.application.domain.enums.TaskStatus;

import java.time.LocalDateTime;

public record TaskRequestDTO(String title,
                             String description) {
}
