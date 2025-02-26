package com.developer.tarefas_api.adapters.out.repositories;

import com.developer.tarefas_api.adapters.in.dto.task.request.TaskRequestDTO;
import com.developer.tarefas_api.adapters.mapper.task.TaskMapper;
import com.developer.tarefas_api.adapters.mapper.task.TaskUpdateMapper;
import com.developer.tarefas_api.adapters.out.entities.TaskEntity;
import com.developer.tarefas_api.application.domain.TaskDomain;
import com.developer.tarefas_api.application.domain.enums.TaskStatus;
import com.developer.tarefas_api.ports.out.ITaskRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TaskRepositoryImpl implements ITaskRepository {

    private final ITaskJpaRepository taskJpaRepository;
    private final TaskMapper taskMapper;

    public TaskRepositoryImpl(ITaskJpaRepository taskJpaRepository, TaskMapper taskMapper) {
        this.taskJpaRepository = taskJpaRepository;
        this.taskMapper = taskMapper;
    }


    @Override
    public TaskDomain criarTarefa(TaskDomain taskDomain) {
        return taskMapper.paraDomain(taskJpaRepository.save(taskMapper.paraEntity(taskDomain)));
    }

    @Override
    public List<TaskDomain> buscarTodasAsTarefas() {
        return taskJpaRepository.findAll().stream().map(taskMapper::paraDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<TaskDomain> buscarTarefaPorId(Long id) {
        return taskJpaRepository.findById(id).map(taskMapper::paraDomain);
    }

    @Override
    public void excluirTarefa(Long id) {
        taskJpaRepository.deleteById(id);

    }

    @Override
    public TaskDomain atualizarTaskPorId(TaskDomain taskDomain, Long id) {
        // 1. Busca a tarefa existente pelo ID
        return taskJpaRepository.findById(id)
                .map(taskEntity -> {
                    // 2. Converte TaskDomain para TaskRequestDTO (se necessário)
                    TaskRequestDTO taskRequestDTO = taskMapper.toRequest(taskDomain);

                    // 3. Atualiza os campos da tarefa existente com os valores do TaskRequestDTO
                    TaskUpdateMapper.INSTANCE.updateTaskFromDTO(taskRequestDTO, taskEntity);

                    // 4. Atualiza o campo updatedAt manualmente
                    taskEntity.setUpdatedAt(LocalDateTime.now());

                    // 5. Salva a tarefa atualizada no banco de dados
                    TaskEntity updatedEntity = taskJpaRepository.save(taskEntity);

                    // 6. Converte a entidade atualizada de volta para TaskDomain e retorna
                    return taskMapper.paraDomain(updatedEntity);
                })
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com o ID: " + id));
    }

    @Override
    public void marcarStatusTarefa(Long id, Integer statusNum) {
        taskJpaRepository.findById(id).ifPresent(task -> {
            if (statusNum < 1 || statusNum > 4) {
                throw new IllegalArgumentException("Status inválido. O status deve estar entre 1 e 4.");
            }

            if (statusNum == 1) {
                task.setStatus(TaskStatus.IN_COURSE);
            }
            if (statusNum == 2) {
                task.setStatus(TaskStatus.WAITING);
            }
            if (statusNum == 3) {
                task.setStatus(TaskStatus.COMPLETED);
            }
            if (statusNum == 4) {
                task.setStatus(TaskStatus.CANCELED);
            }

            task.setUpdatedAt(LocalDateTime.now());
            taskJpaRepository.save(task);
        });
    }

    @Override
    public List<TaskDomain> buscaTarefaPorStatus(TaskStatus status) {
        return taskJpaRepository.findByStatus(status) // Retorna List<TaskEntity>
                .stream() // Transforma a lista em um Stream<TaskEntity>
                .map(taskMapper::paraDomain) // Converte cada TaskEntity para TaskDomain
                .collect(Collectors.toList()); // Coleta os resultados em uma List<TaskDomain>
    }

}