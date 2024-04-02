/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.services;

import com.mycompany.clinica.ws.interfaces.PessoaInterface;
import com.mycompany.clinica.ws.model.PessoaModel;
import com.mycompany.clinica.ws.repository.PessoaRepository;

import java.util.ArrayList;


public class PessoaService implements PessoaInterface {

    public final PessoaRepository pessoaRepository = null;
    
    public PessoaService(){
        
    }
    
    @Override
    public ArrayList<PessoaModel> listAllPessoa() {
        return null;
    }

    @Override
    public PessoaModel findByIdPessoa(int id) {
        return null;
    }

    @Override
    public PessoaModel inserirPessoa(PessoaModel pessoa) {
        return null;
    }

    @Override
    public PessoaModel atualizarPessoa(PessoaModel pessoa) {
        return null;
    }

    @Override
    public void deletarPessoa(int id) {;
    }
}
