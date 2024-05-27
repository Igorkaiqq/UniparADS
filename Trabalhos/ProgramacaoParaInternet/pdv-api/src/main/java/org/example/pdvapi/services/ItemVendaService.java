package org.example.pdvapi.services;

import org.example.pdvapi.entity.ItemVendaEntity;
import org.example.pdvapi.repositories.ItemVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemVendaService {

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    public void insert(ItemVendaEntity itemVenda) {
        itemVendaRepository.save(itemVenda);
    }

    public ItemVendaEntity update(ItemVendaEntity itemVenda){
        return itemVendaRepository.save(itemVenda);
    }

    public void delete(Long id) {
        itemVendaRepository.deleteById(id);
    }

    public ItemVendaEntity findById(Long id) {
        return itemVendaRepository.findById(id).orElse(null);
    }

    public List<ItemVendaEntity> findAll() {
        return itemVendaRepository.findAll();
    }

}
