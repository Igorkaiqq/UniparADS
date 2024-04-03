package com.mycompany.clinica.ws;

import com.mycompany.clinica.ws.exceptions.*;
import com.mycompany.clinica.ws.interfaces.EstadoInterface;
import com.mycompany.clinica.ws.model.EstadoModel;
import com.mycompany.clinica.ws.repository.EstadoRepository;
import com.mycompany.clinica.ws.services.EstadoService;
import jakarta.jws.WebService;

import java.sql.SQLException;
import java.util.ArrayList;

@WebService(serviceName = "EstadoWebServiceImpl",
        endpointInterface = "com.mycompany.clinica.ws.interfaces.EstadoInterface")
public class EstadoWebServiceImpl implements EstadoInterface {

    private final EstadoService estadoService;

    public EstadoWebServiceImpl(){
        EstadoRepository estadoRepository = new EstadoRepository();
        this.estadoService = new EstadoService(new EstadoRepository());
    }

    @Override
    public ArrayList<EstadoModel> listAllEstado() {
        return estadoService.listAllEstado();
    }

    @Override
    public EstadoModel findByIdEstado(int id) throws ExceptionNumeroNegativo, ExceptionId {
        return estadoService.findByIdEstado(id);
    }

    @Override
    public EstadoModel inserirEstado(EstadoModel estado) throws
            ExceptionCamposVazio,
            ExceptionQuantidadeDeCaracteres,
            ExceptionEntedidadeNaoInformada {
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
