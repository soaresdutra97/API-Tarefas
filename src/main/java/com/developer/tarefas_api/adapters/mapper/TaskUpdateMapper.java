package com.developer.tarefas_api.adapters.mapper;

import com.developer.tarefas_api.adapters.in.dto.request.TaskRequestDTO;
import com.developer.tarefas_api.adapters.out.entities.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TaskUpdateMapper {

    TaskUpdateMapper INSTANCE = Mappers.getMapper(TaskUpdateMapper.class);

    void updateTaskFromDTO(TaskRequestDTO taskRequestDTO, @MappingTarget TaskEntity taskEntity);

}
