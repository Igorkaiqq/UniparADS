/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica2.model;

/**
 *
 * @author igork
 */
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author igork
 */
@ToString
@Setter
@Getter
public class EnderecoModel {
    
    public int id;
    public String Logradouro;
    private String bairro;
    private int numero;
    private String complemento;
    
}

