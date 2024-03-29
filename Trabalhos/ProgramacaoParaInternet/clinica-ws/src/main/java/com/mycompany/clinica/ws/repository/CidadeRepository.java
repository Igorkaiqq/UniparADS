package com.mycompany.clinica.ws.repository;

import com.mycompany.clinica.ws.infraestructure.Conexao;
import com.mycompany.clinica.ws.interfaces.CidadeInterface;
import com.mycompany.clinica.ws.model.CidadeModel;

import java.util.ArrayList;

public class CidadeRepository extends Conexao {


//    @Override
//    public CidadeModel findByCidadeNomeCidade(String nome) {
//        try {
//            this.conectar();
//            setPstm(getCon().prepareStatement("SELECT * FROM cidade WHERE Nome = ?"));
//            getPstm().setString(1, nome);
//            setRs(getPstm().executeQuery());
//            if (getRs().next()){
//                CidadeModel cidade = new CidadeModel();
//                cidade.setId(getRs().getInt("Id"));
//                cidade.setNome(getRs().getString("Nome"));
//                cidade.getEstado().setId(getRs().getInt("EstadoId"));
//                return cidade;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    @Override
//    public ArrayList<CidadeModel> findByLikeCidadeNomeCidade(String nome) {
//        ArrayList<CidadeModel> listaCidade = new ArrayList<CidadeModel>();
//        try {
//
//            this.conectar();
//            setPstm(getCon().prepareStatement("SELECT * FROM cidade WHERE nome LIKE ?"));
//            getPstm().setString(1, "%"+nome+"%");
//            setRs(getPstm().executeQuery());
//            while (getRs().next()){
//                CidadeModel cidade = new CidadeModel();
//                cidade.setId(getRs().getInt("Id"));
//                cidade.setNome(getRs().getString("Nome"));
//                cidade.getEstado().setId(getRs().getInt("EstadoId"));
//                listaCidade.add(cidade);
//            };
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    @Override
//    public ArrayList<CidadeModel> findByEstadoNomeCidade(String nome) {
//        ArrayList<CidadeModel> listaCidade = new ArrayList<>();
//
//        try{
//            this.conectar();
//            setPstm(getCon().prepareStatement("SELECT cidade.Id, cidade.Nome, cidade.EstadoId FROM cidade " +
//                    "INNER JOIN estado ON cidade.EstadoId = estado.Id " +
//                    "WHERE estado.Nome = ?"));
//            getPstm().setString(1, nome);
//            setRs(getPstm().executeQuery());
//            while (getRs().next()){
//                CidadeModel cidade = new CidadeModel();
//                cidade.setId(getRs().getInt("Id"));
//                cidade.setNome(getRs().getString("Nome"));
//                cidade.getEstado().setId(getRs().getInt("EstadoId"));
//            }
//
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    @Override
//    public ArrayList<CidadeModel> findByEstadoSiglaCidade(String sigla) {
//        ArrayList<CidadeModel> listaCidade = new ArrayList<>();
//
//        try{
//            this.conectar();
//            setPstm(getCon().prepareStatement("SELECT cidade.Id, cidade.Nome, cidade.EstadoId FROM cidade " +
//                    "INNER JOIN estado ON cidade.EstadoId = estado.Id " +
//                    "WHERE estado.Sigla = ?"));
//            getPstm().setString(1, sigla);
//            setRs(getPstm().executeQuery());
//            while (getRs().next()){
//                CidadeModel cidade = new CidadeModel();
//                cidade.setId(getRs().getInt("Id"));
//                cidade.setNome(getRs().getString("Nome"));
//                cidade.getEstado().setId(getRs().getInt("EstadoId"));
//            }
//            return listaCidade;
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return null;
//    }

    public ArrayList<CidadeModel> listAllCidade() {
        ArrayList<CidadeModel> listaCidade = new ArrayList<>();
        try {
            setPstm(getCon().prepareStatement("SELECT * FROM cidade"));
            setRs(getPstm().executeQuery());
            while(getRs().next()){
                CidadeModel cidade = new CidadeModel();
                cidade.setId(getRs().getInt("Id"));
                cidade.setNome(getRs().getString("Nome"));
                cidade.getEstado().setId(getRs().getInt("EmpresaId"));
            }
            return listaCidade;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public CidadeModel findByIdCidade(int id) {
        try {
            setPstm(getCon().prepareStatement("SELECT * FROM cidade WHERE Id = ?"));
            getPstm().setInt(1, id);
            setRs(getPstm().executeQuery());
            if (getRs().first()){
                CidadeModel cidade = new CidadeModel();
                cidade.setId(getRs().getInt("Id"));
                cidade.setNome(getRs().getString("Nome"));
                cidade.getEstado().setId(getRs().getInt("EmpresaId"));
                return cidade;
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public CidadeModel inserirCidade(CidadeModel cidade) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("INSERT INTO cidade (Nome, EstadoId) VALUES (?, ?)"));
            getPstm().setString(1, cidade.getNome());
            getPstm().setInt(2, cidade.getEstado().getId());
            getPstm().executeUpdate();
            return cidade;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }

        return null;
    }

    public CidadeModel atualizarCidade(CidadeModel cidade) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("UPDATE cidade SET Nome = ?, EstadoId = ? WHERE Id = ?"));
            getPstm().setString(1, cidade.getNome());
            getPstm().setInt(2, cidade.getEstado().getId());
            getPstm().setInt(3, cidade.getId());
            getPstm().executeUpdate();
            return cidade;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
         return null;
    }

    public void deletarCidade(int id) {

        try {
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