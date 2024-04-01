/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.services;

import com.mycompany.clinica.ws.interfaces.MedicoInterface;
import com.mycompany.clinica.ws.model.EnderecoModel;
import com.mycompany.clinica.ws.model.MedicoModel;
import com.mycompany.clinica.ws.repository.MedicoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


public class MedicoService implements MedicoInterface {

    public final MedicoRepository medicoRepository = null;
    
    public MedicoService(){
        
    }
    
    @Override
    public ArrayList<MedicoModel> listAllMedico() {
        return null;
    }

    @Override
    public MedicoModel findByIdMedico(int id) {
        return null;
    }

    @Override
    public MedicoModel inserirMedico(MedicoModel medico) {
        return null;
    }

    @Override
    public MedicoModel atualizarMedico(MedicoModel medico) {
        return null;
    }

    @Override
    public void deletarMedico(int id) {

    }

    @Override
    public void ativarMedico(int id) {

    }
}
