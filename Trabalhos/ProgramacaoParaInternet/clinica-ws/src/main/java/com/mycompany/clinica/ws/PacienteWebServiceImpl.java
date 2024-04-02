package com.mycompany.clinica.ws;

import com.mycompany.clinica.ws.interfaces.PacienteInterface;
import com.mycompany.clinica.ws.model.PacienteModel;
import com.mycompany.clinica.ws.services.PacienteService;
import jakarta.jws.WebService;

import java.util.ArrayList;

@WebService(serviceName = "PacienteWebServiceImpl", endpointInterface = "com.mycompany.clinica.ws.PacienteWebServiceImpl")
public class PacienteWebServiceImpl implements PacienteInterface {

    PacienteService pacienteService = new PacienteService();

    @Override
    public ArrayList<PacienteModel> listAllPaciente() {
        return pacienteService.listAllPaciente();
    }

    @Override
    public PacienteModel findByIdPaciente(int id) {
        return pacienteService.findByIdPaciente(id);
    }

    @Override
    public PacienteModel inserirPaciente(PacienteModel paciente) {
        return pacienteService.inserirPaciente(paciente);
    }

    @Override
    public PacienteModel atualizarPaciente(PacienteModel paciente) {
        return pacienteService.atualizarPaciente(paciente);
    }

    @Override
    public void deletarPaciente(int id) {
        pacienteService.deletarPaciente(id);
    }

    @Override
    public void ativarPaciente(int id) {
        pacienteService.ativarPaciente(id);
    }
}
