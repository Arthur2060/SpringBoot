package com.senai.projeto_escola.interface_ui.controller;

import com.senai.projeto_escola.application.dto.ProfessorDto;
import com.senai.projeto_escola.application.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService service;

    @PostMapping
    public ResponseEntity<String> adicionarProfessor(@RequestBody ProfessorDto obj) {
        service.salvar(obj);
        return ResponseEntity.ok("Professor adicionado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProfessor(@PathVariable Long id) {
        if (service.deletar(id)) {
            return ResponseEntity.ok("Professor deltado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ProfessorDto>> listarProfessor() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDto> listarUmProfessor(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarUmProfessor(@PathVariable Long id, @RequestBody ProfessorDto obj) {
        if (service.atualizar(id, obj)) {
            return ResponseEntity.ok("Professor atualizado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
