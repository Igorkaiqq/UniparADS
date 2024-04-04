/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.services;

import com.mycompany.clinica.ws.interfaces.CidadeInterface;
import com.mycompany.clinica.ws.model.CidadeModel;
import com.mycompany.clinica.ws.repository.CidadeRepository;
import com.mycompany.clinica.ws.services.validation.ValidationCampoVazio;
import com.mycompany.clinica.ws.services.validation.ValidationId;
import com.mycompany.clinica.ws.services.validation.ValidationQuantidadeCaracteres;

import java.util.ArrayList;

/**
 *
 * @author igork
 */

public class CidadeService implements CidadeInterface {

    private static final CidadeRepository cidadeRepository = null;

    public CidadeService () {
    }

    
    
    @Override
    public ArrayList<CidadeModel> listAllCidade() {

        try {
            return cidadeRepository.listAllCidade();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public CidadeModel findByIdCidade(int id) {
        try {
            ValidationId.validaId(id);
            CidadeModel cidade = cidadeRepository.findByIdCidade(id);
            ValidationId.validaExiste(cidade, id);
            return cidade;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public CidadeModel inserirCidade(CidadeModel cidade) {
        try {
            ValidationCampoVazio.validaCamposVazio(cidade);
            ValidationQuantidadeCaracteres.validaTamanhoCampo(cidade);
            return cidadeRepository.inserirCidade(cidade);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

        @Override
        public CidadeModel atualizarCidade (CidadeModel cidade){
            try {
                ValidationCampoVazio.validaCamposVazio(cidade);
                ValidationQuantidadeCaracteres.validaTamanhoCampo(cidade);
                return cidadeRepository.atualizarCidade(cidade);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        @Override
        public void deletarCidade ( int id){
            try {
                ValidationId.validaId(id);
                CidadeModel cidade = cidadeRepository.findByIdCidade(id);
                ValidationId.validaExiste(cidade, id);
                cidadeRepository.deletarCidade(id);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }
