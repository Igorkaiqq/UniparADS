/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.model;

/**
 *
 * @author igork
 */
public class MedicoModel {
    
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    private EspecialidadeModel especialidade;
    private EnderecoModel enderecoCompleto;
    private boolean statusRegistro;

    public MedicoModel() {
    }

    public MedicoModel(String nome, String email, String telefone, String crm, EspecialidadeModel especialidade, EnderecoModel enderecoCompleto, boolean statusRegistro) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.crm = crm;
        this.especialidade = especialidade;
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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public EspecialidadeModel getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(EspecialidadeModel especialidade) {
        this.especialidade = especialidade;
    }

    public EnderecoModel getEnderecoCompleto() {
        return enderecoCompleto;
    }

    public void setEnderecoCompleto(EnderecoModel enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }

    public boolean isStatusRegistro() {
        return statusRegistro;
    }

    public void setStatusRegistro(boolean statusRegistro) {
        this.statusRegistro = statusRegistro;
    }

}
