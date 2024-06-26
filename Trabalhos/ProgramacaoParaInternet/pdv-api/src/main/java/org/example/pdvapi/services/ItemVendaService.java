package org.example.pdvapi.services;

import org.example.pdvapi.entity.ItemVendaEntity;
import org.example.pdvapi.entity.ProdutoEntity;
import org.example.pdvapi.repositories.ItemVendaRepository;
import org.example.pdvapi.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemVendaService {

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public void insert(ItemVendaEntity itemVenda) {
        Optional<ProdutoEntity> produto = produtoRepository.findById(itemVenda.getProduto().getId());

        if (produto != null) {
            itemVenda.setProduto(produto.get());
            itemVendaRepository.save(itemVenda);
        } else {
            throw new RuntimeException("Produto não encontrado");
        }
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
