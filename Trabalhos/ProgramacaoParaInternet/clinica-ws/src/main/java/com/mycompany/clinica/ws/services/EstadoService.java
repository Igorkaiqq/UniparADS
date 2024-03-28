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
    public EstadoModel findByNomeEstado (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<EstadoModel> findByLikeNomeEstado (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EstadoModel findBySiglaEstado (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<EstadoModel> listAllEstado () {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EstadoModel findByIdEstado (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EstadoModel inserirEstado (EstadoModel estado) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EstadoModel atualizarEstado (EstadoModel estado) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean deletarEstado (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
