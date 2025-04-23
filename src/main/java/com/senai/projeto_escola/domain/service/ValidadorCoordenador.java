package com.senai.projeto_escola.domain.service;

import com.senai.projeto_escola.application.dto.CoordenadorDto;
import org.springframework.stereotype.Component;

@Component
public class ValidadorCoordenador {

    public void validar(CoordenadorDto coordenadorDto) {
        if (coordenadorDto.nome() == "") throw new IllegalArgumentException("Nome invalido!");

        if (coordenadorDto.idade() < 0) throw new IllegalArgumentException("Idade invalida!");

        if (coordenadorDto.equipe().isEmpty()) throw new IllegalArgumentException("Sem professores na equipe!");

        if(coordenadorDto.equipe().size() < 3) throw new IllegalArgumentException("Nome invalido!");
    }
}
