package org.example.pdvapi.entity;

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
    private Long id;

    @NotNull
    @NotEmpty
    @SomenteLetras
    @Size(min = 1, max = 120, message = "O nome deve ter entre 1 e 120 caracteres")
    @Column(name = "Descricao")
    String descricao;

    @NotNull
    @Positive(message = "O preço deve ser positivo")
    @Column(name = "Preco")
    Double preco;

    @NotNull
    @NotEmpty
    @SomenteLetras
    @Size(min = 1, max = 30, message = "A categoria deve ter entre 1 e 30 caracteres")
    @Column(name = "Categoria")
    String categoria;

}
