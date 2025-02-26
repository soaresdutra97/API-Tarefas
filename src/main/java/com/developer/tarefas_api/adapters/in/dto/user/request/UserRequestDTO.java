package com.developer.tarefas_api.adapters.in.dto.user.request;

import com.developer.tarefas_api.application.domain.TaskDomain;
import com.developer.tarefas_api.application.domain.enums.UserStatus;

import java.util.List;

public record UserRequestDTO(String email,
                             String cpf,
                             String nome) {
}
