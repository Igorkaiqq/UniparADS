package com.mycompany.clinica.ws.exceptions;

import jakarta.xml.ws.WebFault;

@WebFault
public class ExceptionCampoNumerico extends Exception {

    public ExceptionCampoNumerico(String campo){
        super("Campo " + campo + " deve conter somente caracteres numéricos");
    }

}
