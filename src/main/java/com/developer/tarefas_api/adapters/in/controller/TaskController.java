package com.developer.tarefas_api.adapters.in.controller;

import com.developer.tarefas_api.adapters.in.ITaskService;
import com.developer.tarefas_api.adapters.in.dto.request.TaskRequestDTO;
import com.developer.tarefas_api.adapters.in.dto.response.TaskResponseDTO;
import com.developer.tarefas_api.adapters.mapper.TaskMapper;
import com.developer.tarefas_api.adapters.out.entities.TaskEntity;
import com.developer.tarefas_api.application.domain.TaskDomain;
import com.developer.tarefas_api.application.domain.enums.TaskStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/task")
@Tag(name = "Tarefas")
public class TaskController {

    private final ITaskService iTaskService;
    private final TaskMapper taskMapper;

    public TaskController(ITaskService iTaskService, TaskMapper taskMapper) {
        this.iTaskService = iTaskService;
        this.taskMapper = taskMapper;
    }

    @Operation(summary = "Criar Tarefa", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa criado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao criar tarefa"),
    })
    @PostMapping
    public ResponseEntity<TaskResponseDTO> criarTarefa(@RequestBody TaskRequestDTO taskRequestDTO) {
        taskMapper.toResponse(iTaskService.criarTarefa(taskMapper.toDomain(taskRequestDTO)));
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Busca Todas as Tarefas", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa buscada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar tarefa"),
    })
    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> buscarTodasAsTarefas() {
        List<TaskDomain> tarefas = iTaskService.buscarTodasAsTarefas();
        List<TaskResponseDTO> responseDTOs = tarefas.stream().map(taskMapper::toResponse).collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOs);

//        public ResponseEntity<List<TaskDomain>> buscarTodasAsTarefas(){
//            List<TaskDomain> tarefas = iTaskService.buscarTodasAsTarefas();
//            return ResponseEntity.ok(tarefas);
    }


    @Operation(summary = "Deletar Tarefa", method ="DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa deletada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao deletar tarefa"),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTarefa(@PathVariable Long id) {
        iTaskService.excluirTarefa(id);
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Buscar Tarefa por ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar tarefa"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> buscarTarefaPorId(@PathVariable Long id) {
        return iTaskService.buscarTarefaPorId(id)
                .map(taskMapper::toResponse) // Converte TaskDomain para TaskResponseDTO
                .map(ResponseEntity::ok) // Retorna 200 OK com o DTO
                .orElse(ResponseEntity.notFound().build()); // Retorna 404 Not Found se a tarefa não existir
    }

    @Operation(summary = "Atualizar tarefa", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar tarefa"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> atualizarTarefa(@PathVariable Long id, @RequestBody TaskRequestDTO taskRequestDTO) {
        TaskDomain convertido = taskMapper.toDomain(taskRequestDTO); //converte para Domain
        ResponseEntity.ok(iTaskService.atualizarTaskPorId(convertido, id));
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Marcar Status da Tarefa", method ="PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa marcada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao marcar tarefa"),
    })
    @PutMapping("/{id}/marcarStatus")
    public ResponseEntity<Void> marcarStatusTarefa(@PathVariable Long id, Integer statusNum) {
        iTaskService.marcarStatusTarefa(id, statusNum);
        return ResponseEntity.ok().build();
    }


    @Operation(summary = "Buscar Tarefa por Status", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar tarefa"),
    })
    @GetMapping("/status/{status}") // Ajuste o mapeamento da URL para incluir o status como ENUM
    public ResponseEntity<List<TaskResponseDTO>> buscarTarefaPorStatus(@PathVariable TaskStatus status) {

        List<TaskDomain> tarefas = iTaskService.buscaTarefaPorStatus(status); // Retorna List<TaskDomain>

        // Converte a lista de TaskDomain para TaskResponseDTO
        List<TaskResponseDTO> response = tarefas.stream()
                .map(taskMapper::toResponse) // Converte cada TaskDomain para TaskResponseDTO
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

}