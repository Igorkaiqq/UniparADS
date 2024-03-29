/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.clinica.ws.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author igork
 */
@Getter
@AllArgsConstructor
public enum StatusRegistroEnum {
    INATIVO(0),
    ATIVO(1);

    private final int valor;

    public static StatusRegistroEnum getINATIVO() {
        return INATIVO;
    }

    public static StatusRegistroEnum getATIVO() {
        return ATIVO;
    }
    
    
    
}

