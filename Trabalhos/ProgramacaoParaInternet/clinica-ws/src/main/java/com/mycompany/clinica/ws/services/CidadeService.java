/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.services;

import com.mycompany.clinica.ws.interfaces.CidadeInterface;
import com.mycompany.clinica.ws.model.CidadeModel;
import com.mycompany.clinica.ws.model.EstadoModel;
import java.util.ArrayList;

/**
 *
 * @author igork
 */
public class CidadeService implements CidadeInterface {

    @Override
    public ArrayList<CidadeModel> findByCidadeNome (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<CidadeModel> findByLikeCidadeNome (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<CidadeModel> findByEstadoNome (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<CidadeModel> findByEstadoSigla (String sigla) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<CidadeModel> listAll () {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public CidadeModel findById (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public CidadeModel inserir (CidadeModel cidade) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public CidadeModel atualizar (CidadeModel cidade) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void deletar (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public boolean camposVazio(CidadeModel cidade){
        return false;
    }
    
    public boolean existeCidade(EstadoModel estado){
        
        return false;
    }
    
    public boolean existeEstado(EstadoModel estado){
        
        return false;
    }
    
}
