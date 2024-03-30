/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.services;

import com.mycompany.clinica.ws.interfaces.EnderecoInterface;
import com.mycompany.clinica.ws.model.EnderecoModel;
import com.mycompany.clinica.ws.repository.EnderecoRepository;

import java.util.ArrayList;

/**
 *
 * @author igork
 */
public class EnderecoService implements EnderecoInterface {

    public final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
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
            return enderecoRepository.findByIdEndereco(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public EnderecoModel inserirEndereco(EnderecoModel endereco) {
        try {
            return enderecoRepository.inserirEndereco(endereco);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public EnderecoModel atualizarEndereco(EnderecoModel endereco) {
        try {
            return enderecoRepository.atualizarEndereco(endereco);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deletarEndereco(int id) {
        try {
            enderecoRepository.deletarEndereco(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


