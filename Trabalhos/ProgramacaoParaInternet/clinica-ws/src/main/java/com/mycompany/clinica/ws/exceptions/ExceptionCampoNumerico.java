package com.mycompany.clinica.ws.exceptions;

public class ExceptionCampoNumerico extends Exception {

    public ExceptionCampoNumerico(String campo){
        super("Campo " + campo + " deve conter somente caracteres numéricos");
    }

}
