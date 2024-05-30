package org.example.pdvapi.Enums;

public enum UsuariosPermissaoEnum {

    ADMIN("admin"),
    USER("user");

    private String role;

    UsuariosPermissaoEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
