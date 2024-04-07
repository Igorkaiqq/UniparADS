package com.mycompany.clinica.ws;

import com.mycompany.clinica.ws.interfaces.MedicoInterface;
import com.mycompany.clinica.ws.model.MedicoModel;
import com.mycompany.clinica.ws.services.MedicoService;
import jakarta.jws.WebService;

import java.util.ArrayList;

@WebService(serviceName = "MedicoWebServiceImpl", endpointInterface = "com.mycompany.clinica.ws.interfaces.MedicoInterface")
public class MedicoWebServiceImpl implements MedicoInterface {

    MedicoService medicoService = new MedicoService();

    @Override
    public ArrayList<MedicoModel> listAllMedico() {
        return medicoService.listAllMedico();
    }

    @Override

    public MedicoModel findByIdMedico(int id) {
        return medicoService.findByIdMedico(id);
    }

    @Override
    public MedicoModel inserirMedico(MedicoModel medico) {
        return medicoService.inserirMedico(medico);
    }

    @Override
    public MedicoModel atualizarMedico(MedicoModel medico) {
        return medicoService.atualizarMedico(medico);
    }

    @Override
    public void deletarMedico(int id) {
        medicoService.deletarMedico(id);
    }


    @Override
    public void ativarMedico(int id) {
        medicoService.ativarMedico(id);
    }
}
