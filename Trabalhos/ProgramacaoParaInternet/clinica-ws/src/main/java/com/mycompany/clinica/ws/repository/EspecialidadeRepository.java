package com.mycompany.clinica.ws.repository;

import com.mycompany.clinica.ws.interfaces.EspecialidadeInterface;
import com.mycompany.clinica.ws.model.EspecialidadeModel;

import java.util.ArrayList;

public class EspecialidadeRepository implements EspecialidadeInterface {

    @Override
    public ArrayList<EspecialidadeModel> findByEspecialidade(String especialidade) {
        return null;
    }

    @Override
    public ArrayList<EspecialidadeModel> findByLikeEspecialidade(String especialidade) {
        return null;
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
