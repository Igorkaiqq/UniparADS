package com.mycompany.clinica.ws;

import com.mycompany.clinica.ws.interfaces.ConsultaInterface;
import com.mycompany.clinica.ws.model.ConsultaModel;
import com.mycompany.clinica.ws.repository.ConsultaRepository;
import com.mycompany.clinica.ws.services.ConsultaService;
import jakarta.jws.WebService;

import java.util.ArrayList;

@WebService(serviceName = "ConsultaWebServiceImpl", endpointInterface = "com.mycompany.clinica.ws.interfaces.ConsultaInterface")
public class ConsultaWebServiceImpl implements ConsultaInterface {

    private final ConsultaService consultaService;

    public ConsultaWebServiceImpl(){
        ConsultaRepository consultaRepository = new ConsultaRepository();
        this.consultaService = new ConsultaService(consultaRepository);
    }

    @Override
    public ArrayList<ConsultaModel> listAllConsulta() {

        return consultaService.listAllConsulta();
    }

    @Override
    public ConsultaModel findByIdConsulta(int id) {
        return consultaService.findByIdConsulta(id);
    }

    @Override
    public ConsultaModel inserirConsulta(ConsultaModel consulta) {

        return consultaService.inserirConsulta(consulta);
    }

    @Override
    public ConsultaModel cancelarConsulta(int id, String motivo) {
        return consultaService.cancelarConsulta(id, motivo);
    }
}
