package com.mycompany.clinica.ws.services.validation;

import com.mycompany.clinica.ws.exceptions.ExceptionCampoBloqueadoUpdate;
import com.mycompany.clinica.ws.exceptions.ExceptionEntedidadeNaoInformada;
import com.mycompany.clinica.ws.model.MedicoModel;
import com.mycompany.clinica.ws.model.PacienteModel;
import com.mycompany.clinica.ws.model.PessoaModel;
import com.mycompany.clinica.ws.repository.MedicoRepository;
import com.mycompany.clinica.ws.repository.PacienteRepository;
import com.mycompany.clinica.ws.repository.PessoaRepository;

public class ValidationCamposBloqueados {
    private static final MedicoRepository medicoRepository = null;
    private static final PacienteRepository pacienteRepository = null;
    private static final PessoaRepository pessoaRepository = null;

        public static <T> boolean validaCamposBloqueados(T objeto) throws ExceptionEntedidadeNaoInformada, ExceptionCampoBloqueadoUpdate {

            if (objeto == null){
                throw new ExceptionEntedidadeNaoInformada();
            }

            if (objeto instanceof PessoaModel){
                PessoaModel pessoa = (PessoaModel) objeto;
                PessoaModel pessoaAtual = (PessoaModel) pessoaRepository.findByIdPessoa(pessoa.getId());

                if (pessoaAtual == null) {
                    throw new IllegalArgumentException("Pessoa não encontrada");
                }

                if (pessoaAtual.getEmail().equals(pessoa.getEmail())) {
                    throw new ExceptionCampoBloqueadoUpdate("Pessoa", "Nome");
                }

                if (pessoaAtual.getCpf().equals(pessoa.getCpf())) {
                    throw new ExceptionCampoBloqueadoUpdate("Pessoa", "CPF");
                }
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
