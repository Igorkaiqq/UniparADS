package com.mycompany.clinica.ws.exceptions;


import jakarta.xml.ws.WebFault;

@WebFault
public class ExceptionCamposVazio extends Exception {

        public ExceptionCamposVazio(String campo){
            super("Não pode conter campos vázios no(a) " + campo + ". Exceto complemento e número.");
        }
}
