package com.developer.tarefas_api.adapters.mapper;

import com.developer.tarefas_api.adapters.in.dto.request.TaskRequestDTO;
import com.developer.tarefas_api.adapters.in.dto.response.TaskResponseDTO;
import com.developer.tarefas_api.adapters.out.entities.TaskEntity;
import com.developer.tarefas_api.application.domain.TaskDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskEntity paraEntity(TaskDomain taskDomain);
    TaskDomain paraDomain(TaskEntity taskEntity);

    TaskDomain toDomain(TaskRequestDTO task);
    TaskResponseDTO toResponse(TaskDomain task);

    TaskRequestDTO toRequest(TaskDomain taskDomain);

}