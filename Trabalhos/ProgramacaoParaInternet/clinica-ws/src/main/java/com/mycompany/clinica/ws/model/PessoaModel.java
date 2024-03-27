/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.model;

import com.mycompany.clinica.ws.Enums.SexoEnum;
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
public class PessoaModel {
    
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private SexoEnum sexo;
    private EnderecoModel endereco;

}
