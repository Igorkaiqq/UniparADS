package org.example.pdvapi.interfaces;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.pdvapi.entity.ProdutoEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Tag(name = "Produto", description = "Endpoints de Produto")
@RequestMapping("/produto")
public interface IProdutoController {

    @Operation(summary = "Cria um novo produto")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "201", description = "Produto criado com sucesso"),
            @ApiResponse (responseCode = "400", description = "Parâmetros inválidos")
    })
    @PostMapping
    ResponseEntity<ProdutoEntity> insert(@RequestBody @Valid ProdutoEntity produto, UriComponentsBuilder uriBuilder);

    @Operation(summary = "Atualiza um produto")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200", description = "Produto atualizado com sucesso"),
            @ApiResponse (responseCode = "204", description = "Produto não encontrado"),
            @ApiResponse (responseCode = "400", description = "Parâmetros inválidos")
    })
    @PutMapping("/{id}")
    ResponseEntity<ProdutoEntity> update(@PathVariable Long id, @RequestBody @Valid ProdutoEntity produto);

    @Operation(summary = "Deleta um produto")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200", description = "Produto deletado com sucesso"),
            @ApiResponse (responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse (responseCode = "404", description = "Produto não encontrado")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);

    @Operation(summary = "Busca um produto pelo ID")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200", description = "Produto encontrado com sucesso"),
            @ApiResponse (responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse (responseCode = "204", description = "Produto não encontrado")
    })
    @GetMapping("/search/{id}")
    ResponseEntity<ProdutoEntity> findById(@PathVariable Long id);

    @Operation(summary = "Busca todos os produtos")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200", description = "Produtos encontrados com sucesso"),
            @ApiResponse (responseCode = "204", description = "Nenhum produto encontrado")
    })
    @GetMapping("/all")
    ResponseEntity<List<ProdutoEntity>> findAll();

    @Operation(summary = "Busca os produto pela descrição")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200", description = "Produtos encontrados com sucesso"),
            @ApiResponse (responseCode = "204", description = "Nenhum produto encontrado"),
            @ApiResponse (responseCode = "400", description = "Parâmetros inválidos")
    })
    @GetMapping("/search")
    ResponseEntity<List<ProdutoEntity>> findByDescricao(@RequestParam String nome);

}
