/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.ws.services;

import com.mycompany.clinica.ws.exceptions.*;
import com.mycompany.clinica.ws.model.EstadoModel;
import com.mycompany.clinica.ws.repository.EstadoRepository;
import com.mycompany.clinica.ws.services.validation.ValidationCampoVazio;
import com.mycompany.clinica.ws.services.validation.ValidationExisteBanco;
import com.mycompany.clinica.ws.services.validation.ValidationId;
import com.mycompany.clinica.ws.services.validation.ValidationQuantidadeCaracteres;
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
            EstadoModel estado = validaFindById(id);
            return estado;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public EstadoModel inserirEstado(EstadoModel estado) throws ExceptionCamposVazio,
            ExceptionEntedidadeNaoInformada,
            ExceptionQuantidadeDeCaracteres {
        try {
            validaInsert(estado);
            return estadoRepository.inserirEstado(estado);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public EstadoModel atualizarEstado(EstadoModel estado) {
        try {
            validaUpdate(estado);
            return estadoRepository.atualizarEstado(estado);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deletarEstado(int id) {
        try {
            validaDelete(id);
            estadoRepository.deletarEstado(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void validaInsert(EstadoModel estado) throws ExceptionCamposVazio, ExceptionEntedidadeNaoInformada, ExceptionQuantidadeDeCaracteres {
        ValidationCampoVazio.validaCamposVazio(estado);
        ValidationQuantidadeCaracteres.validaTamanhoCampo(estado);
    }

    private EstadoModel validaFindById(int id) throws ExceptionNumeroNegativo, ExceptionId, ExceptionEntedidadeNaoInformada {
        ValidationId.validaId(id);
        EstadoModel estado = estadoRepository.findByIdEstado(id);
        ValidationId.validaExiste(estado, id);
        return estado;
    }

    private EstadoModel validaUpdate(EstadoModel estado) throws ExceptionNumeroNegativo, ExceptionId, ExceptionEntedidadeNaoInformada, ExceptionCamposVazio, ExceptionQuantidadeDeCaracteres {
        ValidationId.validaId(estado.getId());
        ValidationExisteBanco.validaNoBanco(estado, estado.getId());
        ValidationCampoVazio.validaCamposVazio(estado);
        ValidationQuantidadeCaracteres.validaTamanhoCampo(estado);
        return estado;
    }

    private void validaDelete(int id) throws ExceptionNumeroNegativo, ExceptionId, ExceptionEntedidadeNaoInformada {
        ValidationId.validaId(id);
        EstadoModel estado = estadoRepository.findByIdEstado(id);
        ValidationExisteBanco.validaNoBanco(estado, id);
    }

}
