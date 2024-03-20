/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.model;

/**
 *
 * @author igork
 */
public class EstadoModel {
    
    private int id;
    private String nome;
    private String sigla;

    public EstadoModel () {
    }

    public EstadoModel (String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public int getId () {
        return id;
    }

    public String getNome () {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getSigla () {
        return sigla;
    }

    public void setSigla (String sigla) {
        this.sigla = sigla;
    }
    
}
