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
    public ArrayList<PessoaModel> findByNome (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<PessoaModel> findByLikeNome (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EnderecoModel findByCPF (String crm) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<PessoaModel> listAll () {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EnderecoModel findById (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EnderecoModel inserir (PessoaModel pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EnderecoModel atualizar (PessoaModel pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void deletar (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
