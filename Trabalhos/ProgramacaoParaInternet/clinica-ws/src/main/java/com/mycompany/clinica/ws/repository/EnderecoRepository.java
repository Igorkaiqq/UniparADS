package com.mycompany.clinica.ws.repository;

import com.mycompany.clinica.ws.infraestructure.Conexao;
import com.mycompany.clinica.ws.model.CidadeModel;
import com.mycompany.clinica.ws.model.EnderecoModel;

import java.util.ArrayList;

public class EnderecoRepository extends Conexao {

    public ArrayList<EnderecoModel> listAllEndereco() {
        ArrayList<EnderecoModel> listaEndereco = new ArrayList<EnderecoModel>();
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("SELECT * FROM endereco"));
            setRs(getPstm().executeQuery());
            while (getRs().next()){
                EnderecoModel endereco = new EnderecoModel();
                endereco.setId(getRs().getInt("Id"));
                endereco.setBairro(getRs().getString("Bairro"));
                endereco.setCep(getRs().getString("CEP"));
                CidadeModel cidade = new CidadeModel();
                cidade.setId(getRs().getInt("CidadeId"));
                endereco.setCidade(cidade);
                endereco.setNumero(getRs().getInt("Numero"));
                endereco.setComplemento(getRs().getString("Complemento"));
                endereco.setLogradouro(getRs().getString("Logradouro"));
                listaEndereco.add(endereco);
            }
            return listaEndereco;
        } catch (Exception e ){
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return null;
    }

    public EnderecoModel findByIdEndereco(int id) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("SELECT * FROM endereco WHERE Id = ?"));
            getPstm().setInt(1, id);
            setRs(getPstm().executeQuery());
            if (getRs().next()){
                EnderecoModel endereco = new EnderecoModel();
                endereco.setId(getRs().getInt("Id"));
                endereco.setBairro(getRs().getString("Bairro"));
                endereco.setCep(getRs().getString("CEP"));
                CidadeModel cidade = new CidadeModel();
                cidade.setId(getRs().getInt("CidadeId"));
                endereco.setCidade(cidade);
                endereco.setNumero(getRs().getInt("Numero"));
                endereco.setComplemento(getRs().getString("Complemento"));
                endereco.setLogradouro(getRs().getString("Logradouro"));
                return endereco;
            }
        } catch (Exception e ){
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
        return null;
    }

    public EnderecoModel inserirEndereco(EnderecoModel endereco) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("INSERT INTO endereco " +
                    "(Logradouro, Numero, Complemento, Bairro, Cep, CidadeId)" +
                    " VALUES " +
                    "(?, ?, ?, ?, ?, ?)"));
            getPstm().setString(1, endereco.getLogradouro());
            getPstm().setInt(2, endereco.getNumero());
            getPstm().setString(3, endereco.getComplemento());
            getPstm().setString(4, endereco.getBairro());
            getPstm().setString(5, endereco.getCep());
            getPstm().setInt(6, endereco.getCidade().getId());
            getPstm().executeUpdate();
            return endereco;
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
    }

    public EnderecoModel atualizarEndereco(EnderecoModel endereco) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("UPDATE endereco " +
                    "SET Logradouro = ?, " +
                    "Numero = ?, " +
                    "Complemento = ?, " +
                    "Bairro = ?, " +
                    "CEP = ?, " +
                    "CidadeId = ?"));
            getPstm().setString(1, endereco.getLogradouro());
            getPstm().setInt(2, endereco.getNumero());
            getPstm().setString(3, endereco.getComplemento());
            getPstm().setString(4, endereco.getBairro());
            getPstm().setString(5, endereco.getCep());
            getPstm().setInt(6, endereco.getCidade().getId());
            getPstm().executeUpdate();
            return endereco;
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
    }

    public void deletarEndereco(int id) {
        try{
            this.conectar();
            setPstm(getCon().prepareStatement("DELETE FROM cidade WHERE Id = ?"));
            getPstm().setInt(1, id);
            getPstm().executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
    }
}
