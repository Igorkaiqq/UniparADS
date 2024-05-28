package org.example.pdvapi.interfaces;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.pdvapi.entity.VendaEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Tag(name = "Venda", description = "Endpoints de Vendas")
@RequestMapping("/venda")
public interface IVendaController {

    @Operation(summary = "Cria uma nova venda")
    @PostMapping
    ResponseEntity<VendaEntity> insert(@RequestBody VendaEntity venda, UriComponentsBuilder uriBuilder);

    @Operation(summary = "Atualiza uma venda")
    @PutMapping("/{id}")
    ResponseEntity<VendaEntity> update(@PathVariable Long id, @RequestBody VendaEntity venda);

    @Operation(summary = "Deleta uma venda")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);

    @Operation(summary = "Busca uma venda pelo ID")
    @GetMapping("/{id}")
    ResponseEntity<VendaEntity> findById(@PathVariable Long id);

    @Operation(summary = "Busca todas as vendas")
    @GetMapping("/all")
    ResponseEntity<List<VendaEntity>> findAll();


}
