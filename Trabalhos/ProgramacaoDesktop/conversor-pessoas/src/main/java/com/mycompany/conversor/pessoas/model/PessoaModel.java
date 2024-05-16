/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conversor.pessoas.model;

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
    private String cpf;
    private String rg;
    private String data_nasc;
    private String sexo;
    private String signo;
    private String mae;
    private String pai;
    private String email;
    private String senha;
    private String cep;
    private String endereco;
    private int numero;
    private String bairro;
    private String estado;
    private String telefone_fixo;
    private String celular;
    private double altura;
    private double peso;
    private int tipo_sanguineo;
    private String cor;
}
