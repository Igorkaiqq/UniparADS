/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.services;

import com.mycompany.clinica.ws.interfaces.EspecialidadeInterface;
import com.mycompany.clinica.ws.model.EspecialidadeModel;
import com.mycompany.clinica.ws.repository.EspecialidadeRepository;

import java.util.ArrayList;

/**
 *
 * @author igork
 */

public class EspecialidadeService implements EspecialidadeInterface {

    public final EspecialidadeRepository especialidadeRepositoy = null;
    
    public EspecialidadeService(){
        
    }
    
    @Override
    public ArrayList<EspecialidadeModel> listAllEspecialidade() {
        return null;
    }

    @Override
    public EspecialidadeModel findByIdEspecialidade(int id) {
        return null;
    }

    @Override
    public EspecialidadeModel inserirEspecialidade(EspecialidadeModel especialidade) {
        return null;
    }

    @Override
    public EspecialidadeModel atualizarEspecialidade(EspecialidadeModel especialidade) {
        return null;
    }

    @Override
    public void deletarEspecialidade(int id) {

    }
}
