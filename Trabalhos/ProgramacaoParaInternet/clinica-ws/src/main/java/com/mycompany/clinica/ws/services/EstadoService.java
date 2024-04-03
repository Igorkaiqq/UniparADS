/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.services;

import com.mycompany.clinica.ws.exceptions.ExceptionCamposVazio;
import com.mycompany.clinica.ws.exceptions.ExceptionEntedidadeNaoInformada;
import com.mycompany.clinica.ws.exceptions.ExceptionId;
import com.mycompany.clinica.ws.exceptions.ExceptionQuantidadeDeCaracteres;
import com.mycompany.clinica.ws.interfaces.EstadoInterface;
import com.mycompany.clinica.ws.model.EstadoModel;
import com.mycompany.clinica.ws.repository.EstadoRepository;
import com.mycompany.clinica.ws.services.validation.ValidationCampoVazio;
import com.mycompany.clinica.ws.services.validation.ValidationId;
import com.mycompany.clinica.ws.services.validation.ValidationQuantidadeCaracteres;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author igork
 */
public class EstadoService {

    private final EstadoRepository estadoRepository;
    
    public EstadoService(EstadoRepository estadoRepository){

        this.estadoRepository = estadoRepository;
    }

    public ArrayList<EstadoModel> listAllEstado() {
        try {
            return estadoRepository.listAllEstado();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public EstadoModel findByIdEstado(int id) throws ExceptionId {
        try {
            ValidationId.validaId(id);
            EstadoModel estado = estadoRepository.findByIdEstado(id);
            ValidationId.validaExiste(estado, id);
            return estado;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public EstadoModel inserirEstado(EstadoModel estado) throws ExceptionCamposVazio,
            ExceptionEntedidadeNaoInformada,
            ExceptionQuantidadeDeCaracteres {

            ValidationCampoVazio.validaCamposVazio(estado);
            ValidationQuantidadeCaracteres.validaTamanhoCampo(estado);
            return estadoRepository.inserirEstado(estado);

    }

    public EstadoModel atualizarEstado(EstadoModel estado) {
        try {
            ValidationCampoVazio.validaCamposVazio(estado);
            ValidationQuantidadeCaracteres.validaTamanhoCampo(estado);
            return estadoRepository.atualizarEstado(estado);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deletarEstado(int id) {
        try {
            ValidationId.validaId(id);
            EstadoModel estado = estadoRepository.findByIdEstado(id);
            ValidationId.validaExiste(estado, id);
            estadoRepository.deletarEstado(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
