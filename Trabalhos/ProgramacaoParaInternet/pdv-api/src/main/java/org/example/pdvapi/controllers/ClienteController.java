package org.example.pdvapi.controllers;

import org.example.pdvapi.entity.ClienteEntity;
import org.example.pdvapi.interfaces.IClienteController;
import org.example.pdvapi.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ClienteController implements IClienteController {

    @Autowired
    private ClienteService clienteService;

    @Override
    public ResponseEntity<ClienteEntity> insert(@RequestBody ClienteEntity cliente, UriComponentsBuilder uriBuilder) {
        clienteService.insert(cliente);
        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(cliente);
    }

    @Override
    public ResponseEntity<ClienteEntity> update(@PathVariable Long id, @RequestBody ClienteEntity cliente) {
        return ResponseEntity.ok(clienteService.update(cliente));
    }

    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ClienteEntity> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @Override
    public ResponseEntity<List<ClienteEntity>> findAll() {
        return ResponseEntity.ok(clienteService.findAll());
    }
    @Override
    public ResponseEntity<List<ClienteEntity>> findByNome(@RequestParam String nome) {
        return ResponseEntity.ok(clienteService.findByNomeContaining(nome));
    }

}
