package com.mycompany.clinica.ws.repository;

import com.mycompany.clinica.ws.interfaces.EnderecoInterface;
import com.mycompany.clinica.ws.model.EnderecoModel;

import java.util.ArrayList;

public class EnderecoRepository implements EnderecoInterface {
    @Override
    public ArrayList<EnderecoModel> findByBairroEndereco(String bairro) {
        return null;
    }

    @Override
    public ArrayList<EnderecoModel> findByLikeLogradouroEndereco(String logradouro) {
        return null;
    }

    @Override
    public ArrayList<EnderecoModel> findByCidadeNomeEndereco(String nome) {
        return null;
    }

    @Override
    public ArrayList<EnderecoModel> findByLikeCidadeNomeEndereco(String nome) {
        return null;
    }

    @Override
    public ArrayList<EnderecoModel> findByCEPEndereco(String cep) {
        return null;
    }

    @Override
    public ArrayList<EnderecoModel> listAllEndereco() {
        return null;
    }

    @Override
    public EnderecoModel findByIdEndereco(int id) {
        return null;
    }

    @Override
    public EnderecoModel inserirEndereco(EnderecoModel endereco) {
        return null;
    }

    @Override
    public EnderecoModel atualizarEndereco(EnderecoModel endereco) {
        return null;
    }

    @Override
    public void deletarEndereco(int id) {

    }
}
