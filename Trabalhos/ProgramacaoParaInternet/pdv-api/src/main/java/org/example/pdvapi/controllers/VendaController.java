package org.example.pdvapi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.example.pdvapi.entity.VendaEntity;
import org.example.pdvapi.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @Operation(summary = "Cria uma nova venda")
    @PostMapping
    public ResponseEntity<VendaEntity> insert(@RequestBody VendaEntity venda, UriComponentsBuilder uriBuilder) {
        vendaService.insert(venda);
        URI uri = uriBuilder.path("/vendas/{id}").buildAndExpand(venda.getId()).toUri();
        return ResponseEntity.created(uri).body(venda);
    }

    @Operation(summary = "Atualiza uma venda")
    @PutMapping("/{id}")
    public ResponseEntity<VendaEntity> update(@PathVariable Long id, @RequestBody VendaEntity venda) {
        return ResponseEntity.ok(vendaService.update(venda));
    }

    @Operation(summary = "Deleta uma venda")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vendaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Busca uma venda pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<VendaEntity> findById(@PathVariable Long id) {
        return ResponseEntity.ok(vendaService.findById(id));
    }

    @Operation(summary = "Busca todas as vendas")
    @GetMapping("/all")
    public ResponseEntity<List<VendaEntity>> findAll() {
        return ResponseEntity.ok(vendaService.findAll());
    }

}
