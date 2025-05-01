package com.senai.todo_list.interface_ui.controller;

import com.senai.todo_list.model.dtos.TarefaDto;
import com.senai.todo_list.model.entities.Tarefa;
import com.senai.todo_list.service.ServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {
    private ServiceInterface service;

    @PostMapping
    public ResponseEntity<URI> adicionarTarefa(@RequestBody TarefaDto newTarefa) {
        Long id = service.add(newTarefa);

        if (id != null) {
            return ResponseEntity.created(URI.create("/tarefa/" + id)).build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDto> listarUmaTarefa(@PathVariable Long id) {
        TarefaDto one = service.listOne(id);

        if (one != null) {
            return ResponseEntity.ok(one);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarTarefa(@PathVariable Long id) {
        if (service.remove(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaDto> atualizarTarefa(@PathVariable Long id, @RequestBody TarefaDto newTarefa) {
        if (service.update(newTarefa, id)) {
            return ResponseEntity.ok(newTarefa);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<TarefaDto>> listarTarefas() {
        return ResponseEntity.ok(service.list());
    }
}
