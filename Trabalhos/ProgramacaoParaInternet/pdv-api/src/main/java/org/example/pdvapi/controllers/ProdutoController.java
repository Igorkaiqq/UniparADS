package org.example.pdvapi.controllers;

import org.example.pdvapi.entity.ProdutoEntity;
import org.example.pdvapi.interfaces.IProdutoController;
import org.example.pdvapi.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
public class ProdutoController implements IProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Override
    public ResponseEntity<ProdutoEntity> insert(@RequestBody ProdutoEntity produto, UriComponentsBuilder uriBuilder) {
        produtoService.insert(produto);
        URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(produto);
    }

    @Override
    public ResponseEntity<ProdutoEntity> update(@PathVariable Long id, @RequestBody ProdutoEntity produto) {
        return produtoService.update(id, produto);
    }

    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        return produtoService.delete(id);
    }

    @Override
    public ResponseEntity<ProdutoEntity> findById(@PathVariable Long id) {
        return produtoService.findById(id);
    }

    @Override
    public ResponseEntity<List<ProdutoEntity>> findAll() {
        return produtoService.findAll();
    }
    @Override
    public ResponseEntity<List<ProdutoEntity>> findByDescricao(@RequestParam String descricao) {
        return produtoService.findByDescricaoContaining(descricao);
    }

}
