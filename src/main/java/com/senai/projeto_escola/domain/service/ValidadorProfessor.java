package com.senai.projeto_escola.domain.service;

import com.senai.projeto_escola.application.dto.ProfessorDto;
import org.springframework.stereotype.Component;

@Component
public class ValidadorProfessor {

    public void validar(ProfessorDto professorDto) {
        if (professorDto.idade() < 0) throw new IllegalArgumentException("Idade do professor não pode ser negativa! Idade invalida.");

        if (professorDto.unidadesCurriculares().isEmpty()) throw new IllegalArgumentException("Sem unidades curriculares validas!");

        if (professorDto.unidadesCurriculares().size() < 3) throw new IllegalArgumentException("Unidades curriculares insuficientes");
    }
}
