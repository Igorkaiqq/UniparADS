/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.services;

import com.mycompany.clinica.ws.interfaces.EstadoInterface;
import com.mycompany.clinica.ws.model.EstadoModel;
import java.util.ArrayList;

/**
 *
 * @author igork
 */
public class EstadoService implements EstadoInterface {

    @Override
    public ArrayList<EstadoModel> findByNome (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<EstadoModel> findByLikeNome (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<EstadoModel> findBySigla (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<EstadoModel> listAll () {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EstadoModel findById (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EstadoModel inserir (EstadoModel estado) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EstadoModel atualizar (EstadoModel estado) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void deletar (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public boolean camposVazio(EstadoModel estado){
        return false;
    }
    
    public boolean tamanhoSigla(EstadoModel estado){
        return false;
    }
    
    public boolean existeEstado(EstadoModel estado){
        
        return false;
    }
    
}
