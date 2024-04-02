package com.mycompany.clinica.ws.repository;

import com.mycompany.clinica.ws.infraestructure.Conexao;
import com.mycompany.clinica.ws.model.EstadoModel;

import java.util.ArrayList;

public class EstadoRepository extends Conexao {
//    @Override
//    public EstadoModel findByNomeEstado(String nome) {
//
//        try {
//            this.conectar();
//            setPstm(getCon().prepareStatement("SELECT * FROM estado WHERE Nome = ?"));
//            getPstm().setString(1, nome);
//            setRs(getPstm().executeQuery());
//            if (getRs().next()){
//                EstadoModel estado = new EstadoModel();
//                estado.setId(getRs().getInt("id"));
//                estado.setNome(getRs().getString("nome"));
//                estado.setSigla(getRs().getString("sigla"));
//                return estado;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    @Override
//    public ArrayList<EstadoModel> findByLikeNomeEstado(String nome) {
//        ArrayList<EstadoModel> listaEstado = new ArrayList<EstadoModel>();
//        try {
//            this.conectar();
//            setPstm(getCon().prepareStatement("SELECT * FROM estado WHERE Nome LIKE ?"));
//            getPstm().setString(1, "%"+nome+"%");
//            setRs(getPstm().executeQuery());
//            while(getRs().next()){
//                EstadoModel estado = new EstadoModel();
//                estado.setId(getRs().getInt("Id"));
//                estado.setNome(getRs().getString("Nome"));
//                estado.setSigla(getRs().getString("Sigla"));
//                listaEstado.add(estado);
//            }
//            return listaEstado;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    @Override
//    public EstadoModel findBySiglaEstado(String nome) {
//
//        try {
//            this.conectar();
//            setPstm(getCon().prepareStatement("SELECT * FROM estado WHERE Sigla = ?"));
//            getPstm().executeQuery();
//            getPstm().setString(1, nome);
//            if (getRs().next()){
//                EstadoModel estado = new EstadoModel();
//                estado.setId(getRs().getInt("id"));
//                estado.setNome(getRs().getString("nome"));
//                estado.setSigla(getRs().getString("sigla"));
//                return estado;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//
//    }
//        return null;
//    }

    public ArrayList<EstadoModel> listAllEstado() {

        ArrayList<EstadoModel> listaEstado = new ArrayList<EstadoModel>();

        try {
            this.conectar();
            setPstm(getCon().prepareStatement(
                    "SELECT * FROM estado"
            ));
            getPstm().executeQuery();
            while(getRs().next()){
                EstadoModel estado = new EstadoModel();
                estado.setId(getRs().getInt("Id"));
                estado.setNome(getRs().getString("Nome"));
                estado.setSigla(getRs().getString("Sigla"));
                listaEstado.add(estado);
            }
            return listaEstado;
        } catch (Exception e) {
            e.printStackTrace();

        }finally {
            this.fecharConexao();
        }
        return null;
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
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }

        return null;
    }

    public EstadoModel inserirEstado(EstadoModel estado) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("INSERT INTO estado (nome, sigla) VALUES (?, ?)"));
            getPstm().setString(1, estado.getNome());
            getPstm().setString(2, estado.getSigla());
            getPstm().executeUpdate();
            return estado;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return null;
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
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return null;
    }

    public boolean deletarEstado(int id) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("DELETE FROM estado WHERE Id = ?"));
            getPstm().setInt(1, id);
            getPstm().executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return false;
    }
}
