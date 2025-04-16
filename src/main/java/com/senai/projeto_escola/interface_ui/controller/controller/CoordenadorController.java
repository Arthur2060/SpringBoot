package com.senai.projeto_escola.interface_ui.controller.controller;

import com.senai.projeto_escola.dto.CoordenadorDto;
import com.senai.projeto_escola.service.CoordenadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Coordenador")
public class CoordenadorController {
    private CoordenadorService service;

    @PostMapping
    public ResponseEntity<String> adicionarCoordenador(@RequestBody CoordenadorDto obj) {
        service.salvar(obj);
        return ResponseEntity.ok("Coordenador adicionado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCoordenador(@PathVariable Long id) {
        if (service.delete(id)) {
            return ResponseEntity.ok("Coordenador deltado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CoordenadorDto>> listarCoordenadores() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoordenadorDto> listarUmCoordenador(@PathVariable Long id) {
        return service.getOne(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity::notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarUmCoordenador(@PathVariable Long id, @RequestBody CoordenadorDto obj) {
        if (service.update(id, obj)) {
            return ResponseEntity.ok("Coordenador atualizado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
