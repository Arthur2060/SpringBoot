package com.senai.todo_list.model.repositories;

import com.senai.todo_list.model.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
