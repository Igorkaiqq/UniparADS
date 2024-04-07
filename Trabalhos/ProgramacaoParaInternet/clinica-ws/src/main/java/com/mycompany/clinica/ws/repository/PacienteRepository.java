package com.mycompany.clinica.ws.repository;


import com.mycompany.clinica.ws.infraestructure.Conexao;
import com.mycompany.clinica.ws.model.PacienteModel;
import com.mycompany.clinica.ws.model.PessoaModel;

import java.util.ArrayList;

public class PacienteRepository extends Conexao {

    public ArrayList<PacienteModel> listAllPaciente() {
        ArrayList<PacienteModel> listaPaciente = new ArrayList<>();
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("SELECT pes.Id AS Id, pes.Nome AS Nome, pes.Email AS Email, pes.CPF AS CPF, pac.statusregistro AS statusregistro " +
                    "FROM paciente pac " +
                    "INNER JOIN pessoa pes ON (pac.PessoaId = pes.Id) " +
                    "ORDER BY pes.Nome ASC"));
            setRs(getPstm().executeQuery());
            while (getRs().next()) {
                PacienteModel paciente = new PacienteModel();
                paciente.setId(getRs().getInt("Id"));
                PessoaModel pessoa = new PessoaModel();
                pessoa.setId(getRs().getInt("Id")); // Correção: Usar "Id" em vez de "PessoaId"
                pessoa.setNome(getRs().getString("Nome")); // Adicionar as informações necessárias
                pessoa.setEmail(getRs().getString("Email"));
                pessoa.setCpf(getRs().getString("CPF"));
                paciente.setStatusRegistro(getRs().getInt("statusregistro"));
                paciente.setPessoa(pessoa);
                listaPaciente.add(paciente);
            }
            return listaPaciente;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
    }

    public PacienteModel findByIdPaciente(int id) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("SELECT pes.Id AS Id, pes.Nome AS Nome, pes.Email AS Email, pes.CPF AS CPF, pac.statusregistro AS statusregistro " +
                    "FROM paciente pac " +
                    "INNER JOIN pessoa pes ON (pac.PessoaId = pes.Id) " +
                    "WHERE pac.Id = ?"));
            getPstm().setInt(1, id);
            setRs(getPstm().executeQuery());
            if (getRs().next()) {
                PacienteModel paciente = new PacienteModel();
                paciente.setId(getRs().getInt("Id"));
                PessoaModel pessoa = new PessoaModel();
                pessoa.setNome(getRs().getString("Nome")); // Adicionar as informações necessárias
                pessoa.setEmail(getRs().getString("Email"));
                pessoa.setCpf(getRs().getString("CPF"));
                paciente.setStatusRegistro(getRs().getInt("statusregistro"));
                paciente.setPessoa(pessoa);
                return paciente;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
        return null;
    }




    public PacienteModel inserirPaciente(PacienteModel paciente) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("INSERT INTO paciente (PessoaId, StatusRegistro) VALUES (?, ?)"));
            getPstm().setInt(1, paciente.getPessoa().getId());
            getPstm().setInt(2, paciente.getStatusRegistro());
            getPstm().executeUpdate();
            return paciente;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }



    public PacienteModel atualizarPaciente (PacienteModel paciente){
            try {
                this.conectar();
                setPstm(getCon().prepareStatement("UPDATE paciente SET PessoaId = ?, StatusRegistro = ? WHERE Id = ?"));
                getPstm().setInt(1, paciente.getPessoa().getId());
                getPstm().setInt(2, paciente.getStatusRegistro());
                getPstm().setInt(3, paciente.getId());
                getPstm().executeUpdate();
                return paciente;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            } finally {
                this.fecharConexao();
            }
            }


    public void deletarPaciente(int id) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("UPDATE paciente SET StatusRegistro = 0 WHERE Id = ?"));
            getPstm().setInt(1, id);
            getPstm().executeUpdate();
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
        }

    public void ativarPaciente(int id) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("UPDATE paciente SET StatusRegistro = 1 WHERE Id = ? "));
            getPstm().setInt(1, id);
            getPstm().executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
    }

}
