package com.mycompany.clinica.ws.services.validation;

import com.mycompany.clinica.ws.exceptions.ExceptionCamposVazio;
import com.mycompany.clinica.ws.exceptions.ExceptionEntedidadeNaoInformada;
import com.mycompany.clinica.ws.model.*;

public class ValidationCampoVazio {

    public static <T> boolean validaCamposVazio(T objeto) throws ExceptionEntedidadeNaoInformada, ExceptionCamposVazio {

        if (objeto == null){
            throw new ExceptionEntedidadeNaoInformada();
        }

        if (objeto instanceof EstadoModel){
            EstadoModel estado = (EstadoModel) objeto;
            if (estado.getNome().isBlank() || estado.getSigla().isBlank()){
                throw new ExceptionCamposVazio("Estado");
            }
        }

        if (objeto instanceof CidadeModel){
            CidadeModel cidade = (CidadeModel) objeto;
            if (cidade.getNome().isBlank() || cidade.getEstado().getId() == 0){
                throw new ExceptionCamposVazio("Cidade");
            }
        }

        if (objeto instanceof EnderecoModel){
            EnderecoModel endereco = (EnderecoModel) objeto;
            if (endereco.getLogradouro().isBlank() || endereco.getCep().isBlank() || endereco.getCidade().getId() == 0){
                throw new ExceptionCamposVazio("Endereço");
            }
        }

        if (objeto instanceof EspecialidadeModel){
            EspecialidadeModel especialidade = (EspecialidadeModel) objeto;
            if (especialidade.getNome().isBlank()){
                throw new ExceptionCamposVazio("Especialidade");
            }
        }

        if (objeto instanceof PessoaModel){
            PessoaModel pessoa = (PessoaModel) objeto;
            if (pessoa.getNome().isBlank() || pessoa.getCpf().isBlank() || pessoa.getEndereco().getId() == 0){
                throw new ExceptionCamposVazio("Pessoa");
            }
        }

        if (objeto instanceof MedicoModel){
            MedicoModel medico = (MedicoModel) objeto;
            if (medico.getEspecialidade().getId() == 0 || medico.getPessoa().getId() == 0 || medico.getCrm().isBlank() || medico.getStatusRegistro() == null){
                throw new ExceptionCamposVazio("Médico");
            }
        }

        if (objeto instanceof PacienteModel){
            PacienteModel paciente = (PacienteModel) objeto;
            if (paciente.getPessoa().getId() == 0 || paciente.getStatusRegistro() == null){
                throw new ExceptionCamposVazio("Paciente");
            }
        }

        return true;
    }

}
