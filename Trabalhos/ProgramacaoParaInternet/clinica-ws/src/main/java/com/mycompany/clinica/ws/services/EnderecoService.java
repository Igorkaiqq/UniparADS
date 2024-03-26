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
    public ArrayList<EnderecoModel> findByBairroEndereco (String bairro) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<EnderecoModel> findByLikeLogradouroEndereco (String logradouro) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<EnderecoModel> listAllEndereco () {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EnderecoModel findByIdEndereco (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EnderecoModel inserirEndereco (EnderecoModel endereco) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EnderecoModel atualizarEndereco (EnderecoModel endereco) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void deletarEndereco (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<EnderecoModel> findByCidadeNomeEndereco (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<EnderecoModel> findByLikeCidadeNomeEndereco (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<EnderecoModel> findByCEPEndereco (String cep) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}


