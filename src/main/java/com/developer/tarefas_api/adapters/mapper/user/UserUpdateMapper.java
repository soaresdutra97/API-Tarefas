package com.developer.tarefas_api.adapters.mapper.user;

import com.developer.tarefas_api.adapters.in.dto.user.request.UserRequestDTO;
import com.developer.tarefas_api.adapters.out.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserUpdateMapper {

    UserUpdateMapper INSTANCE = Mappers.getMapper(UserUpdateMapper.class);

    void updateTaskFromDTO(UserRequestDTO userRequestDTO, @MappingTarget UserEntity userEntity);
}
