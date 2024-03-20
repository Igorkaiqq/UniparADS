/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.clinica.ws.interfaces;

import com.mycompany.clinica.ws.model.EnderecoModel;
import com.mycompany.clinica.ws.model.MedicoModel;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;

/**
 *
 * @author igork
 */
public interface MedicoInterface {
    
    @WebMethod
    ArrayList<MedicoModel> findByNome(@WebParam String nome);
    
    @WebMethod
    ArrayList<MedicoModel> findByLikeNome(@WebParam String nome);
    
    @WebMethod
    EnderecoModel findByCRM(@WebParam String crm);
    
    @WebMethod
    ArrayList<MedicoModel> findByEspecialidade(@WebParam String nome);
    
    @WebMethod
    ArrayList<MedicoModel> listAll();
    
    @WebMethod
    ArrayList<MedicoModel> findByStatus(@WebParam String nome);
    
    @WebMethod
    EnderecoModel findById(@WebParam int id);
    
    @WebMethod
    EnderecoModel inserir(MedicoModel medico);
    
    @WebMethod
    EnderecoModel atualizar(MedicoModel medico);
    
    @WebMethod
    void deletar(int id);
    
}
