package com.senai.projeto_escola.application.service;

import com.senai.projeto_escola.application.dto.CoordenadorDto;
import com.senai.projeto_escola.application.dto.ProfessorDto;
import com.senai.projeto_escola.domain.entity.Coordenador;
import com.senai.projeto_escola.domain.entity.Professor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class ValidadorCoordenador {

    public boolean validar(CoordenadorDto coordenadorDto) {
        Coordenador coordenador = new Coordenador();

        coordenador.setNome(coordenadorDto.nome());
        coordenador.setIdade(coordenadorDto.idade());
        coordenador.setEquipeDeProfessores(mapEquipe(coordenadorDto.equipe()));

        if (coordenador.getEquipeDeProfessores().size() >= 3 && coordenador.getIdade() > 0) {
            return true;
        } else {
            return false;
        }
    }

    private List<Professor> mapEquipe(List<ProfessorDto> preofessoresDto) {
        return new ArrayList<>( preofessoresDto.stream().map(professorDto -> {
            Professor professor = new Professor();
            professor.setNome(professorDto.nome());
            professor.setIdade(professorDto.idade());
            professor.setTurma(professorDto.turma());
            professor.setUnidadesCurriculares(professorDto.unidadesCurriculares());
            return professor;
        }).toList());
    }
}
