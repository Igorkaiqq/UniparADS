/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.services;

import com.mycompany.clinica.ws.exceptions.*;
import com.mycompany.clinica.ws.interfaces.EspecialidadeInterface;
import com.mycompany.clinica.ws.model.EnderecoModel;
import com.mycompany.clinica.ws.model.EspecialidadeModel;
import com.mycompany.clinica.ws.repository.EspecialidadeRepository;
import com.mycompany.clinica.ws.services.validation.ValidationCampoVazio;
import com.mycompany.clinica.ws.services.validation.ValidationExisteBanco;
import com.mycompany.clinica.ws.services.validation.ValidationId;
import com.mycompany.clinica.ws.services.validation.ValidationQuantidadeCaracteres;

import java.util.ArrayList;

/**
 *
 * @author igork
 */

public class EspecialidadeService {

    private final EspecialidadeRepository especialidadeRepositoy;
    
    public EspecialidadeService(){
        this.especialidadeRepositoy = new EspecialidadeRepository();
    }

    public ArrayList<EspecialidadeModel> listAllEspecialidade() {
        try {
            return especialidadeRepositoy.listAllEspecialidade();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public EspecialidadeModel findByIdEspecialidade(int id) {
        try {
            EspecialidadeModel especialidade = validaFindById(id);
            return especialidade;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public EspecialidadeModel inserirEspecialidade(EspecialidadeModel especialidade) {
        try {
            validaInsert(especialidade);
            return especialidadeRepositoy.inserirEspecialidade(especialidade);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public EspecialidadeModel atualizarEspecialidade(EspecialidadeModel especialidade) {

        try {
            validaUpdate(especialidade);
            return especialidadeRepositoy.atualizarEspecialidade(especialidade);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deletarEspecialidade(int id) {
        try {
            validaDelete(id);
            especialidadeRepositoy.deletarEspecialidade(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void validaInsert(EspecialidadeModel especialidade) throws ExceptionCamposVazio, ExceptionEntedidadeNaoInformada, ExceptionQuantidadeDeCaracteres {
        ValidationCampoVazio.validaCamposVazio(especialidade);
        ValidationQuantidadeCaracteres.validaTamanhoCampo(especialidade);
    }

    private EspecialidadeModel validaFindById(int id) throws ExceptionEntedidadeNaoInformada, ExceptionNumeroNegativo, ExceptionId {
        ValidationId.validaId(id);
        EspecialidadeModel especialidade = especialidadeRepositoy.findByIdEspecialidade(id);
        ValidationId.validaExiste(especialidade, id);
        return especialidade;
    }

    private EspecialidadeModel validaUpdate(EspecialidadeModel especialidade) throws ExceptionNumeroNegativo, ExceptionEntedidadeNaoInformada, ExceptionCamposVazio, ExceptionQuantidadeDeCaracteres, ExceptionId {
        ValidationId.validaId(especialidade.getId());
        ValidationExisteBanco.validaNoBanco(especialidade, especialidade.getId());
        ValidationCampoVazio.validaCamposVazio(especialidade);
        ValidationQuantidadeCaracteres.validaTamanhoCampo(especialidade);
        return especialidade;
    }

    private void validaDelete(int id) throws ExceptionNumeroNegativo, ExceptionId, ExceptionEntedidadeNaoInformada {
        ValidationId.validaId(id);
        EspecialidadeModel especialidade = especialidadeRepositoy.findByIdEspecialidade(id);
        ValidationExisteBanco.validaNoBanco(especialidade, id);
    }

}
