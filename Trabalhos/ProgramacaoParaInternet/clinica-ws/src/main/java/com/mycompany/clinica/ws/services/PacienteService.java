/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.services;

import com.mycompany.clinica.ws.interfaces.PacienteInterface;
import com.mycompany.clinica.ws.model.EnderecoModel;
import com.mycompany.clinica.ws.model.PacienteModel;
import java.util.ArrayList;

/**
 *
 * @author igork
 */
public class PacienteService implements PacienteInterface {

    @Override
    public ArrayList<PacienteModel> findByNome (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<PacienteModel> findByLikeNome (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<PacienteModel> listAll () {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<PacienteModel> findByStatus (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EnderecoModel findById (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EnderecoModel inserir (PacienteModel paciente) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EnderecoModel atualizar (PacienteModel paciente) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void deletar (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
