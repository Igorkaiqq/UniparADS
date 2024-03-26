package com.mycompany.clinica.ws.repository;

import com.mycompany.clinica.ws.interfaces.PacienteInterface;
import com.mycompany.clinica.ws.model.EnderecoModel;
import com.mycompany.clinica.ws.model.PacienteModel;

import java.util.ArrayList;

public class PacienteRepository implements PacienteInterface {
    @Override
    public ArrayList<PacienteModel> findByNomePaciente(String nome) {
        return null;
    }

    @Override
    public ArrayList<PacienteModel> findByLikeNomePaciente(String nome) {
        return null;
    }

    @Override
    public ArrayList<PacienteModel> listAllPaciente() {
        return null;
    }

    @Override
    public ArrayList<PacienteModel> findByStatusPaciente(String nome) {
        return null;
    }

    @Override
    public EnderecoModel findByIdPaciente(int id) {
        return null;
    }

    @Override
    public EnderecoModel inserirPaciente(PacienteModel paciente) {
        return null;
    }

    @Override
    public EnderecoModel atualizarPaciente(PacienteModel paciente) {
        return null;
    }

    @Override
    public void deletarPaciente(int id) {

    }
}
