package com.mycompany.clinica.ws.services.validation;

import com.mycompany.clinica.ws.exceptions.ExceptionCampoNumerico;
import com.mycompany.clinica.ws.exceptions.ExceptionEntedidadeNaoInformada;
import com.mycompany.clinica.ws.model.EnderecoModel;

public class ValidationCampoNegativo {

    public static <T> boolean validaCampoNegativo(T objeto) throws ExceptionEntedidadeNaoInformada, ExceptionCampoNumerico {

        if (objeto == null){
            throw new ExceptionEntedidadeNaoInformada();
        }

        if (objeto instanceof EnderecoModel){
            EnderecoModel endereco = (EnderecoModel) objeto;
            if (endereco.getNumero() < 0){
                throw new ExceptionCampoNumerico("Número");
            }
        }
        return true;
    }

}
