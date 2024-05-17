/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conversor.pessoas.controller;

import com.mycompany.conversor.pessoas.dao.PessoaDAO;
import com.mycompany.conversor.pessoas.model.PessoaModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igork
 */
public class PessoaController {
    
    private PessoaDAO pessoaDAO = new PessoaDAO();
    
    public int salvarPessoaController(PessoaModel pessoa){
        return this.pessoaDAO.salvarPessoas(pessoa);
    }
    
    public List<PessoaModel> getAllPessoaController(){
        return this.pessoaDAO.getAllPessoas();
    }
    
}
