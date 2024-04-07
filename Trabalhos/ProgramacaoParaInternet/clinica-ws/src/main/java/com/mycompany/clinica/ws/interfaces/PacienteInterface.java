/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.clinica.ws.interfaces;

import com.mycompany.clinica.ws.model.PacienteModel;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.ArrayList;

/**
 *
 * @author igork
 */
@WebService
public interface PacienteInterface {

   @WebMethod
   ArrayList<PacienteModel> listAllPaciente();

    PacienteModel findByIdPaciente(int id);

    @WebMethod
   PacienteModel inserirPaciente(PacienteModel paciente);

   @WebMethod
   PacienteModel atualizarPaciente(PacienteModel paciente);

  @WebMethod
   void deletarPaciente(int id);

  @WebMethod
    void ativarPaciente(int id);

}
