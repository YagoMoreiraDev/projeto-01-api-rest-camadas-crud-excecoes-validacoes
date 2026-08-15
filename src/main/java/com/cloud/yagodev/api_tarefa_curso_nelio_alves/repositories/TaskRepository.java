package com.cloud.yagodev.api_tarefa_curso_nelio_alves.repositories;

import com.cloud.yagodev.api_tarefa_curso_nelio_alves.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
