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
    public ArrayList<PacienteModel> findByNomePaciente (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<PacienteModel> findByLikeNomePaciente (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<PacienteModel> listAllPaciente () {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<PacienteModel> findByStatusPaciente (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EnderecoModel findByIdPaciente (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EnderecoModel inserirPaciente (PacienteModel paciente) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EnderecoModel atualizarPaciente (PacienteModel paciente) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void deletarPaciente (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
