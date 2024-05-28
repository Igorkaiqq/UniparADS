package org.example.pdvapi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.pdvapi.entity.ProdutoEntity;
import org.example.pdvapi.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Tag(name = "Produto", description = "API de Produtos")
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Operation(summary = "Cria um novo produto")
    @PostMapping
    public ResponseEntity<ProdutoEntity> insert(@RequestBody ProdutoEntity produto, UriComponentsBuilder uriBuilder) {
        produtoService.insert(produto);
        URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(produto);
    }

    @Operation(summary = "Atualiza um produto")
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoEntity> update(@PathVariable Long id, @RequestBody ProdutoEntity produto) {
        return ResponseEntity.ok(produtoService.update(produto));
    }

    @Operation(summary = "Deleta um produto")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Busca um produto pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoEntity> findById(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.findById(id));
    }

    @Operation(summary = "Busca todos os produtos")
    @GetMapping("/all")
    public ResponseEntity<List<ProdutoEntity>> findAll() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    @Operation(summary = "Busca os produtos pela descrição")
    @GetMapping("/{descricao}")
    public ResponseEntity<List<ProdutoEntity>> findByDescricaoContaining(@RequestParam String descricao) {
        return ResponseEntity.ok(produtoService.findByDescricaoContaining(descricao));
    }

}
