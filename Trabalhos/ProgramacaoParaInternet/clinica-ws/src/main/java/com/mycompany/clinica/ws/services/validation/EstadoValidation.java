package com.mycompany.clinica.ws.services.validation;

import com.mycompany.clinica.ws.model.EstadoModel;

public class EstadoValidation {

    public boolean camposVazio(EstadoModel estado){
        return false;
    }

    public boolean tamanhoSigla(EstadoModel estado){
        return false;
    }

    public boolean existeEstado(EstadoModel estado){

        return false;
    }

}
