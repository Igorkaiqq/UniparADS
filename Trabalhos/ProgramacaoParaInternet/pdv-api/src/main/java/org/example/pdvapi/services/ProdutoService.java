package org.example.pdvapi.services;

import org.example.pdvapi.entity.ProdutoEntity;
import org.example.pdvapi.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService
{

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoEntity insert(ProdutoEntity produto) {
        produtoRepository.save(produto);
        return produto;
    }

    public ProdutoEntity update(ProdutoEntity produto) {
        produtoRepository.save(produto);
        return produto;
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }

    public ProdutoEntity findById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public List<ProdutoEntity> findAll() {
        return produtoRepository.findAll();
    }

    public List<ProdutoEntity> findByDescricaoContaining(String descricao) {
        return produtoRepository.findByDescricaoContaining(descricao);
    }

}
