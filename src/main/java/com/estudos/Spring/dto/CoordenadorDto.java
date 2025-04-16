package com.estudos.Spring.dto;

import java.util.List;

public record CoordenadorDto (Long id,
                              String nome,
                              Integer idade,
                              List<ProfessorDto> equipe) {
}
