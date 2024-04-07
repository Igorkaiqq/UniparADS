/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.clinica.ws.interfaces;

import com.mycompany.clinica.ws.model.MedicoModel;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.ArrayList;

/**
 *
 * @author igork
 */
@WebService
public interface MedicoInterface {

    @WebMethod
    ArrayList<MedicoModel> listAllMedico();

    @WebMethod
    MedicoModel findByIdMedico(@WebParam int id);

    @WebMethod
    MedicoModel inserirMedico(MedicoModel medico);

    @WebMethod
    MedicoModel atualizarMedico(MedicoModel medico);

    @WebMethod
    void deletarMedico(int id);

    @WebMethod
    void ativarMedico(int id);

    
}
