package com.mycompany.clinica.ws.services.validation;

import com.mycompany.clinica.ws.model.EnderecoModel;

public class EnderecoValidation {

    public boolean existeLogradouro(EnderecoModel endereco) {
        return false;
    }

    public boolean enderecoVazio(EnderecoModel endereco) {
        return false;
    }

    public boolean cepValido(EnderecoModel endereco){
        return false;
    }

}
