package com.mycompany.clinica.ws.exceptions;

public class ExceptionCampoBloqueadoUpdate extends Exception {

    public ExceptionCampoBloqueadoUpdate(String entidade, String campo) {
        super("O campo " + campo + " da entidade " + entidade + " não pode ser alterado.");
    }

}
