package com.mycompany.clinica.ws.exceptions;

import jakarta.xml.ws.WebFault;

@WebFault
public class ExceptionExiste extends Exception {

        public ExceptionExiste(String objeto, String campo, String nome){
            super("Já existe um(a) " + objeto + " com o(a) " + campo + " " + nome + " cadastrado(a)");
        }
}
