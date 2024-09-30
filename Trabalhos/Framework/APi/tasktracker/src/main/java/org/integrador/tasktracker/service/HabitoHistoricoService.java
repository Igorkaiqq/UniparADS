package org.integrador.tasktracker.service;

import org.integrador.tasktracker.entity.HabitoHistoricoEntity;
import org.integrador.tasktracker.repository.HabitoHistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabitoHistoricoService {
    @Autowired
    private HabitoHistoricoRepository habitoHistoricoRepository;

    public HabitoHistoricoEntity save(HabitoHistoricoEntity habitoHistorico) {
        return habitoHistoricoRepository.save(habitoHistorico);
    }
}