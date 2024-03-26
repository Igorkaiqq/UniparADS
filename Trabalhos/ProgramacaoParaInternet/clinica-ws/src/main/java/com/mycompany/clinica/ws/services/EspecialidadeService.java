/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.services;

import com.mycompany.clinica.ws.interfaces.EspecialidadeInterface;
import com.mycompany.clinica.ws.model.EspecialidadeModel;
import java.util.ArrayList;

/**
 *
 * @author igork
 */
public class EspecialidadeService implements EspecialidadeInterface {

    @Override
    public ArrayList<EspecialidadeModel> findByEspecialidade (String especialidade) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<EspecialidadeModel> findByLikeEspecialidade (String especialidade) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<EspecialidadeModel> listAllEspecialidade () {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EspecialidadeModel findByIdEspecialidade (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EspecialidadeModel inserirEspecialidade (EspecialidadeModel especialidade) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EspecialidadeModel atualizarEspecialidade (EspecialidadeModel especialidade) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void deletarEspecialidade (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    
}
