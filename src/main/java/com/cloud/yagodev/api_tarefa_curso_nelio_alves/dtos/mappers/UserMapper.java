package com.cloud.yagodev.api_tarefa_curso_nelio_alves.dtos.mappers;

import com.cloud.yagodev.api_tarefa_curso_nelio_alves.dtos.UserDTO;
import com.cloud.yagodev.api_tarefa_curso_nelio_alves.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapeandoDtoParaEntidade(UserDTO dto) {
        var entidade = new User();
        entidade.setName(dto.getName());
        entidade.setCpf(dto.getCpf());

        return entidade;
    }

    public UserDTO mapeandoEntidadeParaDto(User entidade) {
        var dto = new UserDTO();
        dto.setId(entidade.getId());
        dto.setName(entidade.getName());
        dto.setCpf(entidade.getCpf());

        return dto;
    }
}
