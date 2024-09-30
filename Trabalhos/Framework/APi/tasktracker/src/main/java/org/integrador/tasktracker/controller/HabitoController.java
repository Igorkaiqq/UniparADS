package org.integrador.tasktracker.controller;

import org.integrador.tasktracker.entity.HabitoEntity;
import org.integrador.tasktracker.service.HabitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habitos")
public class HabitoController {
    @Autowired
    private HabitoService habitoService;

    @PostMapping
    public HabitoEntity createHabito(@RequestBody HabitoEntity habito) {
        return habitoService.save(habito);
    }
}

