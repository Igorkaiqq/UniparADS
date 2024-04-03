package com.mycompany.clinica.ws.exceptions;

import jakarta.xml.ws.WebFault;

@WebFault
public class ExceptionId extends Exception {

        public ExceptionId(int id, String entidade){
            super("Id " + id + " não encontrado no banco de dados para "+ entidade +". Verifique se o id está correto ou se o registro foi excluído");
        }

}
