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
    ArrayList<EnderecoModel> findByBairroEndereco(@WebParam String bairro);
    
    @WebMethod
    ArrayList<EnderecoModel> findByLikeLogradouroEndereco(@WebParam String logradouro);
    
    @WebMethod
    ArrayList<EnderecoModel> findByCidadeNomeEndereco(@WebParam String nome);
    
    @WebMethod
    ArrayList<EnderecoModel> findByLikeCidadeNomeEndereco(@WebParam String nome);

    @WebMethod
    ArrayList<EnderecoModel> findByCEPEndereco(@WebParam String cep);
    
    @WebMethod
    ArrayList<EnderecoModel> listAllEndereco();
    
    @WebMethod
    EnderecoModel findByIdEndereco(@WebParam int id);
    
    @WebMethod
    EnderecoModel inserirEndereco(EnderecoModel endereco);
    
    @WebMethod
    EnderecoModel atualizarEndereco(EnderecoModel endereco);
    
    @WebMethod
    void deletarEndereco(int id);
    
}
