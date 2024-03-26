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
    public ArrayList<MedicoModel> findByNomeMedico (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<MedicoModel> findByLikeNomeMedico (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EnderecoModel findByCRMMedico (String crm) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<MedicoModel> findByEspecialidadeMedico (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<MedicoModel> listAllMedico () {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<MedicoModel> findByStatusMedico (String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EnderecoModel findByIdMedico (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EnderecoModel inserirMedico (MedicoModel endereco) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EnderecoModel atualizarMedico (MedicoModel endereco) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void deletarMedico (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
