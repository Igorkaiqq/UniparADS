package com.mycompany.clinica.ws.exceptions;

public class ExceptionCamposVazio extends Exception {

        public ExceptionCamposVazio(String campo){
            super("Não pode conter campos vázios no(a) " + campo + ". Exceto complemento e número.");
        }
}
