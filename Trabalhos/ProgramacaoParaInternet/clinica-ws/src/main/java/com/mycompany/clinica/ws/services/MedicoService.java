/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.services;

import com.mycompany.clinica.ws.exceptions.*;
import com.mycompany.clinica.ws.interfaces.MedicoInterface;
import com.mycompany.clinica.ws.model.MedicoModel;
import com.mycompany.clinica.ws.repository.MedicoRepository;
import com.mycompany.clinica.ws.services.validation.ValidationCampoVazio;
import com.mycompany.clinica.ws.services.validation.ValidationExisteBanco;
import com.mycompany.clinica.ws.services.validation.ValidationId;
import com.mycompany.clinica.ws.services.validation.ValidationQuantidadeCaracteres;
import com.mycompany.clinica.ws.utils.UtilCRM;

import java.util.ArrayList;


public class MedicoService {

    private final MedicoRepository medicoRepository;
    
    public MedicoService(){
        this.medicoRepository = new MedicoRepository();
    }

    public ArrayList<MedicoModel> listAllMedico() {
        try {
            return medicoRepository.listAllMedico();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public MedicoModel findByIdMedico(int id) {

        try {
            MedicoModel medico = validaFindById(id);
            return medico;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public MedicoModel inserirMedico(MedicoModel medico) {
        try {
            validaInsert(medico);
            medico.setCrm(UtilCRM.formatarCRM(medico.getCrm()));
            return medicoRepository.inserirMedico(medico);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public MedicoModel atualizarMedico(MedicoModel medico) {
        try {
            validaUpdate(medico);
            medico.setCrm(UtilCRM.formatarCRM(medico.getCrm()));
            return medicoRepository.atualizarMedico(medico);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deletarMedico(int id) {
        try {
            validaDelete(id);
            medicoRepository.deletarMedico(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void ativarMedico(int id) {
        try {
            validaDelete(id);
            medicoRepository.ativarMedico(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void validaInsert(MedicoModel medico) throws ExceptionCamposVazio, ExceptionEntedidadeNaoInformada, ExceptionQuantidadeDeCaracteres {
        ValidationCampoVazio.validaCamposVazio(medico);
        ValidationQuantidadeCaracteres.validaTamanhoCampo(medico);
    }

    private MedicoModel validaFindById(int id) throws ExceptionNumeroNegativo, ExceptionId, ExceptionEntedidadeNaoInformada {
        ValidationId.validaId(id);
        MedicoModel medico = medicoRepository.findByIdMedico(id);
        ValidationId.validaExiste(medico, id);
        return medico;
    }

    private MedicoModel validaUpdate(MedicoModel medico) throws ExceptionNumeroNegativo, ExceptionId, ExceptionEntedidadeNaoInformada, ExceptionCamposVazio, ExceptionQuantidadeDeCaracteres {
        ValidationId.validaId(medico.getId());
        ValidationExisteBanco.validaNoBanco(medico, medico.getId());
        ValidationCampoVazio.validaCamposVazio(medico);
        ValidationQuantidadeCaracteres.validaTamanhoCampo(medico);
        return medico;
    }

    private void validaDelete(int id) throws ExceptionNumeroNegativo, ExceptionId, ExceptionEntedidadeNaoInformada {
        ValidationId.validaId(id);
        MedicoModel medico = medicoRepository.findByIdMedico(id);
        ValidationExisteBanco.validaNoBanco(medico, id);
    }


}
