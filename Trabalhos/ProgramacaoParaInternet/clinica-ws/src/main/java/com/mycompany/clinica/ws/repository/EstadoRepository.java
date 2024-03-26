package com.mycompany.clinica.ws.repository;

import com.mycompany.clinica.ws.infraestructure.Conexao;
import com.mycompany.clinica.ws.interfaces.EstadoInterface;
import com.mycompany.clinica.ws.model.EstadoModel;

import java.util.ArrayList;

public class EstadoRepository extends Conexao implements EstadoInterface {
    @Override
    public ArrayList<EstadoModel> findByNomeEstado(String nome) {
        return null;
    }

    @Override
    public ArrayList<EstadoModel> findByLikeNomeEstado(String nome) {
        return null;
    }

    @Override
    public EstadoModel findBySiglaEstado(String nome) {

        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * FROM estado WHERE sigla = '" + nome + "';"
            );
            while(rs.next()){
                EstadoModel estado = new EstadoModel();
                estado.setId(rs.getInt("id"));
                estado.setNome(rs.getString("nome"));
                estado.setSigla(rs.getString("sigla"));
                return estado;
            }
        } catch (Exception e) {
            e.printStackTrace();

    }
        return null;
    }

    @Override
    public ArrayList<EstadoModel> listAllEstado() {

        ArrayList<EstadoModel> listaEstado = new ArrayList<EstadoModel>();

        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * FROM estado;"
            );
            while(rs.next()){
                EstadoModel estado = new EstadoModel();
                estado.setId(rs.getInt("id"));
                estado.setNome(rs.getString("nome"));
                estado.setSigla(rs.getString("sigla"));
                listaEstado.add(estado);
            }
            return listaEstado;
        } catch (Exception e) {
            e.printStackTrace();

    }
        return null;
    }

    @Override
    public EstadoModel findByIdEstado(int id) {

        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * FROM estado WHERE id = '" + id + "';"
            );
            while(rs.next()){
                EstadoModel estado = new EstadoModel();
                estado.setId(rs.getInt("id"));
                estado.setNome(rs.getString("nome"));
                estado.setSigla(rs.getString("sigla"));
                return estado;
            }
        } catch (Exception e) {
            e.printStackTrace();
    }
        return null;
    }

    @Override
    public EstadoModel inserirEstado(EstadoModel estado) {
        try {
            this.conectar();
            pstm = con.prepareStatement("INSERT INTO estado (nome, sigla) VALUES (?, ?)");
            pstm.setString(1, estado.getNome());
            pstm.setString(2, estado.getSigla());
            pstm.executeUpdate();
            return estado;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return null;
    }

    @Override
    public EstadoModel atualizarEstado(EstadoModel estado) {
        try {
            this.conectar();
            pstm = con.prepareStatement("UPDATE estado SET nome = ?, sigla = ? WHERE id = ?");
            pstm.setString(1, estado.getNome());
            pstm.setString(2, estado.getSigla());
            pstm.setInt(3, estado.getId());
            pstm.executeUpdate();
            return estado;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return null;
    }

    @Override
    public boolean deletarEstado(int id) {
        try {
            this.conectar();
            pstm = con.prepareStatement("DELETE FROM estado WHERE id = ?");
            pstm.setInt(1, id);
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return false;
    }
}
