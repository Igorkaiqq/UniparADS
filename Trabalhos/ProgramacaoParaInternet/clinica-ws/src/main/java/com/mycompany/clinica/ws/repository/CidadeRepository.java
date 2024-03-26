package com.mycompany.clinica.ws.repository;

import com.mycompany.clinica.ws.infraestructure.Conexao;
import com.mycompany.clinica.ws.interfaces.CidadeInterface;
import com.mycompany.clinica.ws.model.CidadeModel;

import java.util.ArrayList;

public class CidadeRepository extends Conexao implements CidadeInterface {


    @Override
    public ArrayList<CidadeModel> findByCidadeNomeCidade(String nome) {
        return null;
    }

    @Override
    public ArrayList<CidadeModel> findByLikeCidadeNomeCidade(String nome) {
        return null;
    }

    @Override
    public ArrayList<CidadeModel> findByEstadoNomeCidade(String nome) {
        return null;
    }

    @Override
    public ArrayList<CidadeModel> findByEstadoSiglaCidade(String sigla) {
        return null;
    }

    @Override
    public ArrayList<CidadeModel> listAllCidade() {
        return null;
    }

    @Override
    public CidadeModel findByIdCidade(int id) {
        return null;
    }

    @Override
    public CidadeModel inserirCidade(CidadeModel cidade) {
        return null;
    }

    @Override
    public CidadeModel atualizarCidade(CidadeModel cidade) {

        try {
            this.conectar();
            this.executarSQL(
                    "UPDATE cidade SET "
                    + "nome = '" + cidade.getNome() + "', "
                    + "estado = '" + cidade.getEstado() + "' "
                    + "WHERE id = '" + cidade.getId() + "';"
            );
        } catch (Exception e) {
            e.printStackTrace();

        return null;
    }

    @Override
    public void deletarCidade(int id) {

        try {
            this.conectar();
            this.executarSQL(
                    "DELETE FROM cidade WHERE id = '" + id + "';"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
