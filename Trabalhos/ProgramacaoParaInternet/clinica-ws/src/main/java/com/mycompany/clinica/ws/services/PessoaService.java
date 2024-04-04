/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.services;

import com.mycompany.clinica.ws.interfaces.PessoaInterface;
import com.mycompany.clinica.ws.model.PessoaModel;
import com.mycompany.clinica.ws.repository.PessoaRepository;
import com.mycompany.clinica.ws.services.validation.ValidationCampoVazio;
import com.mycompany.clinica.ws.services.validation.ValidationCamposBloqueados;
import com.mycompany.clinica.ws.services.validation.ValidationId;
import com.mycompany.clinica.ws.services.validation.ValidationQuantidadeCaracteres;

import java.util.ArrayList;


public class PessoaService implements PessoaInterface {

    public final PessoaRepository pessoaRepository = null;
    
    public PessoaService(){
        
    }
    
    @Override
    public ArrayList<PessoaModel> listAllPessoa() {
        try {
            return pessoaRepository.listAllPessoa();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public PessoaModel findByIdPessoa(int id) {
        try {
            ValidationId.validaId(id);
            PessoaModel pessoa = pessoaRepository.findByIdPessoa(id);
            ValidationId.validaExiste(pessoa, id);
            return pessoa;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public PessoaModel inserirPessoa(PessoaModel pessoa) {
        try {
            ValidationCampoVazio.validaCamposVazio(pessoa);
            ValidationQuantidadeCaracteres.validaTamanhoCampo(pessoa);
            return pessoaRepository.inserirPessoa(pessoa);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public PessoaModel atualizarPessoa(PessoaModel pessoa) {
        try {
            ValidationCamposBloqueados.validaCamposBloqueados(pessoa);
            ValidationCampoVazio.validaCamposVazio(pessoa);
            ValidationQuantidadeCaracteres.validaTamanhoCampo(pessoa);
            return pessoaRepository.atualizarPessoa(pessoa);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deletarPessoa(int id) {
        try {
            ValidationId.validaId(id);
            PessoaModel pessoa = pessoaRepository.findByIdPessoa(id);
            ValidationId.validaExiste(pessoa, id);
            pessoaRepository.deletarPessoa(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
