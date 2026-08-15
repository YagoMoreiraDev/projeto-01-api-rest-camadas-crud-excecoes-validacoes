package com.cloud.yagodev.api_tarefa_curso_nelio_alves.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

    @GetMapping("/teste")
    @Operation(summary = "URL de teste.", description = "Criada para testar a inicialização da aplicação!")
    public String mensagemTeste() {
        return "Teste de api bem sucedido!";
    }
}
