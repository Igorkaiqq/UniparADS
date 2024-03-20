/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.clinica.ws.interfaces;

import com.mycompany.clinica.ws.model.EnderecoModel;
import com.mycompany.clinica.ws.model.PessoaModel;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;

/**
 *
 * @author igork
 */
public interface PessoaInterface {
    
    @WebMethod
    ArrayList<PessoaModel> findByNome(@WebParam String nome);
    
    @WebMethod
    ArrayList<PessoaModel> findByLikeNome(@WebParam String nome);
    
    @WebMethod
    EnderecoModel findByCPF(@WebParam String crm);
    
    @WebMethod
    ArrayList<PessoaModel> listAll();
    
    @WebMethod
    EnderecoModel findById(@WebParam int id);
    
    @WebMethod
    EnderecoModel inserir(PessoaModel pessoa);
    
    @WebMethod
    EnderecoModel atualizar(PessoaModel pessoa);
    
    @WebMethod
    void deletar(int id);
    
}
