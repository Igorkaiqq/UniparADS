package com.mycompany.clinica.ws;

import com.mycompany.clinica.ws.interfaces.PessoaInterface;
import com.mycompany.clinica.ws.model.PessoaModel;
import com.mycompany.clinica.ws.services.PessoaService;
import jakarta.jws.WebService;

import java.util.ArrayList;

@WebService(serviceName = "PessoaWebServiceImpl", endpointInterface = "com.mycompany.clinica.ws.PessoaWebServiceImpl")
public class PessoaWebServiceImpl implements PessoaInterface {

    PessoaService pessoaService = new PessoaService();

    @Override
    public ArrayList<PessoaModel> listAllPessoa() {
        return pessoaService.listAllPessoa();
    }

    @Override
    public PessoaModel findByIdPessoa(int id) {
        return pessoaService.findByIdPessoa(id);
    }

    @Override
    public PessoaModel inserirPessoa(PessoaModel pessoa) {
        return pessoaService.inserirPessoa(pessoa);
    }

    @Override
    public PessoaModel atualizarPessoa(PessoaModel pessoa) {
        return pessoaService.atualizarPessoa(pessoa);
    }

    @Override
    public void deletarPessoa(int id) {
        pessoaService.deletarPessoa(id);
    }
}
