package com.mycompany.clinica.ws.repository;

import com.mycompany.clinica.ws.interfaces.MedicoInterface;
import com.mycompany.clinica.ws.model.EnderecoModel;
import com.mycompany.clinica.ws.model.MedicoModel;

import java.util.ArrayList;

public class MedicoRepository implements MedicoInterface {
    @Override
    public ArrayList<MedicoModel> findByNomeMedico(String nome) {
        return null;
    }

    @Override
    public ArrayList<MedicoModel> findByLikeNomeMedico(String nome) {
        return null;
    }

    @Override
    public EnderecoModel findByCRMMedico(String crm) {
        return null;
    }

    @Override
    public ArrayList<MedicoModel> findByEspecialidadeMedico(String nome) {
        return null;
    }

    @Override
    public ArrayList<MedicoModel> listAllMedico() {
        return null;
    }

    @Override
    public ArrayList<MedicoModel> findByStatusMedico(String nome) {
        return null;
    }

    @Override
    public EnderecoModel findByIdMedico(int id) {
        return null;
    }

    @Override
    public EnderecoModel inserirMedico(MedicoModel medico) {
        return null;
    }

    @Override
    public EnderecoModel atualizarMedico(MedicoModel medico) {
        return null;
    }

    @Override
    public void deletarMedico(int id) {

    }
}
