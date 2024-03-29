package com.mycompany.clinica.ws.repository;

import com.mycompany.clinica.ws.infraestructure.Conexao;
import com.mycompany.clinica.ws.interfaces.EnderecoInterface;
import com.mycompany.clinica.ws.model.EnderecoModel;

import java.util.ArrayList;

public class EnderecoRepository extends Conexao {
//    @Override
//    public ArrayList<EnderecoModel> findByBairroEndereco(String bairro) {
//        ArrayList<EnderecoModel> listaEndereco = new ArrayList<>();
//        try {
//            this.conectar();
//            setPstm(getCon().prepareStatement("SELECT * FROM endereco WHERE Bairro = ?"));
//            getPstm().setString(1, bairro);
//            getPstm().executeQuery();
//            while (getRs().next()){
//                EnderecoModel endereco = new EnderecoModel();
//                endereco.setId(getRs().getInt("Id"));
//                endereco.setBairro(getRs().getString("Bairro"));
//                endereco.setCep(getRs().getString("CEP"));
//                endereco.getCidade().setId(getRs().getInt("CidadeId"));
//                endereco.setNumero(getRs().getInt("Numero"));
//                endereco.setComplemento(getRs().getString("Complemento"));
//                endereco.setLogradouro(getRs().getString("Logradouro"));
//                listaEndereco.add(endereco);
//            }
//            return listaEndereco;
//        } catch (Exception e ){
//            e.printStackTrace();
//        } finally {
//            this.fecharConexao();
//        }
//        return null;
//    }
//
//    @Override
//    public ArrayList<EnderecoModel> findByLikeLogradouroEndereco(String logradouro) {
//        return null;
//    }
//
//    @Override
//    public ArrayList<EnderecoModel> findByCidadeNomeEndereco(String nome) {
//        return null;
//    }
//
//    @Override
//    public ArrayList<EnderecoModel> findByLikeCidadeNomeEndereco(String nome) {
//        return null;
//    }
//
//    @Override
//    public ArrayList<EnderecoModel> findByCEPEndereco(String cep) {
//        return null;
//    }


    public ArrayList<EnderecoModel> listAllEndereco() {
        ArrayList<EnderecoModel> listaEndereco = new ArrayList<>();
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("SELECT * FROM endereco"));
            getPstm().executeQuery();
            while (getRs().next()){
                EnderecoModel endereco = new EnderecoModel();
                endereco.setId(getRs().getInt("Id"));
                endereco.setBairro(getRs().getString("Bairro"));
                endereco.setCep(getRs().getString("CEP"));
                endereco.getCidade().setId(getRs().getInt("CidadeId"));
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
            getPstm().executeQuery();
            if (getRs().next()){
                EnderecoModel endereco = new EnderecoModel();
                endereco.setId(getRs().getInt("Id"));
                endereco.setBairro(getRs().getString("Bairro"));
                endereco.setCep(getRs().getString("CEP"));
                endereco.getCidade().setId(getRs().getInt("CidadeId"));
                endereco.setNumero(getRs().getInt("Numero"));
                endereco.setComplemento(getRs().getString("Complemento"));
                endereco.setLogradouro(getRs().getString("Logradouro"));
                return endereco;
            }
        } catch (Exception e ){
            e.printStackTrace();
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
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return null;
    }

    public EnderecoModel atualizarEndereco(EnderecoModel endereco) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("UPDATE endereco " +
                    "SET Logradouro ?, " +
                    "SET Numero = ?, " +
                    "SET Complemento = ?, " +
                    "SET Bairro = ?, " +
                    "SET CEP = ?, " +
                    "SET CidadeId = ?"));
            getPstm().setString(1, endereco.getLogradouro());
            getPstm().setInt(2, endereco.getNumero());
            getPstm().setString(3, endereco.getComplemento());
            getPstm().setString(4, endereco.getBairro());
            getPstm().setString(5, endereco.getCep());
            getPstm().setInt(6, endereco.getCidade().getId());
            getPstm().executeUpdate();
            return endereco;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return null;
    }

    public void deletarEndereco(int id) {
        try{
            this.conectar();
            setPstm(getCon().prepareStatement("DELETE FROM cidade WHERE Id = ?"));
            getPstm().setInt(1, id);
            getPstm().executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
    }
}
