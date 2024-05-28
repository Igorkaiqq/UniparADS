package org.example.pdvapi.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ItemVenda")
public class ItemVendaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @Schema(description = "Identificador do item de venda", example = "1")
    private Long id;

    @NotNull
    @Min(value = 1, message = "A quantidade deve ser pelo menos 1")
    @Column(name = "Quantidade")
    @Schema(description = "Quantidade do produto", example = "2")
    private int quantidade;

    @NotNull
    @PositiveOrZero(message = "O valor unitário deve ser zero ou positivo")
    @Column(name = "ValorUnitario")
    @Schema(description = "Valor unitário do produto", example = "5.0")
    private Double valorUnitario;

    @NotNull
    @PositiveOrZero(message = "O valor total deve ser zero ou positivo")
    @Column(name = "ValorTotal")
    @Schema(description = "Valor total do item de venda", example = "10.0")
    private Double valorTotal;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "VendaId", referencedColumnName = "Id")
    @Schema(description = "Venda relacionada ao item", example = "1")
    private VendaEntity venda;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ProdutoId", referencedColumnName = "Id")
    @Schema(description = "Produto relacionado ao item", example = "1")
    private ProdutoEntity produto;
}
