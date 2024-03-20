/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.clinica.ws.Enums;

/**
 *
 * @author igork
 */
public enum StatusRegistroEnum {
    INATIVO(0),
    ATIVO(1);

    private final int valor;

    StatusRegistroEnum(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}

