package com.cloud.yagodev.api_tarefa_curso_nelio_alves.services;

import com.cloud.yagodev.api_tarefa_curso_nelio_alves.dtos.UserDTO;
import com.cloud.yagodev.api_tarefa_curso_nelio_alves.dtos.mappers.UserMapper;
import com.cloud.yagodev.api_tarefa_curso_nelio_alves.models.User;
import com.cloud.yagodev.api_tarefa_curso_nelio_alves.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO buscarUsuarioPorId(Long id) {
        Optional<User> entidadeOptional = userRepository.findById(id);
        return userMapper.mapeandoEntidadeParaDto(entidadeOptional.get());
    }

    public UserDTO adicionarUsuario(UserDTO dto) {
        User entidadeUser = userMapper.mapeandoDtoParaEntidade(dto);
        entidadeUser = userRepository.save(entidadeUser);
        return userMapper.mapeandoEntidadeParaDto(entidadeUser);
    }
}
