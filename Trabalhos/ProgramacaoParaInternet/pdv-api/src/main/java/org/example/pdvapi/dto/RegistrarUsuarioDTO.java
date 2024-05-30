package org.example.pdvapi.dto;

import org.example.pdvapi.Enums.UsuariosPermissaoEnum;

public record RegistrarUsuarioDTO(String nome, String email, String login, String senha, UsuariosPermissaoEnum permissao) {
}
