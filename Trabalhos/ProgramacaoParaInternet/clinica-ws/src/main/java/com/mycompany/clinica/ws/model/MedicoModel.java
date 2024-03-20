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
    private PessoaModel pessoa;
    private EspecialidadeModel especialidade;
    private EnderecoModel enderecoCompleto;
    private boolean statusRegistro;

    public MedicoModel() {
    }

    public MedicoModel(PessoaModel pessoa, EspecialidadeModel especialidade, EnderecoModel enderecoCompleto, boolean statusRegistro) {
        this.pessoa = pessoa;
        this.especialidade = especialidade;
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
