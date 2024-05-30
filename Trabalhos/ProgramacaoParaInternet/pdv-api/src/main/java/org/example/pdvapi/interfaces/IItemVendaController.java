package org.example.pdvapi.interfaces;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.pdvapi.entity.ItemVendaEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Tag(name = "Itens da Venda", description = "Endpoints de Itens da Venda")
@RequestMapping("/item-venda")
public interface IItemVendaController {

    @Operation(summary = "Cria um novo item de venda")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "201", description = "Item de venda criado com sucesso"),
            @ApiResponse (responseCode = "400", description = "Parâmetros inválidos"),
    })
    @PostMapping
    ResponseEntity<ItemVendaEntity> insert(@RequestBody @Valid ItemVendaEntity itemVenda, UriComponentsBuilder uriBuilder);

    @Operation(summary = "Atualiza um item de venda")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200", description = "Item de venda atualizado com sucesso"),
            @ApiResponse (responseCode = "204", description = "Item de venda não encontrado"),
            @ApiResponse (responseCode = "400", description = "Parâmetros inválidos")
    })
    @PutMapping("/{id}")
    ResponseEntity<ItemVendaEntity> update(@PathVariable Long id, @RequestBody @Valid ItemVendaEntity itemVenda);

    @Operation(summary = "Deleta um item de venda")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200", description = "Item de venda deletado com sucesso"),
            @ApiResponse (responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse (responseCode = "404", description = "Item de venda não encontrado")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);

    @Operation(summary = "Busca um item de venda pelo ID")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200", description = "Item de venda encontrado com sucesso"),
            @ApiResponse (responseCode = "204", description = "Item de venda não encontrado"),
            @ApiResponse (responseCode = "400", description = "Parâmetros inválidos")
    })
    @GetMapping("/{id}")
    ResponseEntity<ItemVendaEntity> findById(@PathVariable Long id);

    @Operation(summary = "Busca todos os itens de venda")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200", description = "Itens de venda encontrados com sucesso"),
            @ApiResponse (responseCode = "204", description = "Nenhum item de venda encontrado")
    })
    @GetMapping("/all")
    ResponseEntity<List<ItemVendaEntity>> findAll();


}
