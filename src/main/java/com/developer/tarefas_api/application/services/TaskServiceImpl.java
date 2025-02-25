package com.developer.tarefas_api.application.services;

import com.developer.tarefas_api.adapters.in.ITaskService;
import com.developer.tarefas_api.application.domain.TaskDomain;
import com.developer.tarefas_api.application.domain.enums.TaskStatus;
import com.developer.tarefas_api.ports.out.ITaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements ITaskService {

    private final ITaskRepository iTaskRepository;

    public TaskServiceImpl(ITaskRepository iTaskRepository) {
        this.iTaskRepository = iTaskRepository;
    }

    @Override
    public TaskDomain criarTarefa(TaskDomain task) {
        return iTaskRepository.criarTarefa(task);
    }

    @Override
    public List<TaskDomain> buscarTodasAsTarefas() {
        return iTaskRepository.buscarTodasAsTarefas();
    }

    @Override
    public Optional<TaskDomain> buscarTarefaPorId(Long id) {
        return iTaskRepository.buscarTarefaPorId(id);
    }

    @Override
    public TaskDomain atualizarTaskPorId(TaskDomain taskDomain, Long id) {
        return iTaskRepository.atualizarTaskPorId(taskDomain, id);
    }

    @Override
    public void excluirTarefa(Long id) {
        iTaskRepository.excluirTarefa(id);
    }

    @Override
    public void marcarStatusTarefa(Long id, Integer statusNum) {
        iTaskRepository.marcarStatusTarefa(id, statusNum);
    }

    @Override
    public List<TaskDomain> buscaTarefaPorStatus(TaskStatus status) {
        return iTaskRepository.buscaTarefaPorStatus(status);
    }
}