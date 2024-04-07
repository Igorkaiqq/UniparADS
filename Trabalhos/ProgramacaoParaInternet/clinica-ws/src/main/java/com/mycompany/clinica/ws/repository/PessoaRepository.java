package com.mycompany.clinica.ws.repository;

import com.mycompany.clinica.ws.infraestructure.Conexao;
import com.mycompany.clinica.ws.model.EnderecoModel;
import com.mycompany.clinica.ws.model.PessoaModel;

import java.util.ArrayList;

public class PessoaRepository extends Conexao {

    public ArrayList<PessoaModel> listAllPessoa() {
        ArrayList<PessoaModel> listaPessoa = new ArrayList<>();
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("SELECT * FROM pessoa ORDER BY Nome ASC"));
            setRs(getPstm().executeQuery());
            while(getRs().next()){
                PessoaModel pessoa = new PessoaModel();
                pessoa.setId(getRs().getInt("Id"));
                pessoa.setNome(getRs().getString("Nome"));
                pessoa.setCpf(getRs().getString("CPF"));
                pessoa.setSexo((getRs().getString("Sexo")));
                pessoa.setEmail(getRs().getString("Email"));
                pessoa.setTelefone(getRs().getString("Telefone"));
                EnderecoModel endereco = new EnderecoModel();
                endereco.setId(getRs().getInt("EnderecoId"));
                pessoa.setEndereco(endereco);
                listaPessoa.add(pessoa);
            }
            return listaPessoa;
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
    }


    public PessoaModel findByIdPessoa(int id) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("SELECT * FROM pessoa WHERE Id = ?"));
            getPstm().setInt(1, id);
            setRs(getPstm().executeQuery());
            if (getRs().next()){
                PessoaModel pessoa = new PessoaModel();
                pessoa.setId(getRs().getInt("Id"));
                pessoa.setNome(getRs().getString("Nome"));
                pessoa.setCpf(getRs().getString("CPF"));
                pessoa.setSexo((getRs().getString("Sexo")));
                pessoa.setEmail(getRs().getString("Email"));
                pessoa.setTelefone(getRs().getString("Telefone"));
                EnderecoModel endereco = new EnderecoModel();
                endereco.setId(getRs().getInt("EnderecoId"));
                pessoa.setEndereco(endereco);
                return pessoa;
            }
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
        return null;
    }


    public PessoaModel inserirPessoa(PessoaModel pessoa) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("INSERT INTO pessoa " +
                    "(Nome, Email, Telefone, Cpf, Sexo, EnderecoId)" +
                    " VALUES " +
                    "(?, ?, ?, ?, ?, ?)"));
            getPstm().setString(1, pessoa.getNome());
            getPstm().setString(2, pessoa.getEmail());
            getPstm().setString(3, pessoa.getTelefone());
            getPstm().setString(4, pessoa.getCpf());
            getPstm().setString(5, pessoa.getSexo());
            getPstm().setInt(6, pessoa.getEndereco().getId());
            getPstm().executeUpdate();
            return pessoa;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
    }

    public PessoaModel atualizarPessoa(PessoaModel pessoa) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("UPDATE  pessoa " +
                    "SET Nome = ?, " +
                    "Email = ?, " +
                    "Telefone = ?, " +
                    "Cpf = ?, " +
                    "Sexo = ?, " +
                    "EnderecoId = ? " +
                    "WHERE Id = ?"));
            getPstm().setString(1, pessoa.getNome());
            getPstm().setString(2, pessoa.getEmail());
            getPstm().setString(3, pessoa.getTelefone());
            getPstm().setString(4, pessoa.getCpf());
            getPstm().setString(5, pessoa.getSexo());
            getPstm().setInt(6, pessoa.getEndereco().getId());
            getPstm().setInt(7, pessoa.getId());
            getPstm().executeUpdate();
            return pessoa;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
    }


    public void deletarPessoa(int id) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("DELETE FROM pessoa where Id = ?"));
            getPstm().setInt(1, id);
            getPstm().executeUpdate();
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        } finally {
            this.fecharConexao();
        }
    }
}
