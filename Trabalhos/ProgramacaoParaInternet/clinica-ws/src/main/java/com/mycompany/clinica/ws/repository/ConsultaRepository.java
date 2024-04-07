package com.mycompany.clinica.ws.repository;

import com.mycompany.clinica.ws.infraestructure.Conexao;
import com.mycompany.clinica.ws.model.ConsultaModel;
import com.mycompany.clinica.ws.model.MedicoModel;
import com.mycompany.clinica.ws.model.PacienteModel;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ConsultaRepository extends Conexao {

    public ConsultaModel inserirConsulta(ConsultaModel consulta) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("INSERT INTO consulta (PacienteId, MedicoId, DataHora, StatusRegistro) VALUES (?, ?, ?, ?)"));
            getPstm().setInt(1, consulta.getPaciente().getId());
            getPstm().setInt(2, consulta.getMedico().getId());
            getPstm().setObject(3, consulta.getDataHora());
            getPstm().setInt(4, consulta.getStatusRegistro());
            getPstm().executeUpdate();
            return consulta;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
    }

    public ArrayList<ConsultaModel> listAllConsulta() {
        ArrayList<ConsultaModel> consultas = new ArrayList<>();
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("SELECT * FROM consulta"));
            setRs(getPstm().executeQuery());
            while (getRs().next()) {
                ConsultaModel consulta = new ConsultaModel();
                consulta.setId(getRs().getInt("Id"));
                PacienteModel paciente = new PacienteModel();
                paciente.setId(getRs().getInt("PacienteId"));
                consulta.setPaciente(paciente);
                MedicoModel medico = new MedicoModel();
                medico.setId(getRs().getInt("MedicoId"));
                consulta.setMedico(medico);
                consulta.setDataHora(getRs().getObject("DataHora", LocalDateTime.class));
                consulta.setStatusRegistro(getRs().getInt("StatusRegistro"));
                consultas.add(consulta);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
        return consultas;
    }

    public ConsultaModel findByIdConsulta(int id) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("SELECT * FROM consulta WHERE Id = ?"));
            getPstm().setInt(1, id);
            setRs(getPstm().executeQuery());
            if (getRs().next()) {
                ConsultaModel consulta = new ConsultaModel();
                consulta.setId(getRs().getInt("Id"));
                PacienteModel paciente = new PacienteModel();
                paciente.setId(getRs().getInt("PacienteId"));
                consulta.setPaciente(paciente);
                MedicoModel medico = new MedicoModel();
                medico.setId(getRs().getInt("MedicoId"));
                consulta.setMedico(medico);

                Timestamp timestamp = getRs().getTimestamp("DataHora");
                LocalDateTime dataHora = timestamp.toLocalDateTime();
                consulta.setDataHora(dataHora);

                consulta.setStatusRegistro(getRs().getInt("StatusRegistro"));
                return consulta;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
        return null;
    }





    public ArrayList<ConsultaModel> listarConsultasDoDia(LocalDate data, int idPaciente) {
        ArrayList<ConsultaModel> consultasDoDia = new ArrayList<>();
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("SELECT Id, DataHora, PacienteId, MedicoId, StatusRegistro, MotivoCancelamento FROM consulta WHERE DATE(DataHora) = ? AND PacienteId = ?"));
            getPstm().setDate(1, java.sql.Date.valueOf(data));
            getPstm().setInt(2, idPaciente);
            setRs(getPstm().executeQuery());
            while (getRs().next()) {
                ConsultaModel consulta = new ConsultaModel();
                consulta.setId(getRs().getInt("Id"));
                consulta.setDataHora(getRs().getTimestamp("DataHora").toLocalDateTime());
                PacienteModel paciente = new PacienteModel();
                paciente.setId(getRs().getInt("PacienteId"));
                consulta.setPaciente(paciente);
                MedicoModel medico = new MedicoModel();
                medico.setId(getRs().getInt("MedicoId"));
                consulta.setMedico(medico);
                consulta.setStatusRegistro(getRs().getInt("StatusRegistro"));
                consulta.setMotivoCancelamento(getRs().getString("MotivoCancelamento"));
                consultasDoDia.add(consulta);
            }
            return consultasDoDia;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
    }

    public void cancelarConsulta(int idConsulta, String motivo) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("UPDATE consulta SET StatusRegistro = ?, MotivoCancelamento = ? WHERE Id = ?"));
            getPstm().setInt(1, 0);
            getPstm().setString(2, motivo);
            getPstm().setInt(3, idConsulta);
            getPstm().executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
    }

}
