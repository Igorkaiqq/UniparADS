package com.mycompany.clinica.ws.repository;

import com.mycompany.clinica.ws.infraestructure.Conexao;
import com.mycompany.clinica.ws.model.CidadeModel;
import com.mycompany.clinica.ws.model.EstadoModel;

import java.util.ArrayList;

public class CidadeRepository extends Conexao {

    public ArrayList<CidadeModel> listAllCidade() {
        ArrayList<CidadeModel> listaCidade = new ArrayList<CidadeModel>();
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("SELECT * FROM cidade"));
            setRs(getPstm().executeQuery());
            while(getRs().next()){
                CidadeModel cidade = new CidadeModel();
                cidade.setId(getRs().getInt("Id"));
                cidade.setNome(getRs().getString("Nome"));
                EstadoModel estado = new EstadoModel();
                estado.setId(getRs().getInt("EstadoId"));
                cidade.setEstado(estado);
                listaCidade.add(cidade);
            }
            return listaCidade;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
    }

    public CidadeModel findByIdCidade(int id) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("SELECT * FROM cidade WHERE Id = ?"));
            getPstm().setInt(1, id);
            setRs(getPstm().executeQuery());
            if (getRs().next()){
                CidadeModel cidade = new CidadeModel();
                cidade.setId(getRs().getInt("Id"));
                cidade.setNome(getRs().getString("Nome"));
                EstadoModel estado = new EstadoModel();
                estado.setId(getRs().getInt("EstadoId"));
                cidade.setEstado(estado);
                return cidade;
            }
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
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
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
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
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
    }

    public void deletarCidade(int id) {

        try {
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
