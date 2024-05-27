package org.example.pdvapi.entity;

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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cliente", uniqueConstraints = @UniqueConstraint(columnNames = {"Cpf", "Email"}))
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @NotNull
    @NotEmpty
    @SomenteLetras
    @Column(name = "Nome")
    @Size(min = 1, max = 120, message = "O nome deve ter entre 1 e 120 caracteres")
    private String nome;

    @NotNull
    @NotEmpty
    @Column(name = "Cpf")
    private String cpf;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 50, message = "O e-mail deve ter entre 1 e 50 caracteres")
    @Column(name = "Email")
    @Email
    private String email;
}
