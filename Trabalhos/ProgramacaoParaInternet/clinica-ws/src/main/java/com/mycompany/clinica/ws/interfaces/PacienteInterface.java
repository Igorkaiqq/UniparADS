/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.clinica.ws.interfaces;

import com.mycompany.clinica.ws.model.EnderecoModel;
import com.mycompany.clinica.ws.model.PacienteModel;
import com.mycompany.clinica.ws.model.PessoaModel;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;

/**
 *
 * @author igork
 */
public interface PacienteInterface {
    
   @WebMethod
    ArrayList<PacienteModel> findByNome(@WebParam String nome);
    
    @WebMethod
    ArrayList<PacienteModel> findByLikeNome(@WebParam String nome);
    
    @WebMethod
    ArrayList<PacienteModel> listAll();
    
    @WebMethod
    ArrayList<PacienteModel> findByStatus(@WebParam String nome);
    
    @WebMethod
    EnderecoModel findById(@WebParam int id);
    
    @WebMethod
    EnderecoModel inserir(PacienteModel paciente);
    
    @WebMethod
    EnderecoModel atualizar(PacienteModel paciente);
    
    @WebMethod
    void deletar(int id); 
    
}
