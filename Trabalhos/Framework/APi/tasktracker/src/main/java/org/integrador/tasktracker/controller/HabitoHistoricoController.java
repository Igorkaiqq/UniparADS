package org.integrador.tasktracker.controller;

import org.integrador.tasktracker.entity.HabitoHistoricoEntity;
import org.integrador.tasktracker.service.HabitoHistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habitos/historico")
public class HabitoHistoricoController {

    @Autowired
    private HabitoHistoricoService habitoHistoricoService;

    @PostMapping
    public HabitoHistoricoEntity createHabitoHistorico(@RequestBody HabitoHistoricoEntity habitoHistorico) {
        return habitoHistoricoService.save(habitoHistorico);
    }
}