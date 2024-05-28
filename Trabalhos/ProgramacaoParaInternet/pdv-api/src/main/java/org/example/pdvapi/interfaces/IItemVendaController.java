package org.example.pdvapi.interfaces;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.pdvapi.entity.ItemVendaEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Tag(name = "Itens da Venda", description = "Endpoints de Itens da Venda")
@RequestMapping("/item-venda")
public interface IItemVendaController {

    @Operation(summary = "Cria um novo item de venda")
    @PostMapping
    ResponseEntity<ItemVendaEntity> insert(@RequestBody ItemVendaEntity itemVenda, UriComponentsBuilder uriBuilder);

    @Operation(summary = "Atualiza um item de venda")
    @PutMapping("/{id}")
    ResponseEntity<ItemVendaEntity> update(@PathVariable Long id, @RequestBody ItemVendaEntity itemVenda);

    @Operation(summary = "Deleta um item de venda")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);

    @Operation(summary = "Busca um item de venda pelo ID")
    @GetMapping("/{id}")
    ResponseEntity<ItemVendaEntity> findById(@PathVariable Long id);

    @Operation(summary = "Busca todos os itens de venda")
    @GetMapping("/all")
    ResponseEntity<List<ItemVendaEntity>> findAll();


}
