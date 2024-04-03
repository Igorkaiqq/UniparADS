package com.mycompany.clinica.ws.exceptions;

import jakarta.xml.ws.WebFault;

@WebFault
public class ExceptionCampoBloqueadoUpdate extends Exception {

    public ExceptionCampoBloqueadoUpdate(String entidade, String campo) {
        super("O campo " + campo + " da entidade " + entidade + " não pode ser alterado.");
    }

}
