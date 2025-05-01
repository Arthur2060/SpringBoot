package com.senai.todo_list.service;

import com.senai.todo_list.model.dtos.TarefaDto;
import com.senai.todo_list.model.entities.Tarefa;
import com.senai.todo_list.model.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService implements ServiceInterface{
    @Autowired
    private TarefaRepository repository;

    @Override
    public Long add(TarefaDto newTarefa) {
        Tarefa tarefa = repository.save(new Tarefa(
                null,
                newTarefa.nome(),
                newTarefa.descricao(),
                newTarefa.status()
        ));
        return tarefa.getId();
    }

    @Override
    public Boolean remove(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<TarefaDto> list() {
        return repository.findAll()
                .stream()
                .map(tarefa -> new TarefaDto(
                        tarefa.getId(),
                        tarefa.getNome(),
                        tarefa.getDescricao(),
                        tarefa.getStatus()
                )).toList();
    }

    @Override
    public TarefaDto listOne(Long id) {
        Tarefa target = repository.findById(id).get();
        return new TarefaDto(
                target.getId(),
                target.getNome(),
                target.getDescricao(),
                target.getStatus()
        );
    }

    @Override
    public Boolean update(TarefaDto newTarefa, Long id) {
        Tarefa tarefaOrig = repository.findById(id).get();

        tarefaOrig.setId(newTarefa.id());
        tarefaOrig.setNome(newTarefa.nome());
        tarefaOrig.setDescricao(newTarefa.descricao());
        tarefaOrig.setStatus(newTarefa.status());

        if (repository.save(tarefaOrig).equals(newTarefa)) {
            return true;
        }

        return false;
    }
}
