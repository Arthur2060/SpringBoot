package com.senai.projeto_escola.application.service;

import com.senai.projeto_escola.application.dto.ProfessorDto;
import com.senai.projeto_escola.domain.entity.Professor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ValidadorProfessor {

    public boolean validar(ProfessorDto professorDto) {
        Professor professor = new Professor();

        professor.setId(professorDto.id());
        professor.setNome(professorDto.nome());
        professor.setUnidadesCurriculares(professorDto.unidadesCurriculares());
        professor.setTurma(professorDto.turma());

        if (professor.getUnidadesCurriculares().size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
