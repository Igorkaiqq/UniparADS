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
    ArrayList<MedicoModel> findByNomeMedico(@WebParam String nome);
    
    @WebMethod
    ArrayList<MedicoModel> findByLikeNomeMedico(@WebParam String nome);
    
    @WebMethod
    EnderecoModel findByCRMMedico(@WebParam String crm);
    
    @WebMethod
    ArrayList<MedicoModel> findByEspecialidadeMedico(@WebParam String nome);
    
    @WebMethod
    ArrayList<MedicoModel> listAllMedico();
    
    @WebMethod
    ArrayList<MedicoModel> findByStatusMedico(@WebParam String nome);
    
    @WebMethod
    EnderecoModel findByIdMedico(@WebParam int id);
    
    @WebMethod
    EnderecoModel inserirMedico(MedicoModel medico);
    
    @WebMethod
    EnderecoModel atualizarMedico(MedicoModel medico);
    
    @WebMethod
    void deletarMedico(int id);
    
}
