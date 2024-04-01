/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.services;

import com.mycompany.clinica.ws.interfaces.EnderecoInterface;
import com.mycompany.clinica.ws.model.CidadeModel;
import com.mycompany.clinica.ws.model.EnderecoModel;
import com.mycompany.clinica.ws.repository.EnderecoRepository;
import com.mycompany.clinica.ws.services.validation.ValidationCampoVazio;
import com.mycompany.clinica.ws.services.validation.ValidationId;
import com.mycompany.clinica.ws.services.validation.ValidationQuantidadeCaracteres;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 *
 * @author igork
 */
public class EnderecoService implements EnderecoInterface {

    public final EnderecoRepository enderecoRepository = null;

    public EnderecoService(){
        
    }
    
    @Override
    public ArrayList<EnderecoModel> listAllEndereco() {

        try {
            return enderecoRepository.listAllEndereco();
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public EnderecoModel findByIdEndereco(int id) {

        try {
            ValidationId.validaId(id);
            EnderecoModel endereco = enderecoRepository.findByIdEndereco(id);
            ValidationId.validaExiste(endereco, id);
            return endereco;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public EnderecoModel inserirEndereco(EnderecoModel endereco) {
        try {
            ValidationCampoVazio.validaCamposVazio(endereco);
            ValidationQuantidadeCaracteres.validaTamanhoCampo(endereco);
            return enderecoRepository.inserirEndereco(endereco);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public EnderecoModel atualizarEndereco(EnderecoModel endereco) {
        try {
            ValidationCampoVazio.validaCamposVazio(endereco);
            ValidationQuantidadeCaracteres.validaTamanhoCampo(endereco);
            return enderecoRepository.atualizarEndereco(endereco);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deletarEndereco(int id) {
        try {
            ValidationId.validaId(id);
            EnderecoModel endereco = enderecoRepository.findByIdEndereco(id);
            ValidationId.validaExiste(endereco, id);
            enderecoRepository.deletarEndereco(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


