package com.cloud.yagodev.api_tarefa_curso_nelio_alves.dtos.mappers;

import com.cloud.yagodev.api_tarefa_curso_nelio_alves.dtos.TaskDTO;
import com.cloud.yagodev.api_tarefa_curso_nelio_alves.models.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public Task dtoParaEntidadeTask(TaskDTO dto) {
        Task entidadeTask = new Task();
        entidadeTask.setDescription(dto.getDescription());
        entidadeTask.setCompleted(dto.isCompleted());
        return entidadeTask;
    }

    public TaskDTO entidadeParaDto(Task entidade) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(entidade.getId());
        taskDTO.setDescription(entidade.getDescription());
        taskDTO.setCompleted(entidade.isCompleted());
        return taskDTO;
    }
}
