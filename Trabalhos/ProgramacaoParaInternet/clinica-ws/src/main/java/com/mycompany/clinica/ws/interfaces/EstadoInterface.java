/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.clinica.ws.interfaces;

import com.mycompany.clinica.ws.model.EstadoModel;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;

/**
 *
 * @author igork
 */
public interface EstadoInterface {
    
    @WebMethod
    ArrayList<EstadoModel> findByNome(@WebParam String nome);
    
    @WebMethod
    ArrayList<EstadoModel> findByLikeNome(@WebParam String nome);
    
    @WebMethod
    ArrayList<EstadoModel> findBySigla(@WebParam String nome);
    
    @WebMethod
    ArrayList<EstadoModel> listAll();
    
    @WebMethod
    EstadoModel findById(@WebParam int id);
    
    @WebMethod
    EstadoModel inserir(EstadoModel estado);
    
    @WebMethod
    EstadoModel atualizar(EstadoModel estado);
    
    @WebMethod
    void deletar(int id);
    
}
