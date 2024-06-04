package org.example.pdvapi.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.pdvapi.validation.SomenteLetras;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Venda")
public class VendaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @Schema(description = "Identificador da venda", example = "1")
    private Long id;

    @NotNull
    @NotEmpty
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "Data")
    @Schema(description = "Data da venda", example = "01/01/2021")
    private Date data;

    @NotNull
    @JoinColumn(name = "ClienteId", referencedColumnName = "Id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @Schema(description = "Cliente relacionado a venda")
    private ClienteEntity cliente;

    @NotNull
    @Column(name = "ValorTotal")
    @Positive(message = "O valor total deve ser positivo")
    @Schema(description = "Valor total da venda", example = "100.0")
    private Double valorTotal;

    @NotNull
    @NotEmpty
    @SomenteLetras
    @Size(min = 1, max = 500, message = "As observações devem ter entre 1 e 500 caracteres")
    @Column(name = "Observacoes")
    @Schema(description = "Observações da venda", example = "Cliente pediu para entregar na casa dele")
    private String observacoes;
}
