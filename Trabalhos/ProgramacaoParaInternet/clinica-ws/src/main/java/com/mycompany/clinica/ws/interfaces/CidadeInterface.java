/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.clinica.ws.interfaces;

import com.mycompany.clinica.ws.model.CidadeModel;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;

/**
 *
 * @author igork
 */
public interface CidadeInterface {
    
    @WebMethod
    CidadeModel findByCidadeNomeCidade(@WebParam String nome);
    
    @WebMethod
    ArrayList<CidadeModel> findByLikeCidadeNomeCidade(@WebParam String nome);
    
    @WebMethod
    ArrayList<CidadeModel> findByEstadoNomeCidade(@WebParam String nome);
    
    @WebMethod
    ArrayList<CidadeModel> findByEstadoSiglaCidade(@WebParam String sigla);
    
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
