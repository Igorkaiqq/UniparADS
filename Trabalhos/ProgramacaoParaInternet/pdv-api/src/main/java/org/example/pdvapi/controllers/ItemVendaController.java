package org.example.pdvapi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.example.pdvapi.entity.ItemVendaEntity;
import org.example.pdvapi.services.ItemVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/itens-venda")
public class ItemVendaController {

    @Autowired
    private ItemVendaService itemVendaService;

    @Operation(summary = "Cria um novo item de venda")
    @PostMapping
    public ResponseEntity<ItemVendaEntity> insert (@RequestBody ItemVendaEntity itemVenda, UriComponentsBuilder uriBuilder ){
        itemVendaService.insert(itemVenda);
        URI uri = uriBuilder.path("/itens-venda/{id}").buildAndExpand(itemVenda.getId()).toUri();
        return ResponseEntity.created(uri).body(itemVenda);
    }

    @Operation(summary = "Atualiza um item de venda")
    @PutMapping("/{id}")
    public ResponseEntity<ItemVendaEntity> update (@PathVariable Long id, @RequestBody ItemVendaEntity itemVenda){
        return ResponseEntity.ok(itemVendaService.update(itemVenda));
    }

    @Operation(summary = "Deleta um item de venda")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        itemVendaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Busca um item de venda pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<ItemVendaEntity> findById (@PathVariable Long id){
        return ResponseEntity.ok(itemVendaService.findById(id));
    }

    @Operation(summary = "Busca todos os itens de venda")
    @GetMapping("/all")
    public ResponseEntity<List<ItemVendaEntity>> findAll (){
        return ResponseEntity.ok(itemVendaService.findAll());
    }

}
