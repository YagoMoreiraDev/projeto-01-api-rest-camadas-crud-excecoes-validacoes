package com.cloud.yagodev.api_tarefa_curso_nelio_alves.controllers;

import com.cloud.yagodev.api_tarefa_curso_nelio_alves.dtos.UserDTO;
import com.cloud.yagodev.api_tarefa_curso_nelio_alves.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> adicionar(@RequestBody  UserDTO dto) {
        dto = userService.adicionarUsuario(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(userService.buscarUsuarioPorId(id));
    }
}
