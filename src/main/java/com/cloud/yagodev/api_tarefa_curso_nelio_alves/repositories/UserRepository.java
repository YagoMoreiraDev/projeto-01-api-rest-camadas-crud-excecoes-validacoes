package com.cloud.yagodev.api_tarefa_curso_nelio_alves.repositories;

import com.cloud.yagodev.api_tarefa_curso_nelio_alves.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
