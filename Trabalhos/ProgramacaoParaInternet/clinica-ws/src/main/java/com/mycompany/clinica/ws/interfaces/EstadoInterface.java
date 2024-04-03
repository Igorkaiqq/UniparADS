/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.clinica.ws.interfaces;

import com.mycompany.clinica.ws.exceptions.*;
import com.mycompany.clinica.ws.model.EstadoModel;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author igork
 */
@WebService
public interface EstadoInterface {

    @WebMethod
    ArrayList<EstadoModel> listAllEstado();

    @WebMethod
    EstadoModel findByIdEstado(@WebParam int id) throws ExceptionNumeroNegativo, ExceptionId;

    @WebMethod
    EstadoModel inserirEstado(EstadoModel estado) throws SQLException, ExceptionCamposVazio, ExceptionEntedidadeNaoInformada, ExceptionQuantidadeDeCaracteres;

    @WebMethod
    EstadoModel atualizarEstado(EstadoModel estado);

    @WebMethod
    void deletarEstado(int id);

//    @WebMethod
//    EstadoModel findByNomeEstado(@WebParam String nome);
//
//    @WebMethod
//    ArrayList<EstadoModel> findByLikeNomeEstado(@WebParam String nome);
//
//    @WebMethod
//    EstadoModel findBySiglaEstado(@WebParam String nome);
    
}
