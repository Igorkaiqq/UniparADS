package com.mycompany.clinica.ws.repository;

import com.mycompany.clinica.ws.infraestructure.Conexao;
import com.mycompany.clinica.ws.model.EstadoModel;

import java.sql.Statement;
import java.util.ArrayList;

public class EstadoRepository extends Conexao {

    public ArrayList<EstadoModel> listAllEstado() {
        ArrayList<EstadoModel> listaEstado = new ArrayList<EstadoModel>();
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("SELECT * FROM estado"));
            setRs(getPstm().executeQuery());
            while(getRs().next()){
                EstadoModel estado = new EstadoModel();
                estado.setId(getRs().getInt("Id"));
                estado.setNome(getRs().getString("Nome"));
                estado.setSigla(getRs().getString("Sigla"));
                listaEstado.add(estado);
            }
            return listaEstado;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }finally {
            this.fecharConexao();
        }
    }

    public EstadoModel findByIdEstado(int id) {

        try {
            this.conectar();
            setPstm(getCon().prepareStatement("SELECT * FROM estado WHERE id = ?"));
            getPstm().setInt(1, id);
            setRs(getPstm().executeQuery());

            if (getRs().next()){
                EstadoModel estado = new EstadoModel();
                estado.setId(getRs().getInt("Id"));
                estado.setNome(getRs().getString("Nome"));
                estado.setSigla(getRs().getString("Sigla"));
                return estado;
            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }

        return null;
    }

    public EstadoModel inserirEstado(EstadoModel estado) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("INSERT INTO estado (nome, sigla) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS));
            getPstm().setString(1, estado.getNome());
            getPstm().setString(2, estado.getSigla());
            getPstm().executeUpdate();
            setRs(getPstm().getGeneratedKeys());
            getRs().next();
            estado.setId(getRs().getInt(1));
            return estado;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
    }

    public EstadoModel atualizarEstado(EstadoModel estado) {
        try {
            this.conectar();
            
            this.getPstm();
            setPstm(getCon().prepareStatement("UPDATE estado SET nome = ?, sigla = ? WHERE id = ?"));
            getPstm().setString(1, estado.getNome());
            getPstm().setString(2, estado.getSigla());
            getPstm().setInt(3, estado.getId());
            getPstm().executeUpdate();
            return estado;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
    }

    public boolean deletarEstado(int id) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("DELETE FROM estado WHERE Id = ?"));
            getPstm().setInt(1, id);
            getPstm().executeUpdate();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
    }
}
