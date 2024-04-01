package com.mycompany.clinica.ws.repository;

import com.mycompany.clinica.ws.Enums.StatusRegistroEnum;
import com.mycompany.clinica.ws.infraestructure.Conexao;
import com.mycompany.clinica.ws.interfaces.PacienteInterface;
import com.mycompany.clinica.ws.model.EnderecoModel;
import com.mycompany.clinica.ws.model.PacienteModel;

import java.util.ArrayList;

public class PacienteRepository extends Conexao {
//    @Override
//    public ArrayList<PacienteModel> findByNomePaciente(String nome) {
//        return null;
//    }
//
//    @Override
//    public ArrayList<PacienteModel> findByLikeNomePaciente(String nome) {
//        return null;
//    }


    public ArrayList<PacienteModel> listAllPaciente() {
        ArrayList<PacienteModel> listaPaciente = new ArrayList<>();
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("SELECT pes.Nome, pes.Email, pes.CPF FROM paciente pac " +
                    "INNER JOIN pessoa pes ON (pac.PessoaId = pes.Id) " +
                    "ORDER BY pes.Nome ASC"));
            getPstm().executeQuery();
            while (getRs().next()) {
                PacienteModel paciente = new PacienteModel();
                paciente.setId(getRs().getInt("Id"));
                paciente.getPessoa().setId(getRs().getInt("PessoaId"));
                paciente.setStatusRegistro(getRs().getInt("StatusRegistro") == 1 ? StatusRegistroEnum.ATIVO
                        : StatusRegistroEnum.INATIVO);
                listaPaciente.add(paciente);
            }
            return listaPaciente;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return null;
    }

//    @Override
//    public ArrayList<PacienteModel> findByStatusPaciente(String nome) {
//        return null;
//    }


    public PacienteModel findByIdPaciente(int id) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("SELECT pes.Nome, pes.Email, pes.CPF FROM paciente pac " +
                    "INNER JOIN pessoa pes ON (pac.PessoaId = pes.Id) " +
                    "WHERE pac.Id = ?" +
                    "ORDER BY pes.Nome ASC"));
            getPstm().executeQuery();
            if (getRs().first()) {
                PacienteModel paciente = new PacienteModel();
                paciente.setId(getRs().getInt("Id"));
                paciente.getPessoa().setId(getRs().getInt("PessoaId"));
                paciente.setStatusRegistro(getRs().getInt("StatusRegistro") == 1 ? StatusRegistroEnum.ATIVO
                        : StatusRegistroEnum.INATIVO);
                return paciente;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public PacienteModel inserirPaciente(PacienteModel paciente) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("INSERT INTO paciente (PessoaId, StatusRegistro) VALUES (?, ?)"));
            getPstm().setInt(1, paciente.getPessoa().getId());
            getPstm().setInt(2, paciente.getStatusRegistro().equals(StatusRegistroEnum.ATIVO) ? 1 : 0);
            getPstm().executeUpdate();
            return paciente;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


        public PacienteModel atualizarPaciente (PacienteModel paciente){
            try {
                this.conectar();
                setPstm(getCon().prepareStatement("UPDATE paciente SET PessoaId = ?, StatusRegistro = ? WHERE Id = ?"));
                getPstm().setInt(1, paciente.getPessoa().getId());
                getPstm().setInt(2, paciente.getStatusRegistro().equals(StatusRegistroEnum.ATIVO) ? 1 : 0);
                getPstm().setInt(3, paciente.getId());
                getPstm().executeUpdate();
                return paciente;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.fecharConexao();
            }
            return null;
            }


    public void deletarPaciente(int id) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("UPDATE paciente SET StatusRegistro = 0 WHERE Id = ?"));
            getPstm().setInt(1, id);
            getPstm().executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        }

    public void ativarPaciente(int id) {
        try {
            setPstm(getCon().prepareStatement("UPDATE paciente SET StatusRegistro = 1 WHERE Id = ? "));
            getPstm().setInt(1, id);
            getPstm().executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
    }

}
