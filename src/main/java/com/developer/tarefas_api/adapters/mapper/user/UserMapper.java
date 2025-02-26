package com.developer.tarefas_api.adapters.mapper.user;

import com.developer.tarefas_api.adapters.in.dto.user.request.UserRequestDTO;
import com.developer.tarefas_api.adapters.in.dto.user.response.UserResponseDTO;
import com.developer.tarefas_api.adapters.out.entities.UserEntity;
import com.developer.tarefas_api.application.domain.UserDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity paraEntity(UserDomain userDomain);

    UserDomain paraDomain(UserEntity userEntity);

    UserDomain toDomain(UserRequestDTO userRequestDTO);

    UserResponseDTO toResponse(UserDomain userDomain);

    UserRequestDTO toRequest(UserDomain userDomain);
}
