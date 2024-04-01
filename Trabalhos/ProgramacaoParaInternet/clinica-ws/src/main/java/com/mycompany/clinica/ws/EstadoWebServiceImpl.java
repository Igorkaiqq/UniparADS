package com.mycompany.clinica.ws;

import com.mycompany.clinica.ws.exceptions.ExceptionId;
import com.mycompany.clinica.ws.exceptions.ExceptionNumeroNegativo;
import com.mycompany.clinica.ws.interfaces.EstadoInterface;
import com.mycompany.clinica.ws.model.EstadoModel;
import com.mycompany.clinica.ws.services.EstadoService;
import jakarta.jws.WebService;

import java.util.ArrayList;
@WebService(endpointInterface = "com.mycompany.clinica.ws.interfaces.EstadoInterface")
public class EstadoWebServiceImpl implements EstadoInterface {

    EstadoService estadoService = new EstadoService();

    @Override
    public ArrayList<EstadoModel> listAllEstado() {
        return estadoService.listAllEstado();
    }

    @Override
    public EstadoModel findByIdEstado(int id) throws ExceptionNumeroNegativo, ExceptionId {
        return estadoService.findByIdEstado(id);
    }

    @Override
    public EstadoModel inserirEstado(EstadoModel estado) {
        return estadoService.inserirEstado(estado);
    }

    @Override
    public EstadoModel atualizarEstado(EstadoModel estado) {
        return estadoService.atualizarEstado(estado);
    }

    @Override
    public void deletarEstado(int id) {
         estadoService.deletarEstado(id);
    }
}
