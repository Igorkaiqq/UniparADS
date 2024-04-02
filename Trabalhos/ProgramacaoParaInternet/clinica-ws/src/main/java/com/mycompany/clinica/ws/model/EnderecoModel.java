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
public class EnderecoModel {
    
    private int id;
    private String logradouro;
    private String bairro;
    private int numero;
    private String complemento;
    private String cep;
    private CidadeModel cidade;
    
}
