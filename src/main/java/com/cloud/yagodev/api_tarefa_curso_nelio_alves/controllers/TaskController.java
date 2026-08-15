package com.cloud.yagodev.api_tarefa_curso_nelio_alves.controllers;

import com.cloud.yagodev.api_tarefa_curso_nelio_alves.models.Task;
import com.cloud.yagodev.api_tarefa_curso_nelio_alves.repositories.TaskRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/teste")
    @Operation(summary = "URL de teste.", description = "Criada para testar a inicialização da aplicação!")
    public String mensagemTeste() {
        return "Teste de api bem sucedido!";
    }


    @GetMapping("/buscaId")
    @Operation(summary = "Buscar tarefa por Id.", description = "Busque um tarefa informando o número de um id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa encontrada com sucesso!"),
    })
    public String pegarUmaTarefa(Long id) {
        Optional<Task> buscarValorDescription = taskRepository.findById(id);
        //Task task = buscarValorDescription.get();
        // return task.getDescription;
        return buscarValorDescription.get().getDescription();
    }
}
