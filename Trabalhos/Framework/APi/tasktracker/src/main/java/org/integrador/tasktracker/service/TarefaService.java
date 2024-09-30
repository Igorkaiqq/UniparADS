package org.integrador.tasktracker.service;

import org.integrador.tasktracker.entity.TarefaEntity;
import org.integrador.tasktracker.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    public List<TarefaEntity> findByUsuario(Long usuarioId) {
        return tarefaRepository.findByUsuarioId(usuarioId);
    }

    public TarefaEntity save(TarefaEntity tarefa) {
        return tarefaRepository.save(tarefa);
    }
}
