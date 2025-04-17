package com.senai.projeto_escola.interface_ui.controller;

import com.senai.projeto_escola.application.dto.CoordenadorDto;
import com.senai.projeto_escola.application.service.CoordenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coordenador")
public class CoordenadorController {

    @Autowired
    private CoordenadorService service;

    @PostMapping
    public ResponseEntity<String> adicionarCoordenador(@RequestBody CoordenadorDto obj) {
        if (service.salvar(obj)) {
            return ResponseEntity.ok("Coordenador adicionado com sucesso!");
        } else {
            return ResponseEntity.badRequest().body("Erro ao adicionar coordenador!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCoordenador(@PathVariable Long id) {
        if (service.deletar(id)) {
            return ResponseEntity.ok("Coordenador deltado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CoordenadorDto>> listarCoordenadores() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoordenadorDto> listarUmCoordenador(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarUmCoordenador(@PathVariable Long id, @RequestBody CoordenadorDto obj) {
        if (service.atualizar(id, obj)) {
            return ResponseEntity.ok("Coordenador atualizado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
