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
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private EnderecoModel enderecoCompleto;
    private String statusRegistro;

    public PacienteModel() {
    }

    public PacienteModel(String nome, String email, String telefone, String cpf, EnderecoModel enderecoCompleto, String statusRegistro) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.enderecoCompleto = enderecoCompleto;
        this.statusRegistro = statusRegistro;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
