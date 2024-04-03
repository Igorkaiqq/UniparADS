package com.mycompany.clinica.ws.exceptions;

import jakarta.xml.ws.WebFault;

@WebFault
public class ExceptionNumeroNegativo extends Exception {

        public ExceptionNumeroNegativo(String campo){
            super("Campo " + campo + " não pode ser negativo ou igual a 0");
        }

}
