package org.example.pdvapi.services;

import org.example.pdvapi.entity.VendaEntity;
import org.example.pdvapi.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public VendaEntity insert(VendaEntity venda) {
        vendaRepository.save(venda);
        return venda;
    }

    public VendaEntity update(VendaEntity venda) {
        vendaRepository.save(venda);
        return venda;
    }

    public void delete(Long id) {
        vendaRepository.deleteById(id);
    }

    public VendaEntity findById(Long id) {
        return vendaRepository.findById(id).orElse(null);
    }

    public List<VendaEntity> findAll() {
        return vendaRepository.findAll();
    }

}
