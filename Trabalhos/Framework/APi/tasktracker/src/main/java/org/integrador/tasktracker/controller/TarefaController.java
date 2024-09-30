package org.integrador.tasktracker.controller;

import org.integrador.tasktracker.entity.TarefaEntity;
import org.integrador.tasktracker.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public TarefaEntity createTarefa(@RequestBody TarefaEntity tarefa) {
        return tarefaService.save(tarefa);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<TarefaEntity> getTarefasByUsuario(@PathVariable Long usuarioId) {
        return tarefaService.findByUsuario(usuarioId);
    }
}