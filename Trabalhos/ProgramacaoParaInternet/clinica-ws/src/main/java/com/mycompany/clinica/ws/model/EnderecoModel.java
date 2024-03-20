/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.model;

import lombok.Data;

/**
 *
 * @author igork
 */


public class EnderecoModel {
    
    private int id;
    private String Logradouro;
    private String bairro;
    private int numero;
    private String complemento;
    private String cep;
    private CidadeModel cidade;

    public EnderecoModel() {
    }

    public EnderecoModel (String Logradouro, String bairro, int numero, String complemento, String cep, CidadeModel cidade) {
        this.Logradouro = Logradouro;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
    }

    public int getId () {
        return id;
    }

    public String getLogradouro () {
        return Logradouro;
    }

    public void setLogradouro (String Logradouro) {
        this.Logradouro = Logradouro;
    }

    public String getBairro () {
        return bairro;
    }

    public void setBairro (String bairro) {
        this.bairro = bairro;
    }

    public int getNumero () {
        return numero;
    }

    public void setNumero (int numero) {
        this.numero = numero;
    }

    public String getComplemento () {
        return complemento;
    }

    public void setComplemento (String complemento) {
        this.complemento = complemento;
    }

    public String getCep () {
        return cep;
    }

    public void setCep (String cep) {
        this.cep = cep;
    }

    public CidadeModel getCidade () {
        return cidade;
    }

    public void setCidade (CidadeModel cidade) {
        this.cidade = cidade;
    }
   
   
    
}
