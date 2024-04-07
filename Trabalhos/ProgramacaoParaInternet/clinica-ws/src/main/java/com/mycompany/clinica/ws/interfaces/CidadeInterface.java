/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.clinica.ws.interfaces;

import com.mycompany.clinica.ws.model.CidadeModel;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.ArrayList;

/**
 *
 * @author igork
 */
@WebService
public interface CidadeInterface {

    @WebMethod
    ArrayList<CidadeModel> listAllCidade();

    @WebMethod
    CidadeModel findByIdCidade(@WebParam int id);

    @WebMethod
    CidadeModel inserirCidade(CidadeModel cidade);

    @WebMethod
    CidadeModel atualizarCidade(CidadeModel cidade);

    @WebMethod
    void deletarCidade(int id);

    
}
