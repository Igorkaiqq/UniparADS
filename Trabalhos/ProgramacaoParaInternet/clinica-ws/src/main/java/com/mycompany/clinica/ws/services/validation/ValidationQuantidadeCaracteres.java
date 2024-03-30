package com.mycompany.clinica.ws.services.validation;

import com.mycompany.clinica.ws.exceptions.ExceptionEntedidadeNaoInformada;
import com.mycompany.clinica.ws.exceptions.ExceptionQuantidadeDeCaracteres;
import com.mycompany.clinica.ws.model.*;

public class ValidationQuantidadeCaracteres {

    public static <T> boolean validaTamanhoCampo(T objeto) throws ExceptionEntedidadeNaoInformada, ExceptionQuantidadeDeCaracteres {

        if (objeto == null){
            throw new ExceptionEntedidadeNaoInformada();
        }

        if (objeto instanceof EstadoModel){
            EstadoModel estado = (EstadoModel) objeto;

            if (estado.getNome().length() > 100){
                throw new ExceptionQuantidadeDeCaracteres("Estaodo", "Nome", 100);
            }
            if (estado.getSigla().length() != 2){
                throw new ExceptionQuantidadeDeCaracteres("Estado", "Sigla", 2);
            }
        }

        if (objeto instanceof CidadeModel){
            CidadeModel cidade = (CidadeModel) objeto;

            if (cidade.getNome().length() > 100){
                throw new ExceptionQuantidadeDeCaracteres("Cidade", "Nome", 100);
            }
        }

        if (objeto instanceof EnderecoModel){
            EnderecoModel endereco = (EnderecoModel) objeto;

            if (endereco.getLogradouro().length() > 150){
                throw new ExceptionQuantidadeDeCaracteres("Endereço", "Logradouro", 150);
            }
            if (endereco.getCep().length() != 8){
                throw new ExceptionQuantidadeDeCaracteres("Endereço", "CEP", 8);
            }

            if (!endereco.getComplemento().isBlank()){
                if (endereco.getComplemento().length() > 100){
                    throw new ExceptionQuantidadeDeCaracteres("Endereço", "Complemento", 100);
                }
            }

            if (endereco.getBairro().length() > 100){
                throw new ExceptionQuantidadeDeCaracteres("Endereço", "Bairro", 100);
            }
        }

        if (objeto instanceof EspecialidadeModel){
            EspecialidadeModel especialidade = (EspecialidadeModel) objeto;

            if (especialidade.getNome().length() > 100){
                throw new ExceptionQuantidadeDeCaracteres("Especialidade", "Nome", 100);
            }
        }

        if (objeto instanceof PessoaModel){
            PessoaModel pessoa = (PessoaModel) objeto;

            if (pessoa.getNome().length() > 255){
                throw new ExceptionQuantidadeDeCaracteres("Pessoa", "Nome", 255);
            }
            if (pessoa.getCpf().length() != 11){
                throw new ExceptionQuantidadeDeCaracteres("Pessoa", "CPF", 11);
            }
            if (pessoa.getEmail().length() > 255){
                throw new ExceptionQuantidadeDeCaracteres("Pessoa", "Email", 255);
            }
            if (pessoa.getTelefone().length() > 11){
                throw new ExceptionQuantidadeDeCaracteres("Pessoa", "Telefone", 11);
            }
        }

        if (objeto instanceof MedicoModel){
            MedicoModel medico = (MedicoModel) objeto;

            if (medico.getCrm().length() > 9){
                throw new ExceptionQuantidadeDeCaracteres("Médico", "CRM", 9);
            }
        }
        return true;
    }

}
