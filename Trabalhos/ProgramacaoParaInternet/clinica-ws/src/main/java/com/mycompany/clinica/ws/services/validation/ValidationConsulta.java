package com.mycompany.clinica.ws.services.validation;

import com.mycompany.clinica.ws.model.ConsultaModel;
import com.mycompany.clinica.ws.repository.ConsultaRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ValidationConsulta {

    public final ConsultaRepository consultaRepository = new ConsultaRepository();

    public boolean validaAgendarConsulta(ConsultaModel consulta){

        LocalDateTime horarioConsulta = consulta.getDataHora();
        if (horarioConsulta.getHour() < 7 || horarioConsulta.getHour() >= 19) {
            throw new RuntimeException("A clínica não funciona neste horário.");
        }

        LocalDateTime agora = LocalDateTime.now();
        if (horarioConsulta.minusMinutes(30).isBefore(agora)) {
            throw new RuntimeException("A consulta deve ser agendada com pelo menos 30 minutos de antecedência.");
        }

        if (consulta.getPaciente().getStatusRegistro() == 0) {
            throw new RuntimeException("Não é possível agendar consulta com paciente inativo.");
        }
        if (consulta.getMedico().getStatusRegistro() == 0) {
            throw new RuntimeException("Não é possível agendar consulta com médico inativo.");
        }

        ArrayList<ConsultaModel> consultasDoDia = consultaRepository.listarConsultasDoDia(horarioConsulta.toLocalDate(), consulta.getPaciente().getId());
        if (!consultasDoDia.isEmpty()) {
            throw new RuntimeException("Já existe uma consulta marcada para este paciente no mesmo dia.");
        }

        consultasDoDia = consultaRepository.listarConsultasDoDia(horarioConsulta.toLocalDate(), consulta.getMedico().getId());
        for (ConsultaModel c : consultasDoDia) {
            if (c.getDataHora().equals(horarioConsulta)) {
                throw new RuntimeException("O médico já possui outra consulta agendada na mesma data/hora.");
            }
        }
        return true;
    }

    public ConsultaModel ValidaCancelarConsulta(int id, String motivo) {
        ConsultaModel consulta = consultaRepository.findByIdConsulta(id);
        if (consulta == null) {
            throw new RuntimeException("Consulta não encontrada.");
        }

        LocalDateTime horarioConsulta = consulta.getDataHora();
        if (horarioConsulta.minusHours(24).isBefore(LocalDateTime.now())) {
            throw new RuntimeException("A consulta só pode ser cancelada com pelo menos 24 horas de antecedência.");
        }
        return consulta;
    }

}
