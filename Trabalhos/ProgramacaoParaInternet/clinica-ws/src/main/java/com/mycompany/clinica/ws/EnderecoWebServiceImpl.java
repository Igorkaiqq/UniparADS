package com.mycompany.clinica.ws;

import com.mycompany.clinica.ws.interfaces.EnderecoInterface;
import com.mycompany.clinica.ws.model.EnderecoModel;
import com.mycompany.clinica.ws.services.EnderecoService;
import jakarta.jws.WebService;

import java.util.ArrayList;
@WebService(endpointInterface = "com.mycompany.clinica.ws.interfaces.EnderecoInterface")
public class EnderecoWebServiceImpl implements EnderecoInterface {

    EnderecoService enderecoService = new EnderecoService();

    @Override
    public ArrayList<EnderecoModel> listAllEndereco() {
        return enderecoService.listAllEndereco();
    }

    @Override
    public EnderecoModel findByIdEndereco(int id) {
        return enderecoService.findByIdEndereco(id);
    }

    @Override
    public EnderecoModel inserirEndereco(EnderecoModel endereco) {
        return enderecoService.inserirEndereco(endereco);
    }

    @Override
    public EnderecoModel atualizarEndereco(EnderecoModel endereco) {
        return enderecoService.atualizarEndereco(endereco);
    }

    @Override
    public void deletarEndereco(int id) {
        enderecoService.deletarEndereco(id);
    }
}
