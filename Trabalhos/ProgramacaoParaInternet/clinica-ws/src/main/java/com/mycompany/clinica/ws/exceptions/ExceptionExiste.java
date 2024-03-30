package com.mycompany.clinica.ws.exceptions;

public class ExceptionExiste extends Exception {

        public ExceptionExiste(String objeto, String campo, String nome){
            super("Já existe um(a) " + objeto + " com o(a) " + campo + " " + nome + " cadastrado(a)");
        }
}
