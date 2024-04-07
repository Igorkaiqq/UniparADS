/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.clinica.ws.interfaces;

import com.mycompany.clinica.ws.model.PessoaModel;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.ArrayList;

/**
 *
 * @author igork
 */
@WebService
public interface PessoaInterface {

    @WebMethod
    ArrayList<PessoaModel> listAllPessoa();

    @WebMethod
    PessoaModel findByIdPessoa(@WebParam int id);

    @WebMethod
    PessoaModel inserirPessoa(PessoaModel pessoa);

    @WebMethod
    PessoaModel atualizarPessoa(PessoaModel pessoa);

    @WebMethod
    void deletarPessoa(int id);
    
}
