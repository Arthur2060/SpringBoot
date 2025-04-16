package com.senai.projeto_escola.dto;

import com.senai.projeto_escola.domain.entity.UnidadeCurricular;

import java.util.List;

public record ProfessorDto (
        Long id,
        String nome,
        Integer idade,
        String turma,
        List<UnidadeCurricular> unidadesCurriculares
) {
}
