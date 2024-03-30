package com.mycompany.clinica.ws.services.validation;

import com.mycompany.clinica.ws.exceptions.ExceptionCampoNumerico;
import com.mycompany.clinica.ws.exceptions.ExceptionEntedidadeNaoInformada;
import com.mycompany.clinica.ws.model.PessoaModel;

public class ValidationCampoNumerico {

    public static <T> boolean validaCampoNumerico(T objeto) throws ExceptionEntedidadeNaoInformada, ExceptionCampoNumerico {

        if (objeto == null){
            throw new ExceptionEntedidadeNaoInformada();
        }

        if (objeto instanceof PessoaModel){
            PessoaModel pessoa = (PessoaModel) objeto;
            if (pessoa.getCpf().matches("[0-9]+")){
                throw new ExceptionCampoNumerico("CPF");
            }
            if (pessoa.getTelefone().matches("[0-9]+")){
                throw new ExceptionCampoNumerico("Telefone");
            }
        }
        return true;
    }

}
