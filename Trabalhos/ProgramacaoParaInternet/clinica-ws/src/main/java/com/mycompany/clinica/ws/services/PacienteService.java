/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.services;

import com.mycompany.clinica.ws.exceptions.*;
import com.mycompany.clinica.ws.interfaces.PacienteInterface;
import com.mycompany.clinica.ws.model.PacienteModel;
import com.mycompany.clinica.ws.model.PessoaModel;
import com.mycompany.clinica.ws.repository.PacienteRepository;
import com.mycompany.clinica.ws.services.validation.ValidationCampoVazio;
import com.mycompany.clinica.ws.services.validation.ValidationExisteBanco;
import com.mycompany.clinica.ws.services.validation.ValidationId;
import com.mycompany.clinica.ws.services.validation.ValidationQuantidadeCaracteres;

import java.util.ArrayList;

/**
 *
 * @author igork
 */

public class PacienteService {

    private final PacienteRepository pacienteRepository;
    
    public PacienteService(){
        this.pacienteRepository = new PacienteRepository();
    }

    public ArrayList<PacienteModel> listAllPaciente() {
        try {
            return pacienteRepository.listAllPaciente();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public PacienteModel findByIdPaciente(int id) {
        try {
            PacienteModel paciente = validaFindById(id);
            return paciente;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public PacienteModel inserirPaciente(PacienteModel paciente) {

        try {
            validaInsert(paciente);
            return pacienteRepository.inserirPaciente(paciente);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public PacienteModel atualizarPaciente(PacienteModel paciente) {
        try {
            validaUpdate(paciente);
            return pacienteRepository.atualizarPaciente(paciente);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deletarPaciente(int id) {
        try {
            validaDelete(id);
            pacienteRepository.deletarPaciente(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void ativarPaciente(int id) {
        try {
            ValidationId.validaId(id);
            pacienteRepository.ativarPaciente(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void validaInsert(PacienteModel paciente) throws ExceptionCamposVazio, ExceptionEntedidadeNaoInformada, ExceptionQuantidadeDeCaracteres {
        ValidationCampoVazio.validaCamposVazio(paciente);
        ValidationQuantidadeCaracteres.validaTamanhoCampo(paciente);
    }

    private PacienteModel validaFindById(int id) throws ExceptionNumeroNegativo, ExceptionId, ExceptionEntedidadeNaoInformada {
        ValidationId.validaId(id);
        PacienteModel paciente = pacienteRepository.findByIdPaciente(id);
        ValidationId.validaExiste(paciente, id);
        return paciente;
    }

    private PacienteModel validaUpdate(PacienteModel paciente) throws ExceptionNumeroNegativo, ExceptionId, ExceptionEntedidadeNaoInformada, ExceptionCamposVazio, ExceptionQuantidadeDeCaracteres {
        ValidationId.validaId(paciente.getId());
        ValidationExisteBanco.validaNoBanco(paciente, paciente.getId());
        ValidationCampoVazio.validaCamposVazio(paciente);
        ValidationQuantidadeCaracteres.validaTamanhoCampo(paciente);
        return paciente;
    }

    private void validaDelete(int id) throws ExceptionNumeroNegativo, ExceptionId, ExceptionEntedidadeNaoInformada {
        ValidationId.validaId(id);
        PacienteModel paciente = pacienteRepository.findByIdPaciente(id);
        ValidationExisteBanco.validaNoBanco(paciente, id);
    }

}
