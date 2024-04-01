/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.services;

import com.mycompany.clinica.ws.interfaces.PacienteInterface;
import com.mycompany.clinica.ws.model.PacienteModel;
import com.mycompany.clinica.ws.repository.PacienteRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 *
 * @author igork
 */

public class PacienteService implements PacienteInterface {

    public final PacienteRepository pacienteRepository = null;
    
    public PacienteService(){
        
    }
    
    @Override
    public ArrayList<PacienteModel> listAllPaciente() {
        return null;
    }

    @Override
    public PacienteModel findByIdPaciente(int id) {
        return null;
    }

    @Override
    public PacienteModel inserirPaciente(PacienteModel paciente) {
        return null;
    }

    @Override
    public PacienteModel atualizarPaciente(PacienteModel paciente) {
        return null;
    }

    @Override
    public void deletarPaciente(int id) {

    }

    @Override
    public void ativarPaciente(int id) {

    }
}
