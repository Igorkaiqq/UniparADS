/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.services;

import com.mycompany.clinica.ws.exceptions.*;
import com.mycompany.clinica.ws.interfaces.EnderecoInterface;
import com.mycompany.clinica.ws.model.CidadeModel;
import com.mycompany.clinica.ws.model.EnderecoModel;
import com.mycompany.clinica.ws.repository.EnderecoRepository;
import com.mycompany.clinica.ws.services.validation.ValidationCampoVazio;
import com.mycompany.clinica.ws.services.validation.ValidationExisteBanco;
import com.mycompany.clinica.ws.services.validation.ValidationId;
import com.mycompany.clinica.ws.services.validation.ValidationQuantidadeCaracteres;

import java.util.ArrayList;

/**
 *
 * @author igork
 */
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(){
        this.enderecoRepository = new EnderecoRepository();
    }

    public ArrayList<EnderecoModel> listAllEndereco() {

        try {
            return enderecoRepository.listAllEndereco();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public EnderecoModel findByIdEndereco(int id) {

        try {
            EnderecoModel endereco = validaFindById(id);
            return endereco;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public EnderecoModel inserirEndereco(EnderecoModel endereco) {
        try {
            validaInsert(endereco);
            return enderecoRepository.inserirEndereco(endereco);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public EnderecoModel atualizarEndereco(EnderecoModel endereco) {
        try {
            validaUpdate(endereco);
            return enderecoRepository.atualizarEndereco(endereco);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deletarEndereco(int id) {
        try {
            validaDelete(id);
            enderecoRepository.deletarEndereco(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void validaInsert(EnderecoModel endereco) throws ExceptionCamposVazio, ExceptionEntedidadeNaoInformada, ExceptionQuantidadeDeCaracteres {
        ValidationCampoVazio.validaCamposVazio(endereco);
        ValidationQuantidadeCaracteres.validaTamanhoCampo(endereco);
    }

    private EnderecoModel validaFindById(int id) throws ExceptionEntedidadeNaoInformada, ExceptionNumeroNegativo, ExceptionId {
        ValidationId.validaId(id);
        EnderecoModel endereco = enderecoRepository.findByIdEndereco(id);
        ValidationId.validaExiste(endereco, id);
        return endereco;
    }

    private EnderecoModel validaUpdate(EnderecoModel endereco) throws ExceptionNumeroNegativo, ExceptionEntedidadeNaoInformada, ExceptionCamposVazio, ExceptionQuantidadeDeCaracteres, ExceptionId {
        ValidationId.validaId(endereco.getId());
        ValidationExisteBanco.validaNoBanco(endereco, endereco.getId());
        ValidationCampoVazio.validaCamposVazio(endereco);
        ValidationQuantidadeCaracteres.validaTamanhoCampo(endereco);
        return endereco;
    }

    private void validaDelete(int id) throws ExceptionNumeroNegativo, ExceptionId, ExceptionEntedidadeNaoInformada {
        ValidationId.validaId(id);
        EnderecoModel endereco = enderecoRepository.findByIdEndereco(id);
        ValidationExisteBanco.validaNoBanco(endereco, id);
    }

}


