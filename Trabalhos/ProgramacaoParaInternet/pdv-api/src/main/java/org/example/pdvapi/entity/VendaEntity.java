package org.example.pdvapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.pdvapi.validation.SomenteLetras;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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
    private Long id;

    @NotNull
    @NotEmpty
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "Data")
    private Date data;

    @NotNull
    @JoinColumn(name = "ClienteId", referencedColumnName = "Id")
    @OneToOne
    private ClienteEntity cliente;

    @NotNull
    @Column(name = "ValorTotal")
    @Positive(message = "O valor total deve ser positivo")
    private Double valorTotal;

    @NotNull
    @NotEmpty
    @SomenteLetras
    @Size(min = 1, max = 500, message = "As observações devem ter entre 1 e 500 caracteres")
    @Column(name = "Observacoes")
    private String observacoes;
}
