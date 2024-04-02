/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.clinica.ws.interfaces;

import com.mycompany.clinica.ws.model.EspecialidadeModel;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.ArrayList;

/**
 *
 * @author igork
 */
@WebService
public interface EspecialidadeInterface {

    @WebMethod
    ArrayList<EspecialidadeModel> listAllEspecialidade();

    @WebMethod
    EspecialidadeModel findByIdEspecialidade(@WebParam int id);

    @WebMethod
    EspecialidadeModel inserirEspecialidade(EspecialidadeModel especialidade);

    @WebMethod
    EspecialidadeModel atualizarEspecialidade(EspecialidadeModel especialidade);

    @WebMethod
    void deletarEspecialidade(int id);

//    @WebMethod
//    ArrayList<EspecialidadeModel> findByEspecialidade(@WebParam String especialidade);
//
//    @WebMethod
//    ArrayList<EspecialidadeModel> findByLikeEspecialidade(@WebParam String especialidade);

}
