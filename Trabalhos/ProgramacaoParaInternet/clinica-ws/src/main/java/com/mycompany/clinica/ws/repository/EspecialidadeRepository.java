package com.mycompany.clinica.ws.repository;

import com.mycompany.clinica.ws.infraestructure.Conexao;
import com.mycompany.clinica.ws.model.EspecialidadeModel;

import java.util.ArrayList;

public class EspecialidadeRepository extends Conexao {

    public ArrayList<EspecialidadeModel> listAllEspecialidade() {
        ArrayList<EspecialidadeModel> listaEspecialidade = new ArrayList<>();
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("SELECT * FROM especialidade"));
            setRs(getPstm().executeQuery());
            while(getRs().next()){
                EspecialidadeModel especialidade = new EspecialidadeModel();
                especialidade.setId(getRs().getInt("Id"));
                especialidade.setNome(getRs().getString("Nome"));
                listaEspecialidade.add(especialidade);
            }
            return listaEspecialidade;
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
    }

    public EspecialidadeModel findByIdEspecialidade(int id) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("SELECT * FROM especialidade WHERE Id = ?"));
            getPstm().setInt(1, id);
            setRs(getPstm().executeQuery());
            if (getRs().next()){
                EspecialidadeModel especialidade = new EspecialidadeModel();
                especialidade.setId(getRs().getInt("Id"));
                especialidade.setNome(getRs().getString("Nome"));
                return especialidade;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
        return null;
    }

    public EspecialidadeModel inserirEspecialidade(EspecialidadeModel especialidade) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("INSERT INTO especialidade (Nome) VALUES (?)"));
            getPstm().setString(1, especialidade.getNome());
            getPstm().executeUpdate();
            return especialidade;
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
    }

    public EspecialidadeModel atualizarEspecialidade(EspecialidadeModel especialidade) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("UPDATE especialidade SET Nome = ? WHERE Id = ?"));
            getPstm().setString(1, especialidade.getNome());
            getPstm().setInt(2, especialidade.getId());
            getPstm().executeUpdate();
            return especialidade;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
    }

    public void deletarEspecialidade(int id) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("DELETE FROM especialidade WHERE Id = ?"));
            getPstm().setInt(1, id);
            getPstm().executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
    }
}
