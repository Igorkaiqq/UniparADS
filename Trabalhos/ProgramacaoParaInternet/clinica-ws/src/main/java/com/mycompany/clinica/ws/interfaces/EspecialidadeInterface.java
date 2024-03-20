/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.clinica.ws.interfaces;

import com.mycompany.clinica.ws.model.EspecialidadeModel;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;

/**
 *
 * @author igork
 */
public interface EspecialidadeInterface {
    
        @WebMethod
    ArrayList<EspecialidadeModel> findByEspecialidade(@WebParam String especialidade);
    
    @WebMethod
    ArrayList<EspecialidadeModel> findByLikeEspecialidade(@WebParam String especialidade);
    
    @WebMethod
    ArrayList<EspecialidadeModel> listAll();
    
    @WebMethod
    EspecialidadeModel findById(@WebParam int id);
    
    @WebMethod
    EspecialidadeModel inserir(EspecialidadeModel especialidade);
    
    @WebMethod
    EspecialidadeModel atualizar(EspecialidadeModel especialidade);
    
    @WebMethod
    void deletar(int id);
    
}
