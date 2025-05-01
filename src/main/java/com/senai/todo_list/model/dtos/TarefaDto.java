package com.senai.todo_list.model.dtos;

public record TarefaDto(Long id,
                        String nome,
                        String descricao,
                        Boolean status) {
}
