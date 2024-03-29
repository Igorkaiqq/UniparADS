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
    ArrayList<PacienteModel> findByNomePaciente(@WebParam String nome);
    
    @WebMethod
    ArrayList<PacienteModel> findByLikeNomePaciente(@WebParam String nome);
    
    @WebMethod
    ArrayList<PacienteModel> listAllPaciente();
    
    @WebMethod
    ArrayList<PacienteModel> findByStatusPaciente(@WebParam String nome);
    
    @WebMethod
    EnderecoModel findByIdPaciente(@WebParam int id);
    
    @WebMethod
    EnderecoModel inserirPaciente(PacienteModel paciente);
    
    @WebMethod
    EnderecoModel atualizarPaciente(PacienteModel paciente);
    
    @WebMethod
    void deletarPaciente(int id);
    
}
