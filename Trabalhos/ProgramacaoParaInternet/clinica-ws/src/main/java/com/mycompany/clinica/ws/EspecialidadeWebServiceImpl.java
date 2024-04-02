package com.mycompany.clinica.ws;

import com.mycompany.clinica.ws.interfaces.EspecialidadeInterface;
import com.mycompany.clinica.ws.model.EspecialidadeModel;
import com.mycompany.clinica.ws.services.EspecialidadeService;
import jakarta.jws.WebService;

import java.util.ArrayList;

@WebService(serviceName = "EspecialidadeWebServiceImpl")
public class EspecialidadeWebServiceImpl implements EspecialidadeInterface {

    EspecialidadeService especialidadeService = new EspecialidadeService();

    @Override
    public ArrayList<EspecialidadeModel> listAllEspecialidade() {
        return especialidadeService.listAllEspecialidade();
    }

    @Override
    public EspecialidadeModel findByIdEspecialidade(int id) {
        return especialidadeService.findByIdEspecialidade(id);
    }

    @Override
    public EspecialidadeModel inserirEspecialidade(EspecialidadeModel especialidade) {
        return especialidadeService.inserirEspecialidade(especialidade);
    }

    @Override
    public EspecialidadeModel atualizarEspecialidade(EspecialidadeModel especialidade) {
        return especialidadeService.atualizarEspecialidade(especialidade);
    }

    @Override
    public void deletarEspecialidade(int id) {
        especialidadeService.deletarEspecialidade(id);
    }
}
