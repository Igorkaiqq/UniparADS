package com.mycompany.clinica.ws.services;

import com.mycompany.clinica.ws.model.ConsultaModel;

import com.mycompany.clinica.ws.repository.ConsultaRepository;
import com.mycompany.clinica.ws.services.validation.ValidationConsulta;

import java.util.ArrayList;


public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    ValidationConsulta validaConsulta = new ValidationConsulta();

    public ConsultaService (ConsultaRepository consultaRepository) {
        this.consultaRepository = new ConsultaRepository();
    }

    public ConsultaModel inserirConsulta(ConsultaModel consulta) {
        try {
            validaConsulta.validaAgendarConsulta(consulta);
            consulta.setStatusRegistro(1);
            consultaRepository.inserirConsulta(consulta);
            return consulta;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public ArrayList<ConsultaModel> listAllConsulta() {
        try {
            return consultaRepository.listAllConsulta();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public ConsultaModel findByIdConsulta(int id) {
        try {
            return consultaRepository.findByIdConsulta(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public ConsultaModel cancelarConsulta(int idConsulta, String motivo) {
        try {
            validaConsulta.ValidaCancelarConsulta(idConsulta, motivo);
            ConsultaModel consulta = consultaRepository.findByIdConsulta(idConsulta);
            consulta.setStatusRegistro(0);
            consulta.setMotivoCancelamento(motivo);
            consultaRepository.cancelarConsulta(idConsulta, motivo);
            return consulta;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
