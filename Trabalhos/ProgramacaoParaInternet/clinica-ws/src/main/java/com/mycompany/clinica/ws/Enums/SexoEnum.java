package com.mycompany.clinica.ws.Enums;

public enum SexoEnum {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    NAODECLARADO("Não declarado");

    private final String sexo;

    SexoEnum(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }
}
