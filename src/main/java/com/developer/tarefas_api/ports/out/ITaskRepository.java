package com.developer.tarefas_api.ports.out;

import com.developer.tarefas_api.application.domain.TaskDomain;
import com.developer.tarefas_api.application.domain.enums.TaskStatus;

import java.util.List;
import java.util.Optional;

public interface ITaskRepository {


    TaskDomain criarTarefa(TaskDomain taskDomain);

    List<TaskDomain> buscarTodasAsTarefas();

    Optional<TaskDomain> buscarTarefaPorId(Long id);

    void excluirTarefa(Long id);

    TaskDomain atualizarTaskPorId(TaskDomain taskDomain, Long id);

    void marcarStatusTarefa(Long id, Integer statusNum);

    List<TaskDomain> buscaTarefaPorStatus(TaskStatus status);

}