/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author igork
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteModel {
    
    private int id;
    private PessoaModel pessoa;
    private String statusRegistro;
    
}
