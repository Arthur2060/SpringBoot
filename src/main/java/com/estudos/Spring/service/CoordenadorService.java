package com.estudos.Spring.service;

import com.senai.projeto_escola.domain.entity.Coordenador;
import com.senai.projeto_escola.domain.entity.Professor;
import com.senai.projeto_escola.domain.repositories.CoordenadorRepository;
import com.senai.projeto_escola.dto.CoordenadorDto;
import com.senai.projeto_escola.dto.ProfessorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordenadorService {

    @Autowired
    private CoordenadorRepository repository;

    public void salvar (CoordenadorDto coordenadorDto) {
        Coordenador coordenador = new Coordenador();
        coordenador.setNome(coordenadorDto.nome());
        coordenador.setIdade(coordenadorDto.idade());
        coordenador.setEquipeDeProfessores(mapEquipe(coordenadorDto.equipe()));
        repository.save(coordenador);
    }

    private List<Professor> mapEquipe(List<ProfessorDto> preofessoresDto) {
        return preofessoresDto.stream().map(professorDto -> {
            Professor professor = new Professor();
            professor.setNome(professorDto.nome());
            professor.setIdade(professorDto.idade());
            professor.setTurma(professorDto.turma());
            professor.setUnidade(professorDto.unidadesCurriculares());
            return professor;
        }).toList();
    }
}
