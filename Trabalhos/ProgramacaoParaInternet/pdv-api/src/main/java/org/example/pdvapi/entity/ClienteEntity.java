package org.example.pdvapi.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import org.example.pdvapi.validation.SomenteLetras;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cliente", uniqueConstraints = @UniqueConstraint(columnNames = {"Cpf", "Email"}))
@Schema(description = "Entidade Cliente")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @Schema(description = "Identificador do cliente", example = "1")
    private Long id;

    @NotNull
    @NotEmpty
    @SomenteLetras
    @Size(min = 1, max = 120, message = "O nome deve ter entre 1 e 120 caracteres")
    @Column(name = "Nome")
    @Schema(description = "Nome do cliente", example = "João da Silva")
    private String nome;

    @NotNull
    @NotEmpty
    @CPF
    @Column(name = "Cpf")
    @Schema(description = "CPF do cliente", example = "123.456.789-00")
    private String cpf;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 50, message = "O e-mail deve ter entre 1 e 50 caracteres")
    @Column(name = "Email")
    @Email
    @Schema(description = "E-mail do cliente", example = "joaodasilva@gmail.com")
    private String email;
}
