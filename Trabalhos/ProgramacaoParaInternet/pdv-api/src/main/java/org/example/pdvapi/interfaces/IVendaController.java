package org.example.pdvapi.interfaces;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.pdvapi.entity.VendaEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Tag(name = "Venda", description = "Endpoints de Vendas")
@RequestMapping("/venda")
public interface IVendaController {

    @Operation(summary = "Cria uma nova venda")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "201", description = "Venda criada com sucesso"),
            @ApiResponse (responseCode = "400", description = "Parâmetros inválidos")
    })
    @PostMapping
    ResponseEntity<VendaEntity> insert(@RequestBody @Valid VendaEntity venda, UriComponentsBuilder uriBuilder);

    @Operation(summary = "Atualiza uma venda")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200", description = "Venda atualizada com sucesso"),
            @ApiResponse (responseCode = "204", description = "Venda não encontrada"),
            @ApiResponse (responseCode = "400", description = "Parâmetros inválidos")
    })
    @PutMapping("/{id}")
    ResponseEntity<VendaEntity> update(@PathVariable Long id, @RequestBody @Valid VendaEntity venda);

    @Operation(summary = "Deleta uma venda")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200", description = "Venda deletada com sucesso"),
            @ApiResponse (responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse (responseCode = "404", description = "Venda não encontrada")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);

    @Operation(summary = "Busca uma venda pelo ID")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200", description = "Venda encontrada com sucesso"),
            @ApiResponse (responseCode = "204", description = "Venda não encontrada"),
            @ApiResponse (responseCode = "400", description = "Parâmetros inválidos")
    })
    @GetMapping("/search/{id}")
    ResponseEntity<VendaEntity> findById(@PathVariable Long id);

    @Operation(summary = "Busca todas as vendas")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200", description = "Vendas encontradas com sucesso"),
            @ApiResponse (responseCode = "204", description = "Nenhuma venda encontrada")
    })
    @GetMapping("/all")
    ResponseEntity<List<VendaEntity>> findAll();


}
