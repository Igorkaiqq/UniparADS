/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.model;

/**
 *
 * @author igork
 */
public class PacienteModel {
    
    private int id;
    private PessoaModel pessoa;
    private EnderecoModel enderecoCompleto;
    private String statusRegistro;

    public PacienteModel() {
    }

    public PacienteModel(PessoaModel pessoa, EnderecoModel enderecoCompleto, String statusRegistro) {
        this.pessoa = pessoa;
        this.enderecoCompleto = enderecoCompleto;
        this.statusRegistro = statusRegistro;
    }

    public int getId() {
        return id;
    }

    public PessoaModel getPessoa () {
        return pessoa;
    }

    public void setPessoa (PessoaModel pessoa) {
        this.pessoa = pessoa;
    }

    public EnderecoModel getEnderecoCompleto() {
        return enderecoCompleto;
    }

    public void setEnderecoCompleto(EnderecoModel enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }

    public String getStatusRegistro() {
        return statusRegistro;
    }

    public void setStatusRegistro(String statusRegistro) {
        this.statusRegistro = statusRegistro;
    }
    
}
