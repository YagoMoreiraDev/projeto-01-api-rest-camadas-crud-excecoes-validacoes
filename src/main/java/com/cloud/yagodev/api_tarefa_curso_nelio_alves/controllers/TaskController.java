package com.cloud.yagodev.api_tarefa_curso_nelio_alves.controllers;

import com.cloud.yagodev.api_tarefa_curso_nelio_alves.dtos.TaskDTO;
import com.cloud.yagodev.api_tarefa_curso_nelio_alves.models.Task;
import com.cloud.yagodev.api_tarefa_curso_nelio_alves.repositories.TaskRepository;
import com.cloud.yagodev.api_tarefa_curso_nelio_alves.services.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/teste")
    @Operation(summary = "URL de teste.", description = "Criada para testar a inicialização da aplicação!")
    public String mensagemTeste() {
        return "Teste de api bem sucedido!";
    }


    @GetMapping("/{id}") //O "/{id}" casa com o @PathVariable
    @Operation(summary = "Buscar tarefa por Id.", description = "Busque um tarefa informando o número de um id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa encontrada com sucesso!"),
    })
    public TaskDTO pegarUmaTarefa(@PathVariable Long id) {
        return taskService.buscarTarefaPorId(id);
    }
}
