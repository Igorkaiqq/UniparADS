package com.mycompany.clinica.ws.repository;


import com.mycompany.clinica.ws.infraestructure.Conexao;
import com.mycompany.clinica.ws.model.EspecialidadeModel;
import com.mycompany.clinica.ws.model.MedicoModel;
import com.mycompany.clinica.ws.model.PessoaModel;

import java.util.ArrayList;

public class MedicoRepository extends Conexao {

    public ArrayList<MedicoModel> listAllMedico() {
        ArrayList<MedicoModel> listaMedico = new ArrayList<>();
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("SELECT med.Id as id,pes.Nome AS nome, pes.Email AS email, " +
                    "med.CRM AS crm, esp.Nome AS especialidade, med.StatusRegistro AS statusregistro " +
                    "FROM medico med " +
                    "INNER JOIN pessoa pes ON (med.PessoaId = pes.Id) " +
                    "INNER JOIN especialidade esp ON (med.EspecialidadeId = esp.Id) " +
                    "ORDER BY pes.Nome ASC"));
            setRs(getPstm().executeQuery());
            while(getRs().next()){
                MedicoModel medico = new MedicoModel();
                medico.setId(getRs().getInt("id"));
                medico.setPessoa(new PessoaModel());
                medico.getPessoa().setNome(getRs().getString("nome"));
                medico.getPessoa().setEmail(getRs().getString("email"));
                medico.setCrm(getRs().getString("crm"));
                medico.setEspecialidade(new EspecialidadeModel());
                medico.getEspecialidade().setNome(getRs().getString("especialidade"));
                medico.setStatusRegistro(getRs().getInt("statusregistro"));
                listaMedico.add(medico);
            }
            return listaMedico;
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
    }



    public MedicoModel findByIdMedico(int id) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("SELECT med.Id as id,pes.Nome AS nome, pes.Email AS email, " +
                    "med.CRM AS crm, esp.Nome AS especialidade, med.StatusRegistro AS statusregistro " +
                    "FROM medico med " +
                    "INNER JOIN pessoa pes ON (med.PessoaId = pes.Id) " +
                    "INNER JOIN especialidade esp ON (med.EspecialidadeId = esp.Id) " +
                    "WHERE med.Id = ?"));
            getPstm().setInt(1, id);
            setRs(getPstm().executeQuery());
            if (getRs().next()){
                MedicoModel medico = new MedicoModel();
                medico.setId(getRs().getInt("id"));
                PessoaModel pessoa = new PessoaModel();
                medico.getPessoa().setNome(getRs().getString("nome"));
                medico.getPessoa().setEmail(getRs().getString("email"));
                medico.setCrm(getRs().getString("crm"));
                medico.setEspecialidade(new EspecialidadeModel());
                medico.getEspecialidade().setNome(getRs().getString("especialidade"));
                medico.setStatusRegistro(getRs().getInt("statusregistro"));
                return medico;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
        return null;
    }


    public MedicoModel inserirMedico(MedicoModel medico) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("INSERT INTO medico (PessoaId, EspecialidadeId, StatusRegistro, CRM)" +
                    " VALUES " +
                    "(?,?,?,?)"));
            getPstm().setInt(1, medico.getPessoa().getId());
            getPstm().setInt(2, medico.getEspecialidade().getId());
            getPstm().setInt(3, medico.getStatusRegistro());
            getPstm().setString(4, medico.getCrm());
            getPstm().executeUpdate();
            return medico;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }

    }


    public MedicoModel atualizarMedico(MedicoModel medico) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("UPDATE medico " +
                    "SET PessoaId = ?, " +
                    "EspecialidadeId = ?, " +
                    "StatusRegistro = ?, " +
                    "CRM = ? " +
                    "WHERE Id = ?"));
            getPstm().setInt(1, medico.getPessoa().getId());
            getPstm().setInt(2, medico.getEspecialidade().getId());
            getPstm().setInt(3, medico.getStatusRegistro());
            getPstm().setString(4, medico.getCrm());
            getPstm().setInt(5, medico.getId());
            getPstm().executeUpdate();
            return medico;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
    }


    public void deletarMedico(int id) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("UPDATE medico SET StatusRegistro = 0 WHERE Id = ? "));
            getPstm().setInt(1, id);
            getPstm().executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
    }

    public void ativarMedico(int id) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("UPDATE medico SET StatusRegistro = 1 WHERE Id = ? "));
            getPstm().setInt(1, id);
            getPstm().executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
    }
}
