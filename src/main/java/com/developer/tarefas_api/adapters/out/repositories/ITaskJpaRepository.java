package com.developer.tarefas_api.adapters.out.repositories;

import com.developer.tarefas_api.adapters.out.entities.TaskEntity;
import com.developer.tarefas_api.application.domain.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITaskJpaRepository extends JpaRepository<TaskEntity, Long> {

    List<TaskEntity> findByStatus(TaskStatus status);

}