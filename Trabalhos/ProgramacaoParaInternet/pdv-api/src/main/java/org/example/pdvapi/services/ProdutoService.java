package org.example.pdvapi.services;

import org.example.pdvapi.entity.ProdutoEntity;
import org.example.pdvapi.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService
{

    @Autowired
    private ProdutoRepository produtoRepository;

    public ResponseEntity<ProdutoEntity> insert(ProdutoEntity produto) {
        produtoRepository.save(produto);
        return ResponseEntity.ok(produto);
    }

    public ResponseEntity<ProdutoEntity> update(Long id, ProdutoEntity produto) {
        Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(id);
        if (!produtoEntity.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        produto.setId(id);
        produtoRepository.save(produto);
        return ResponseEntity.ok(produto);
    }

    public ResponseEntity<Void> delete(Long id) {
        Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(id);
        if (!produtoEntity.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        produtoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<ProdutoEntity> findById(Long id) {
        Optional<ProdutoEntity> produto = produtoRepository.findById(id);
        if (!produto.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produto.get());
    }

    public ResponseEntity<List<ProdutoEntity>> findAll() {
        List<ProdutoEntity> produtos = produtoRepository.findAll();
        if (produtos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtos);
    }

    public ResponseEntity<List<ProdutoEntity>> findByDescricaoContaining(String descricao) {
        List<ProdutoEntity> produtos = produtoRepository.findByDescricaoContaining(descricao);
        if (produtos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtos);
    }

}
