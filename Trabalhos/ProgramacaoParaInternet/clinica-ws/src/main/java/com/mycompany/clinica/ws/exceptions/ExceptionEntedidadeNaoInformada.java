package com.mycompany.clinica.ws.exceptions;

import jakarta.xml.ws.WebFault;

@WebFault
public class ExceptionEntedidadeNaoInformada extends Exception {

        public ExceptionEntedidadeNaoInformada(){
            super("Entidade não informada para cadastro. Verifique se está enviando os dados corretamente");
        }
}
