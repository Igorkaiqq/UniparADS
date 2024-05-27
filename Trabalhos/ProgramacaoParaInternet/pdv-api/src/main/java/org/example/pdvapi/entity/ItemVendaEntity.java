package org.example.pdvapi.entity;

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
    private Long id;

    @NotNull
    @Min(value = 1, message = "A quantidade deve ser pelo menos 1")
    @Column(name = "Quantidade")
    private int quantidade;

    @NotNull
    @PositiveOrZero(message = "O valor unitário deve ser zero ou positivo")
    @Column(name = "ValorUnitario")
    private Double valorUnitario;

    @NotNull
    @PositiveOrZero(message = "O valor total deve ser zero ou positivo")
    @Column(name = "ValorTotal")
    private Double valorTotal;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "VendaId", referencedColumnName = "Id")
    private VendaEntity venda;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ProdutoId", referencedColumnName = "Id")
    private ProdutoEntity produto;
}
