package com.mycompany.clinica.ws.services.validation;

import com.mycompany.clinica.ws.exceptions.ExceptionEntedidadeNaoInformada;
import com.mycompany.clinica.ws.exceptions.ExceptionExiste;
import com.mycompany.clinica.ws.exceptions.ExceptionId;
import com.mycompany.clinica.ws.exceptions.ExceptionNumeroNegativo;
import com.mycompany.clinica.ws.model.*;
import com.mycompany.clinica.ws.repository.*;

public class ValidationId {

    public static final EstadoRepository estadoRepository = new EstadoRepository();
    public static final CidadeRepository cidadeRepository = new CidadeRepository();
    public static final EnderecoRepository enderecoRepository = new EnderecoRepository();
    public static final EspecialidadeRepository especialidadeRepository = new EspecialidadeRepository();
    public static final MedicoRepository medicoRepository = new MedicoRepository();
    public static final PacienteRepository pacienteRepository = new PacienteRepository();
    public static final PessoaRepository pessoaRepository = new PessoaRepository();

    public static boolean validaId(int id) throws ExceptionNumeroNegativo {
        if (id <= 0){
            throw new ExceptionNumeroNegativo("id");
        }
        return true;
    }

    public static <T> boolean validaExiste(T objeto, int id) throws ExceptionId, ExceptionEntedidadeNaoInformada {
        if (objeto == null){
            throw new ExceptionEntedidadeNaoInformada();
        }

        if (objeto instanceof EstadoModel){
            EstadoModel estadoEncontrado = estadoRepository.findByIdEstado(id);
            if (estadoEncontrado == null){
                throw new ExceptionId(id, "Estado");
            }
        }

        if (objeto instanceof CidadeModel){
            CidadeModel cidadeEncontrada = cidadeRepository.findByIdCidade(id);
            if (cidadeEncontrada == null){
                throw new ExceptionId(id, "Cidade");
            }
        }

        if (objeto instanceof EnderecoModel){
            EnderecoModel enderecoEncontrado = enderecoRepository.findByIdEndereco(id);
            if (enderecoEncontrado == null){
                throw new ExceptionId(id, "Endereco");
            }
        }

        if (objeto instanceof EspecialidadeModel){
            EspecialidadeModel especialidadeEncontrada = especialidadeRepository.findByIdEspecialidade(id);
            if (especialidadeEncontrada == null){
                throw new ExceptionId(id, "Especialidade");
            }
        }

        if (objeto instanceof PessoaModel){
            PessoaModel pessoaEncontrada = pessoaRepository.findByIdPessoa(id);
            if (pessoaEncontrada == null){
                throw new ExceptionId(id, "Pessoa");
            }
        }

        if (objeto instanceof MedicoModel){
            MedicoModel medicoEncontrado = medicoRepository.findByIdMedico(id);
            if (medicoEncontrado == null){
                throw new ExceptionId(id, "Medico");
            }
        }

        if (objeto instanceof PacienteModel){
            PacienteModel pacienteEncontrado = pacienteRepository.findByIdPaciente(id);
            if (pacienteEncontrado == null){
                throw new ExceptionId(id, "Paciente");
            }
        }
        return true;
    }

}
