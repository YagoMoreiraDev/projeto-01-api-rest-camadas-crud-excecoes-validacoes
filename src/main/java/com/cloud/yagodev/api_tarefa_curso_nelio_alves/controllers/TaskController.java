package com.cloud.yagodev.api_tarefa_curso_nelio_alves.controllers;

import com.cloud.yagodev.api_tarefa_curso_nelio_alves.dtos.TaskDTO;
import com.cloud.yagodev.api_tarefa_curso_nelio_alves.models.Task;
import com.cloud.yagodev.api_tarefa_curso_nelio_alves.repositories.TaskRepository;
import com.cloud.yagodev.api_tarefa_curso_nelio_alves.services.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<TaskDTO> pegarUmaTarefa(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.buscarTarefaPorId(id));
    }
    /* Forma prática porém não é a melhor
    @PostMapping
    public ResponseEntity<TaskDTO> inserirTarefa(@RequestBody TaskDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(taskService.inserindoNovaTarefa(dto));
    }
    */
    //Forma correta real
    @PostMapping
    public ResponseEntity<TaskDTO> inserirTarefa(@RequestBody TaskDTO taskDTOdto) {
        taskDTOdto = taskService.inserindoNovaTarefa(taskDTOdto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(taskDTOdto.getId()).toUri();
        return ResponseEntity.created(uri).body(taskDTOdto);
    }
}
