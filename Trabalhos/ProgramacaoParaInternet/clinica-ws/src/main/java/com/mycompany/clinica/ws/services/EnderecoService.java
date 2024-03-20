/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.services;

import com.mycompany.clinica.ws.interfaces.EnderecoInterface;
import com.mycompany.clinica.ws.model.EnderecoModel;
import java.util.ArrayList;

/**
 *
 * @author igork
 */
public class EnderecoService implements EnderecoInterface {

    @Override
    public ArrayList<EnderecoModel> findByBairro (String bairro) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<EnderecoModel> findByLikeLogradouro (String logradouro) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<EnderecoModel> listAll () {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EnderecoModel findById (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EnderecoModel inserir (EnderecoModel endereco) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EnderecoModel atualizar (EnderecoModel endereco) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void deletar (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<EnderecoModel> findByCidadeNome (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<EnderecoModel> findByLikeCidadeNome (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<EnderecoModel> findByCEP (String cep) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public boolean existeLogradouro(EnderecoModel endereco) {
        return false;
    }
    
    public boolean enderecoVazio(EnderecoModel endereco) {
        return false;
    }
    
    public boolean cepValido(EnderecoModel endereco){
        return false;
    }
    
    public boolean existeCidade (EnderecoModel endereco){
        return false;
    }
    
}


