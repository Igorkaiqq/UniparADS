package com.mycompany.clinica.ws.exceptions;

public class ExceptionQuantidadeDeCaracteres extends Exception {

        public ExceptionQuantidadeDeCaracteres(String objeto, String campo, int quantidade){
            super("A entidade " + objeto + " não pode ter o campo " + campo + " com mais de " + quantidade + " caracteres");
        }
}
