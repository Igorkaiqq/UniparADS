package com.mycompany.clinica.ws.repository;

import com.mycompany.clinica.ws.Enums.SexoEnum;
import com.mycompany.clinica.ws.infraestructure.Conexao;
import com.mycompany.clinica.ws.interfaces.PessoaInterface;
import com.mycompany.clinica.ws.model.PessoaModel;

import java.util.ArrayList;

public class PesssoaRepository extends Conexao {
//    @Override
//    public ArrayList<PessoaModel> findByNomePessoa(String nome) {
//        return null;
//    }
//
//    @Override
//    public ArrayList<PessoaModel> findByLikeNomePessoa(String nome) {
//        return null;
//    }
//
//    @Override
//    public PessoaModel findByCPFPessoa(String cpf) {
//        return null;
//    }

    public ArrayList<PessoaModel> listAllPessoa() {
        ArrayList<PessoaModel> listaPessoa = new ArrayList<>();
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("SELECT * FROM pessoa"));
            getPstm().executeQuery();
            while(getRs().next()){
                PessoaModel pessoa = new PessoaModel();
                pessoa.setId(getRs().getInt("Id"));
                pessoa.setNome(getRs().getString("Nome"));
                pessoa.setCpf(getRs().getString("CPF"));
                pessoa.setSexo(SexoEnum.valueOf(getRs().getString("Sexo")));
                pessoa.setEmail(getRs().getString("Email"));
                pessoa.setTelefone(getRs().getString("Telefone"));
                pessoa.getEndereco().setId(getRs().getInt("EnderecoId"));
                listaPessoa.add(pessoa);
            }
            return listaPessoa;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return null;
    }


    public PessoaModel findByIdPessoa(int id) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("SELECT * FROM pessoa WHERE Id = ?"));
            getPstm().executeQuery();
            if (getRs().first()){
                PessoaModel pessoa = new PessoaModel();
                pessoa.setId(getRs().getInt("Id"));
                pessoa.setNome(getRs().getString("Nome"));
                pessoa.setCpf(getRs().getString("CPF"));
                pessoa.setSexo(SexoEnum.valueOf(getRs().getString("Sexo")));
                pessoa.setEmail(getRs().getString("Email"));
                pessoa.setTelefone(getRs().getString("Telefone"));
                pessoa.getEndereco().setId(getRs().getInt("EnderecoId"));
                return pessoa;
            }
        } catch (Exception e){
            e.printStackTrace();
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
            getPstm().setString(5, pessoa.getSexo().getSexo());
            getPstm().setInt(6, pessoa.getEndereco().getId());
            getPstm().executeUpdate();
            return pessoa;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return null;
    }

    public PessoaModel atualizarPessoa(PessoaModel pessoa) {
        try {
            this.conectar();
            setPstm(getCon().prepareStatement("UPDATE  pessoa " +
                    "SET Nome = ?, " +
                    "SET Email = ?, " +
                    "SET Telefone = ?, " +
                    "SET Cpf = ?, " +
                    "SET Sexo = ?, " +
                    "SET EnderecoId = ? " +
                    "WHERE Id = ?"));
            getPstm().setString(1, pessoa.getNome());
            getPstm().setString(2, pessoa.getEmail());
            getPstm().setString(3, pessoa.getTelefone());
            getPstm().setString(4, pessoa.getCpf());
            getPstm().setString(5, pessoa.getSexo().getSexo());
            getPstm().setInt(6, pessoa.getEndereco().getId());
            getPstm().setInt(7, pessoa.getId());
            getPstm().executeUpdate();
            return pessoa;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return null;
    }


    public void deletarPessoa(int id) {
        try {
            setPstm(getCon().prepareStatement("DELETE FROM pessoa where Id = ?"));
            getPstm().setInt(1, id);
            getPstm().executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
    }
}
