package org.integrador.tasktracker.service;

import org.integrador.tasktracker.entity.HabitoEntity;
import org.integrador.tasktracker.repository.HabitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabitoService {
    @Autowired
    private HabitoRepository habitoRepository;

    public HabitoEntity save(HabitoEntity habito) {
        return habitoRepository.save(habito);
    }
}