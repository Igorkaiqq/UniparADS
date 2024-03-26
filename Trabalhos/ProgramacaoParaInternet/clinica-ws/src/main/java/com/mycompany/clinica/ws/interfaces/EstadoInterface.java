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
    ArrayList<EstadoModel> findByNomeEstado(@WebParam String nome);
    
    @WebMethod
    ArrayList<EstadoModel> findByLikeNomeEstado(@WebParam String nome);
    
    @WebMethod
    EstadoModel findBySiglaEstado(@WebParam String nome);
    
    @WebMethod
    ArrayList<EstadoModel> listAllEstado();
    
    @WebMethod
    EstadoModel findByIdEstado(@WebParam int id);
    
    @WebMethod
    EstadoModel inserirEstado(EstadoModel estado);
    
    @WebMethod
    EstadoModel atualizarEstado(EstadoModel estado);
    
    @WebMethod
    boolean deletarEstado(int id);
    
}
