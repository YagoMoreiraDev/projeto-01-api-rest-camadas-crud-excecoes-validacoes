package com.cloud.yagodev.api_tarefa_curso_nelio_alves.controllers;

import com.cloud.yagodev.api_tarefa_curso_nelio_alves.dtos.UserDTO;
import com.cloud.yagodev.api_tarefa_curso_nelio_alves.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDTO adicionar(@RequestBody  UserDTO dto) {
        return userService.adicionarUsuario(dto);
    }

    @GetMapping("/{id}")
    public UserDTO buscarPorId(@PathVariable Long id) {
        return userService.buscarUsuarioPorId(id);
    }
}
