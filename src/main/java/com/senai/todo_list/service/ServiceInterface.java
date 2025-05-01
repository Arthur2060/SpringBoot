package com.senai.todo_list.service;

import com.senai.todo_list.model.dtos.TarefaDto;

import java.util.List;

public interface ServiceInterface {
    public abstract Long add(TarefaDto newTarefa);
    public abstract Boolean remove(Long id);
    public abstract List<TarefaDto> list();
    public abstract TarefaDto listOne(Long id);
    public abstract Boolean update(TarefaDto newTarefa, Long id);
}
