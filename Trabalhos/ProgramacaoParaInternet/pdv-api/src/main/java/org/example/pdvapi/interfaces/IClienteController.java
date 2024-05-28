package org.example.pdvapi.interfaces;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.pdvapi.entity.ClienteEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Tag(name = "Cliente", description = "Endpoints de Clientes")
@RequestMapping("/clientes")
public interface IClienteController {

    @Operation(summary = "Cria um novo cliente")
    @PostMapping
    ResponseEntity<ClienteEntity> insert(@RequestBody ClienteEntity cliente, UriComponentsBuilder uriBuilder);

    @Operation(summary = "Atualiza um cliente")
    @PutMapping("/{id}")
    ResponseEntity<ClienteEntity> update(@PathVariable Long id, @RequestBody ClienteEntity cliente);

    @Operation(summary = "Deleta um cliente")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);

    @Operation(summary = "Busca um cliente pelo ID")
    @GetMapping("/{id}")
    ResponseEntity<ClienteEntity> findById(@PathVariable Long id);

    @Operation(summary = "Busca todos os clientes")
    @GetMapping("/all")
    ResponseEntity<List<ClienteEntity>> findAll();

    @Operation(summary = "Busca os clientes pelo nome")
    @GetMapping()
    ResponseEntity<List<ClienteEntity>> findByNome(@RequestParam String nome);

}
