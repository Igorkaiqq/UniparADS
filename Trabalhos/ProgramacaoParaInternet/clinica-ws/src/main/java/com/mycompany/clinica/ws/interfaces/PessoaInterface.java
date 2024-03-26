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
    ArrayList<PessoaModel> findByNomePessoa(@WebParam String nome);
    
    @WebMethod
    ArrayList<PessoaModel> findByLikeNomePessoa(@WebParam String nome);
    
    @WebMethod
    PessoaModel findByCPFPessoa(@WebParam String cpf);
    
    @WebMethod
    ArrayList<PessoaModel> listAllPessoa();
    
    @WebMethod
    PessoaModel findByIdPessoa(@WebParam int id);
    
    @WebMethod
    PessoaModel inserirPessoa(PessoaModel pessoa);
    
    @WebMethod
    PessoaModel atualizarPessoa(PessoaModel pessoa);
    
    @WebMethod
    boolean deletarPessoa(int id);
    
}
