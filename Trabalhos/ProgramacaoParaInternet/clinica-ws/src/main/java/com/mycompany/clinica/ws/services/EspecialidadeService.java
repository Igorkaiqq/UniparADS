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
    public ArrayList<EspecialidadeModel> listAll () {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EspecialidadeModel findById (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EspecialidadeModel inserir (EspecialidadeModel especialidade) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public EspecialidadeModel atualizar (EspecialidadeModel especialidade) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void deletar (int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public boolean validaEspecialidade(EspecialidadeModel especialidade){
        return false;
    }
    
    public boolean existeEspecialidade(EspecialidadeModel especialidade){
        return false;
    }
    
}
