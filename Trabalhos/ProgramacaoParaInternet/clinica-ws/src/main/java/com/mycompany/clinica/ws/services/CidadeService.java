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
    public ArrayList<CidadeModel> findByCidadeNomeCidade (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<CidadeModel> findByLikeCidadeNomeCidade (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<CidadeModel> findByEstadoNomeCidade (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<CidadeModel> findByEstadoSiglaCidade (String sigla) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<CidadeModel> listAllCidade () {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public CidadeModel findByIdCidade (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public CidadeModel inserirCidade (CidadeModel cidade) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public CidadeModel atualizarCidade (CidadeModel cidade) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void deletarCidade (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
