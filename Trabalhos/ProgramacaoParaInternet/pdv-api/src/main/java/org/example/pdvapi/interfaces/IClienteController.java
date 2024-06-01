package org.example.pdvapi.interfaces;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.pdvapi.dto.ClienteDTO;
import org.example.pdvapi.entity.ClienteEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Tag(name = "Cliente", description = "Endpoints de Clientes")
@RequestMapping("/clientes")
public interface IClienteController {

    @Operation(summary = "Cria um novo cliente")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "201", description = "Cliente criado com sucesso"),
            @ApiResponse (responseCode = "400", description = "Parâmetros inválidos")
    })
    @PostMapping()
    ResponseEntity<ClienteDTO> insert(@RequestBody @Valid ClienteDTO cliente, UriComponentsBuilder uriBuilder);

    @Operation(summary = "Atualiza um cliente")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200", description = "Cliente atualizado com sucesso"),
            @ApiResponse (responseCode = "204", description = "Cliente não encontrado"),
            @ApiResponse (responseCode = "400", description = "Parâmetros inválidos")
    })
    @PutMapping("/{id}")
    ResponseEntity<ClienteDTO> update(@PathVariable Long id, @RequestBody @Valid ClienteDTO cliente);

    @Operation(summary = "Deleta um cliente")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200", description = "Cliente deletado com sucesso"),
            @ApiResponse (responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse (responseCode = "404", description = "Cliente não encontrado")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);

    @Operation(summary = "Busca um cliente pelo ID")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200", description = "Cliente encontrado com sucesso"),
            @ApiResponse (responseCode = "204", description = "Cliente não encontrado"),
            @ApiResponse (responseCode = "400", description = "Parâmetros inválidos")
    })
    @GetMapping("/search/{id}")
    ResponseEntity<ClienteDTO> findById(@PathVariable Long id);

    @Operation(summary = "Busca todos os clientes")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200", description = "Clientes encontrados com sucesso"),
            @ApiResponse (responseCode = "204", description = "Nenhum cliente encontrado")
    })
    @GetMapping("/all")
    ResponseEntity<List<ClienteDTO>> findAll();

    @Operation(summary = "Busca os clientes pelo nome")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200", description = "Clientes encontrados com sucesso"),
            @ApiResponse (responseCode = "204", description = "Nenhum cliente encontrado"),
            @ApiResponse (responseCode = "400", description = "Parâmetros inválidos")
    })
    @GetMapping("/search")
    ResponseEntity<List<ClienteDTO>> findByNome(@RequestParam String nome);

}
