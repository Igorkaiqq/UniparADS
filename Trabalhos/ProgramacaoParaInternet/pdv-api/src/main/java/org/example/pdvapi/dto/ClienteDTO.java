package org.example.pdvapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record ClienteDTO(String nome, String cpf, String email) {
}
