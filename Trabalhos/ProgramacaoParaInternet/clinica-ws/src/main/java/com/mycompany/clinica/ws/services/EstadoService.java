/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.services;

import com.mycompany.clinica.ws.exceptions.ExceptionId;
import com.mycompany.clinica.ws.exceptions.ExceptionNumeroNegativo;
import com.mycompany.clinica.ws.interfaces.EstadoInterface;
import com.mycompany.clinica.ws.model.EstadoModel;
import com.mycompany.clinica.ws.repository.EstadoRepository;
import com.mycompany.clinica.ws.services.validation.ValidationCampoVazio;
import com.mycompany.clinica.ws.services.validation.ValidationId;
import com.mycompany.clinica.ws.services.validation.ValidationQuantidadeCaracteres;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 *
 * @author igork
 */
public class EstadoService implements EstadoInterface {

    private final EstadoRepository estadoRepository = null;
    
    public EstadoService(){
        
    }
    
    @Override
    public ArrayList<EstadoModel> listAllEstado() {
        try {
            return estadoRepository.listAllEstado();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public EstadoModel findByIdEstado(int id) throws ExceptionId {
        try {
            ValidationId.validaId(id);
            EstadoModel estado = estadoRepository.findByIdEstado(id);
            ValidationId.validaExiste(estado, id);
            return estado;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public EstadoModel inserirEstado(EstadoModel estado) {
        try {
            ValidationCampoVazio.validaCamposVazio(estado);
            ValidationQuantidadeCaracteres.validaTamanhoCampo(estado);
            return estadoRepository.inserirEstado(estado);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public EstadoModel atualizarEstado(EstadoModel estado) {
        try {
            ValidationCampoVazio.validaCamposVazio(estado);
            ValidationQuantidadeCaracteres.validaTamanhoCampo(estado);
            return estadoRepository.atualizarEstado(estado);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deletarEstado(int id) {
        try {
            ValidationId.validaId(id);
            EstadoModel estado = estadoRepository.findByIdEstado(id);
            ValidationId.validaExiste(estado, id);
            estadoRepository.deletarEstado(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
