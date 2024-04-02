package com.mycompany.clinica.ws;

import com.mycompany.clinica.ws.interfaces.CidadeInterface;
import com.mycompany.clinica.ws.model.CidadeModel;
import com.mycompany.clinica.ws.services.CidadeService;
import jakarta.jws.WebService;

import java.util.ArrayList;

@WebService(serviceName = "CidadeWebServiceImpl")
public class CidadeWebServiceImpl implements CidadeInterface {

    CidadeService cidadeService = new CidadeService();

    @Override
    public ArrayList<CidadeModel> listAllCidade() {
        return cidadeService.listAllCidade();
    }

    @Override
    public CidadeModel findByIdCidade(int id) {
        return cidadeService.findByIdCidade(id);
    }

    @Override
    public CidadeModel inserirCidade(CidadeModel cidade) {
        return cidadeService.inserirCidade(cidade);
    }

    @Override
    public CidadeModel atualizarCidade(CidadeModel cidade) {
        return cidadeService.atualizarCidade(cidade);
    }

    @Override
    public void deletarCidade(int id) {
        cidadeService.deletarCidade(id);
    }
}
