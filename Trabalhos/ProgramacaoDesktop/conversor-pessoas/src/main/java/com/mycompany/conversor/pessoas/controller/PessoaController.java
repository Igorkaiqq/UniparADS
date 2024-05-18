/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conversor.pessoas.controller;

import com.mycompany.conversor.pessoas.dao.PessoaDAO;
import com.mycompany.conversor.pessoas.infraestrutura.ConnectionFactory;
import com.mycompany.conversor.pessoas.model.PessoaModel;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igork
 */
public class PessoaController {
    
    private final PessoaDAO pessoaDAO;

    public PessoaController(){
        this.pessoaDAO = new PessoaDAO(ConnectionFactory.getEntityManager());
    }

    public int salvarPessoaController(PessoaModel pessoa){
        return this.pessoaDAO.salvarPessoas(pessoa);
    }
    
    public List<PessoaModel> getAllPessoaController(){
        return this.pessoaDAO.getAllPessoas();
    }
    
}
