package com.mycompany.clinica.ws.interfaces;

import com.mycompany.clinica.ws.model.ConsultaModel;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.ArrayList;

@WebService
public interface ConsultaInterface {

    @WebMethod
    ArrayList<ConsultaModel> listAllConsulta();

    @WebMethod
    ConsultaModel findByIdConsulta(int id);

    @WebMethod
    ConsultaModel inserirConsulta(ConsultaModel consulta);

    @WebMethod
    ConsultaModel cancelarConsulta(int id, String motivo);

}
