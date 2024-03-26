/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.services;

import com.mycompany.clinica.ws.interfaces.PessoaInterface;
import com.mycompany.clinica.ws.model.EnderecoModel;
import com.mycompany.clinica.ws.model.PessoaModel;
import java.util.ArrayList;

/**
 *
 * @author igork
 */
public class PessoaService implements PessoaInterface {

    @Override
    public ArrayList<PessoaModel> findByNomePessoa (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<PessoaModel> findByLikeNomePessoa (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public PessoaModel findByCPFPessoa (String crm) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<PessoaModel> listAllPessoa () {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public PessoaModel findByIdPessoa (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public PessoaModel inserirPessoa (PessoaModel pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public PessoaModel atualizarPessoa (PessoaModel pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean deletarPessoa (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
