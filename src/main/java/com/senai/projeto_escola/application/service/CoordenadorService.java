package com.senai.projeto_escola.application.service;

import com.senai.projeto_escola.domain.entity.Coordenador;
import com.senai.projeto_escola.domain.entity.Professor;
import com.senai.projeto_escola.domain.repositories.CoordenadorRepository;
import com.senai.projeto_escola.application.dto.CoordenadorDto;
import com.senai.projeto_escola.application.dto.ProfessorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoordenadorService {

    @Autowired
    private CoordenadorRepository coordenadorRepo;

    public void salvar (CoordenadorDto coordenadorDto) {
        Coordenador coordenador = new Coordenador();
        coordenador.setNome(coordenadorDto.nome());
        coordenador.setIdade(coordenadorDto.idade());
        coordenador.setEquipeDeProfessores(mapEquipe(coordenadorDto.equipe()));
        coordenadorRepo.save(coordenador);
    }

    private List<Professor> mapEquipe(List<ProfessorDto> preofessoresDto) {
        return preofessoresDto.stream().map(professorDto -> {
            Professor professor = new Professor();
            professor.setNome(professorDto.nome());
            professor.setIdade(professorDto.idade());
            professor.setTurma(professorDto.turma());
            professor.setUnidadesCurriculares(professorDto.unidadesCurriculares());
            return professor;
        }).toList();
    }

    public List<CoordenadorDto> listar() {
        return coordenadorRepo.findAll().stream().map(c -> new CoordenadorDto(
                c.getId(),
                c.getNome(),
                c.getIdade(),
                c.getEquipeDeProfessores().stream().map(p -> new ProfessorDto(
                        p.getId(),
                        p.getNome(),
                        p.getIdade(),
                        p.getTurma(),
                        p.getUnidadesCurriculares()
                )).toList()
        )).toList();
    }

    public Optional<CoordenadorDto> buscarPorId(Long id) {
        return coordenadorRepo.findById(id).map(c -> new CoordenadorDto(
                c.getId(),
                c.getNome(),
                c.getIdade(),
                c.getEquipeDeProfessores().stream().map(
                        p -> new ProfessorDto(
                                p.getId(),
                                p.getNome(),
                                p.getIdade(),
                                p.getTurma(),
                                p.getUnidadesCurriculares()
                        )
                ).toList()
        ));
    }

    public boolean atualizar (Long id, CoordenadorDto coordenadorDto) {
        return coordenadorRepo.findById(id).map(
                c -> {
                    c.setNome(coordenadorDto.nome());
                    c.setIdade(coordenadorDto.idade());
                    c.setEquipeDeProfessores(mapEquipe(coordenadorDto.equipe()));
                    coordenadorRepo.save(c);
                    return true;
                }
        ).orElse(false);
    }

    public boolean deletar(Long id) {
        if(coordenadorRepo.existsById(id)) {
            coordenadorRepo.existsById(id);
            return true;
        } else {
            return false;
        }
    }
}
