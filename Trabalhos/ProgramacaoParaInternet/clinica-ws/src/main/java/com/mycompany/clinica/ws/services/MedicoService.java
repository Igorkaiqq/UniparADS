/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.services;

import com.mycompany.clinica.ws.interfaces.MedicoInterface;
import com.mycompany.clinica.ws.model.EnderecoModel;
import com.mycompany.clinica.ws.model.MedicoModel;
import java.util.ArrayList;

/**
 *
 * @author igork
 */
public class MedicoService implements MedicoInterface {

    @Override
    public ArrayList<MedicoModel> findByNome (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<MedicoModel> findByLikeNome (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EnderecoModel findByCRM (String crm) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<MedicoModel> findByEspecialidade (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<MedicoModel> listAll () {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<MedicoModel> findByStatus (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EnderecoModel findById (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EnderecoModel inserir (MedicoModel endereco) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EnderecoModel atualizar (MedicoModel endereco) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void deletar (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
