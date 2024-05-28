package org.example.pdvapi.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.pdvapi.validation.SomenteLetras;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Produto")
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador do produto", example = "1")
    private Long id;

    @NotNull
    @NotEmpty
    @SomenteLetras
    @Size(min = 1, max = 120, message = "O nome deve ter entre 1 e 120 caracteres")
    @Column(name = "Descricao")
    @Schema(description = "Descrição do produto", example = "Coca-Cola 2L")
    String descricao;

    @NotNull
    @Positive(message = "O preço deve ser positivo")
    @Column(name = "Preco")
    @Schema(description = "Preço do produto", example = "5.0")
    Double preco;

    @NotNull
    @NotEmpty
    @SomenteLetras
    @Size(min = 1, max = 30, message = "A categoria deve ter entre 1 e 30 caracteres")
    @Column(name = "Categoria")
    @Schema(description = "Categoria do produto", example = "Bebidas")
    String categoria;

}
