/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.model;

/**
 *
 * @author igork
 */
public class CidadeModel {
    
    private int id;
    private String nome;
    private EstadoModel estado;

    public CidadeModel () {
    }

    public CidadeModel (String nome, EstadoModel estado) {
        this.nome = nome;
        this.estado = estado;
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

    public EstadoModel getEstado () {
        return estado;
    }

    public void setEstado (EstadoModel estado) {
        this.estado = estado;
    }
    
}
