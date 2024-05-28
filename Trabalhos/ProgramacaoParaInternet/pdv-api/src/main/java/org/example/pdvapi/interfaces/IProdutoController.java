package org.example.pdvapi.interfaces;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.pdvapi.entity.ProdutoEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Tag(name = "Produto", description = "Endpoints de Produto")
@RequestMapping("/produto")
public interface IProdutoController {

    @Operation(summary = "Cria um novo produto")
    @PostMapping
    ResponseEntity<ProdutoEntity> insert(@RequestBody ProdutoEntity produto, UriComponentsBuilder uriBuilder);

    @Operation(summary = "Atualiza um produto")
    @PutMapping("/{id}")
    ResponseEntity<ProdutoEntity> update(@PathVariable Long id, @RequestBody ProdutoEntity produto);

    @Operation(summary = "Deleta um produto")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);

    @Operation(summary = "Busca um produto pelo ID")
    @GetMapping("/{id}")
    ResponseEntity<ProdutoEntity> findById(@PathVariable Long id);

    @Operation(summary = "Busca todos os produtos")
    @GetMapping("/all")
    ResponseEntity<List<ProdutoEntity>> findAll();

    @Operation(summary = "Busca os produto pela descrição")
    @GetMapping()
    ResponseEntity<List<ProdutoEntity>> findByDescricao(@RequestParam String nome);

}
