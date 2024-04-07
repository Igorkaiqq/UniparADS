/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.services;

import com.mycompany.clinica.ws.exceptions.*;
import com.mycompany.clinica.ws.interfaces.PessoaInterface;
import com.mycompany.clinica.ws.model.PessoaModel;
import com.mycompany.clinica.ws.repository.PessoaRepository;
import com.mycompany.clinica.ws.services.validation.*;
import com.mycompany.clinica.ws.utils.UtilCPF;
import com.mycompany.clinica.ws.utils.UtilTelefone;

import java.util.ArrayList;


public class PessoaService {

    private final PessoaRepository pessoaRepository;
    
    public PessoaService(){
        this.pessoaRepository = new PessoaRepository();
    }

    public ArrayList<PessoaModel> listAllPessoa() {
        try {
            return pessoaRepository.listAllPessoa();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public PessoaModel findByIdPessoa(int id) {
        try {
            PessoaModel pessoa = validaFindById(id);
            return pessoa;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public PessoaModel inserirPessoa(PessoaModel pessoa) {
        try {
            validaInsert(pessoa);
            pessoa.setCpf(UtilCPF.formatarCPF(pessoa.getCpf()));
            pessoa.setTelefone(UtilTelefone.formatarTelefone(pessoa.getTelefone()));
            return pessoaRepository.inserirPessoa(pessoa);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public PessoaModel atualizarPessoa(PessoaModel pessoa) {
        try {
            validaUpdate(pessoa);
            pessoa.setCpf(UtilCPF.formatarCPF(pessoa.getCpf()));
            pessoa.setTelefone(UtilTelefone.formatarTelefone(pessoa.getTelefone()));
            return pessoaRepository.atualizarPessoa(pessoa);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deletarPessoa(int id) {
        try {
            validaDelete(id);
            pessoaRepository.deletarPessoa(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void validaInsert(PessoaModel pessoa) throws ExceptionCamposVazio, ExceptionEntedidadeNaoInformada, ExceptionQuantidadeDeCaracteres {
        ValidationCampoVazio.validaCamposVazio(pessoa);
        ValidationQuantidadeCaracteres.validaTamanhoCampo(pessoa);
    }

    private PessoaModel validaFindById(int id) throws ExceptionNumeroNegativo, ExceptionId, ExceptionEntedidadeNaoInformada {
        ValidationId.validaId(id);
        PessoaModel endereco = pessoaRepository.findByIdPessoa(id);
        ValidationId.validaExiste(endereco, id);
        return endereco;
    }

    private PessoaModel validaUpdate(PessoaModel pessoa) throws ExceptionNumeroNegativo, ExceptionId, ExceptionEntedidadeNaoInformada, ExceptionCamposVazio, ExceptionQuantidadeDeCaracteres {
        ValidationId.validaId(pessoa.getId());
        ValidationExisteBanco.validaNoBanco(pessoa, pessoa.getId());
        ValidationCampoVazio.validaCamposVazio(pessoa);
        ValidationQuantidadeCaracteres.validaTamanhoCampo(pessoa);
        return pessoa;
    }

    private void validaDelete(int id) throws ExceptionNumeroNegativo, ExceptionId, ExceptionEntedidadeNaoInformada {
        ValidationId.validaId(id);
        PessoaModel pessoa = pessoaRepository.findByIdPessoa(id);
        ValidationExisteBanco.validaNoBanco(pessoa, id);
    }

}
