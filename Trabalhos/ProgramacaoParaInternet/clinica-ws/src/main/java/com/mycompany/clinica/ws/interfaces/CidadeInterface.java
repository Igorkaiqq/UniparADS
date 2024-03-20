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
    ArrayList<CidadeModel> findByCidadeNome(@WebParam String nome);
    
    @WebMethod
    ArrayList<CidadeModel> findByLikeCidadeNome(@WebParam String nome);
    
    @WebMethod
    ArrayList<CidadeModel> findByEstadoNome(@WebParam String nome);
    
    @WebMethod
    ArrayList<CidadeModel> findByEstadoSigla(@WebParam String sigla);
    
    @WebMethod
    ArrayList<CidadeModel> listAll();
    
    @WebMethod
    CidadeModel findById(@WebParam int id);
    
    @WebMethod
    CidadeModel inserir(CidadeModel cidade);
    
    @WebMethod
    CidadeModel atualizar(CidadeModel cidade);
    
    @WebMethod
    void deletar(int id);
    
}
