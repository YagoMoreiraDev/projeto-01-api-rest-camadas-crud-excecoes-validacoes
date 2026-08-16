package com.cloud.yagodev.api_tarefa_curso_nelio_alves.services;


import com.cloud.yagodev.api_tarefa_curso_nelio_alves.dtos.TaskDTO;
import com.cloud.yagodev.api_tarefa_curso_nelio_alves.dtos.mappers.TaskMapper;
import com.cloud.yagodev.api_tarefa_curso_nelio_alves.models.Task;
import com.cloud.yagodev.api_tarefa_curso_nelio_alves.repositories.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TaskService {

    private TaskRepository taskRepository;
    private TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Transactional(readOnly = true)
    public TaskDTO buscarTarefaPorId(Long id) {
        Optional<Task> taskEntidade = taskRepository.findById(id);
        return taskMapper.entidadeParaDto(taskEntidade.get());
    }

    @Transactional
    public TaskDTO inserindoNovaTarefa(TaskDTO dto) {
        Task entidade = taskMapper.dtoParaEntidadeTask(dto);
        entidade.setCompleted(false);
        entidade = taskRepository.save(entidade);
        return taskMapper.entidadeParaDto(entidade);
    }
}
