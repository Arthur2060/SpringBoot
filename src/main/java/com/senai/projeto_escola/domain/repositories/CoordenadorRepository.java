package com.senai.projeto_escola.domain.repositories;

import com.senai.projeto_escola.domain.entity.Coordenador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordenadorRepository extends JpaRepository<Coordenador, Long> {
}
