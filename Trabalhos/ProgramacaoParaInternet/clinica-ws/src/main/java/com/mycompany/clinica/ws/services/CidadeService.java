/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.services;

import com.mycompany.clinica.ws.exceptions.*;
import com.mycompany.clinica.ws.model.CidadeModel;
import com.mycompany.clinica.ws.model.EstadoModel;
import com.mycompany.clinica.ws.repository.CidadeRepository;
import com.mycompany.clinica.ws.services.validation.ValidationCampoVazio;
import com.mycompany.clinica.ws.services.validation.ValidationExisteBanco;
import com.mycompany.clinica.ws.services.validation.ValidationId;
import com.mycompany.clinica.ws.services.validation.ValidationQuantidadeCaracteres;

import java.util.ArrayList;

/**
 *
 * @author igork
 */
public class CidadeService {

    private final CidadeRepository cidadeRepository;

    public CidadeService (CidadeRepository cidadeRepository) {
        this.cidadeRepository = new CidadeRepository();
    }

    public ArrayList<CidadeModel> listAllCidade() {
        try {
            return cidadeRepository.listAllCidade();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public CidadeModel findByIdCidade(int id) {
        try {
            CidadeModel cidade = validaFindById(id);
            return cidade;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    public CidadeModel inserirCidade(CidadeModel cidade) {
        try {
            validaInsert(cidade);
            return cidadeRepository.inserirCidade(cidade);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


        public CidadeModel atualizarCidade (CidadeModel cidade){
            try {
                validaUpdate(cidade);
                return cidadeRepository.atualizarCidade(cidade);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }


        public void deletarCidade ( int id){
            try {
                validaDelete(id);
                cidadeRepository.deletarCidade(id);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        private void validaInsert(CidadeModel cidade) throws ExceptionCamposVazio, ExceptionEntedidadeNaoInformada, ExceptionQuantidadeDeCaracteres {
            ValidationCampoVazio.validaCamposVazio(cidade);
            ValidationQuantidadeCaracteres.validaTamanhoCampo(cidade);
        }

        private CidadeModel validaFindById(int id) throws ExceptionEntedidadeNaoInformada, ExceptionNumeroNegativo, ExceptionId {
            ValidationId.validaId(id);
            CidadeModel cidade = cidadeRepository.findByIdCidade(id);
            ValidationId.validaExiste(cidade, id);
            return cidade;
        }

        private CidadeModel validaUpdate(CidadeModel cidade) throws ExceptionNumeroNegativo, ExceptionEntedidadeNaoInformada, ExceptionCamposVazio, ExceptionQuantidadeDeCaracteres, ExceptionId {
            ValidationId.validaId(cidade.getId());
            ValidationExisteBanco.validaNoBanco(cidade, cidade.getId());
            ValidationCampoVazio.validaCamposVazio(cidade);
            ValidationQuantidadeCaracteres.validaTamanhoCampo(cidade);
            return cidade;
        }

        private void validaDelete(int id) throws ExceptionNumeroNegativo, ExceptionId, ExceptionEntedidadeNaoInformada {
            ValidationId.validaId(id);
            CidadeModel estado = cidadeRepository.findByIdCidade(id);
            ValidationExisteBanco.validaNoBanco(estado, id);
        }

    }
