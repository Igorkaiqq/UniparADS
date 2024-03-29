package com.mycompany.clinica.ws.repository;

import com.mycompany.clinica.ws.Enums.StatusRegistroEnum;
import com.mycompany.clinica.ws.infraestructure.Conexao;
import com.mycompany.clinica.ws.interfaces.MedicoInterface;
import com.mycompany.clinica.ws.model.EnderecoModel;
import com.mycompany.clinica.ws.model.MedicoModel;

import java.util.ArrayList;

public class MedicoRepository extends Conexao {
//    @Override
//    public ArrayList<MedicoModel> findByNomeMedico(String nome) {
//        return null;
//    }
//
//    @Override
//    public ArrayList<MedicoModel> findByLikeNomeMedico(String nome) {
//        return null;
//    }
//
//    @Override
//    public MedicoModel findByCRMMedico(String crm) {
//        return null;
//    }
//
//    @Override
//    public ArrayList<MedicoModel> findByEspecialidadeMedico(String nome) {
//        return null;
//    }

    public ArrayList<MedicoModel> listAllMedico() {
        ArrayList<MedicoModel> listaMedico = new ArrayList<>();
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("SELECT * FROM medico"));
            getPstm().executeQuery();
            while(getRs().next()){
                MedicoModel medico = new MedicoModel();
                medico.setId(getRs().getInt("Id"));
                medico.getPessoa().setId(getRs().getInt("PessoaId"));
                medico.getEspecialidade().setId(getRs().getInt("EspecialidadeId"));
                medico.setStatusRegistro(getRs().getInt("StatusRegistro") == 1 ? StatusRegistroEnum.ATIVO
                        : StatusRegistroEnum.INATIVO);
                medico.setCRM(getRs().getString("CRM"));
                listaMedico.add(medico);
            }
            return listaMedico;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return null;
    }

//    @Override
//    public ArrayList<MedicoModel> findByStatusMedico(String nome) {
//        return null;
//    }

    public MedicoModel findByIdMedico(int id) {
        ArrayList<MedicoModel> listaMedico = new ArrayList<>();
        try {
            setPstm(getCon().prepareStatement("SELECT * FROM medico WHERE Id = ?"));
            getPstm().setInt(1, id);
            getPstm().executeQuery();
            if (getRs().first()){
                MedicoModel medico = new MedicoModel();
                medico.setId(getRs().getInt("Id"));
                medico.getPessoa().setId(getRs().getInt("PessoaId"));
                medico.getEspecialidade().setId(getRs().getInt("EspecialidadeId"));
                medico.setStatusRegistro(getRs().getInt("StatusRegistro") == 1 ? StatusRegistroEnum.ATIVO
                        : StatusRegistroEnum.INATIVO);
                medico.setCRM(getRs().getString("CRM"));
                listaMedico.add(medico);
                return medico;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }

        return null;
    }


    public MedicoModel inserirMedico(MedicoModel medico) {
        try {
            setPstm(getCon().prepareStatement("INSERT INTO medico (PessoaId, EspecialidadeId, StatusRegistro, CRM)" +
                    " VALUES " +
                    "(?,?,?,?)"));
            getPstm().setInt(1, medico.getPessoa().getId());
            getPstm().setInt(2, medico.getEspecialidade().getId());
            getPstm().setInt(2, medico.getStatusRegistro().equals(StatusRegistroEnum.ATIVO) ? 1 : 0);
            getPstm().setString(4, medico.getCRM());
            getPstm().executeUpdate();
            return medico;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }

        return null;
    }


    public MedicoModel atualizarMedico(MedicoModel medico) {
        try {
            setPstm(getCon().prepareStatement("UPDATE medico " +
                    "SET PessoaId = ?, " +
                    "SET EspecialidadeId = ?, " +
                    "SET StatusRegistro = ?," +
                    "SET CRM = ? " +
                    "WHERE Id = ?"));
            getPstm().setInt(1, medico.getId());
            getPstm().setInt(2, medico.getPessoa().getId());
            getPstm().setInt(3, medico.getEspecialidade().getId());
            getPstm().setInt(2, medico.getStatusRegistro().equals(StatusRegistroEnum.ATIVO) ? 1 : 0);
            getPstm().setString(5, medico.getCRM());
            getPstm().executeUpdate();
            return medico;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return null;
    }


    public void deletarMedico(int id) {
        try {
            setPstm(getCon().prepareStatement("UPDATE medico SET StatusRegistro = 0 WHERE Id = ? "));
            getPstm().setInt(1, id);
            getPstm().executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
    }

    public void ativarMedico(int id) {
        try {
            setPstm(getCon().prepareStatement("UPDATE medico SET StatusRegistro = 1 WHERE Id = ? "));
            getPstm().setInt(1, id);
            getPstm().executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
    }
}
