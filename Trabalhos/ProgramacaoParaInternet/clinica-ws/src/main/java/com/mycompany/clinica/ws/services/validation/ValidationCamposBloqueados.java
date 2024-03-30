package com.mycompany.clinica.ws.services.validation;

import com.mycompany.clinica.ws.exceptions.ExceptionCampoBloqueadoUpdate;
import com.mycompany.clinica.ws.exceptions.ExceptionEntedidadeNaoInformada;
import com.mycompany.clinica.ws.model.MedicoModel;
import com.mycompany.clinica.ws.model.PacienteModel;
import com.mycompany.clinica.ws.repository.MedicoRepository;
import com.mycompany.clinica.ws.repository.PacienteRepository;

public class ValidationCamposBloqueados {
    private static final MedicoRepository medicoRepository = null;
    private static final PacienteRepository pacienteRepository = null;

        public static <T> boolean validaCamposBloqueados(T objeto) throws ExceptionEntedidadeNaoInformada, ExceptionCampoBloqueadoUpdate {

            if (objeto == null){
                throw new ExceptionEntedidadeNaoInformada();
            }

            if (objeto instanceof MedicoModel){
                MedicoModel medico = (MedicoModel) objeto;
                MedicoModel medicoAtual = (MedicoModel) medicoRepository.findByIdMedico(medico.getId());

                if (medicoAtual == null) {
                    throw new IllegalArgumentException("Médico não encontrado");
                }

                if (medicoAtual.getPessoa().getEmail().equals(medico.getPessoa().getEmail())) {
                    throw new ExceptionCampoBloqueadoUpdate("Médico", "Nome");
                }

                if (medicoAtual.getCrm().equals(medico.getCrm())) {
                    throw new ExceptionCampoBloqueadoUpdate("Médico", "CRM");
                }

                if (medicoAtual.getEspecialidade().getNome().equals(medico.getEspecialidade().getNome())) {
                    throw new ExceptionCampoBloqueadoUpdate("Médico", "Especialidade");
                }

                if (medicoAtual.getPessoa().getCpf().equals(medico.getPessoa().getCpf())) {
                    throw new ExceptionCampoBloqueadoUpdate("Médico", "CPF");
                }
            }

            if (objeto instanceof PacienteModel){
                PacienteModel paciente = (PacienteModel) objeto;
                PacienteModel pacienteAtual = (PacienteModel) pacienteRepository.findByIdPaciente(paciente.getId());

                if (pacienteAtual == null) {
                    throw new IllegalArgumentException("Paciente não encontrado");
                }

                if (pacienteAtual.getPessoa().getEmail().equals(paciente.getPessoa().getEmail())) {
                    throw new ExceptionCampoBloqueadoUpdate("Paciente", "Nome");
                }

                if (pacienteAtual.getPessoa().getCpf().equals(paciente.getPessoa().getCpf())) {
                    throw new ExceptionCampoBloqueadoUpdate("Paciente", "CPF");
                }
            }
            return true;
        }

}
