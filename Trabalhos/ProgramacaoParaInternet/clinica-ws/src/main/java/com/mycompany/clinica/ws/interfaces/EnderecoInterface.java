/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.clinica.ws.interfaces;

import com.mycompany.clinica.ws.model.EnderecoModel;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.ArrayList;

/**
 *
 * @author igork
 */
@WebService
public interface EnderecoInterface {
    
    @WebMethod
    ArrayList<EnderecoModel> findByBairro(@WebParam String bairro);
    
    @WebMethod
    ArrayList<EnderecoModel> findByLikeLogradouro(@WebParam String logradouro);
    
    @WebMethod
    ArrayList<EnderecoModel> findByCidadeNome(@WebParam String nome);
    
    @WebMethod
    ArrayList<EnderecoModel> findByLikeCidadeNome(@WebParam String nome);
    
    
    
    @WebMethod
    ArrayList<EnderecoModel> findByCEP(@WebParam String cep);
    
    @WebMethod
    ArrayList<EnderecoModel> listAll();
    
    @WebMethod
    EnderecoModel findById(@WebParam int id);
    
    @WebMethod
    EnderecoModel inserir(EnderecoModel endereco);
    
    @WebMethod
    EnderecoModel atualizar(EnderecoModel endereco);
    
    @WebMethod
    void deletar(int id);
    
}
