package org.example.pdvapi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.pdvapi.entity.ClienteEntity;
import org.example.pdvapi.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Tag(name = "Cliente", description = "API de Clientes")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Cria um novo cliente")
    @PostMapping
    public ResponseEntity<ClienteEntity> insert(@RequestBody ClienteEntity cliente, UriComponentsBuilder uriBuilder) {
        clienteService.insert(cliente);
        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(cliente);
    }

    @Operation(summary = "Atualiza um cliente")
    @PutMapping("/{id}")
    public ResponseEntity<ClienteEntity> update(@PathVariable Long id, @RequestBody ClienteEntity cliente) {
        return ResponseEntity.ok(clienteService.update(cliente));
    }

    @Operation(summary = "Deleta um cliente")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Busca um cliente pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @Operation(summary = "Busca todos os clientes")
    @GetMapping("/all")
    public ResponseEntity<List<ClienteEntity>> findAll() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @Operation(summary = "Busca os clientes pelo nome")
    @GetMapping("/{nome}")
    public ResponseEntity<List<ClienteEntity>> findByNomeContaining(@RequestParam String nome) {
        return ResponseEntity.ok(clienteService.findByNomeContaining(nome));
    }

}
