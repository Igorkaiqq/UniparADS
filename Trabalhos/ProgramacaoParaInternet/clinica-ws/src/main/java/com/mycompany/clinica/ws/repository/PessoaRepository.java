package com.mycompany.clinica.ws.repository;

import com.mycompany.clinica.ws.infraestructure.Conexao;
import com.mycompany.clinica.ws.interfaces.PessoaInterface;
import com.mycompany.clinica.ws.model.EnderecoModel;
import com.mycompany.clinica.ws.model.PessoaModel;

import java.util.ArrayList;

public class PessoaRepository extends Conexao implements PessoaInterface {
    
    @Override
    public ArrayList<PessoaModel> findByNomePessoa(String nome) {
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * FROM pessoa WHERE nome = '" + nome + "';"
            );
            while(rs.next()){
                PessoaModel pessoa = new PessoaModel();
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setSexo(rs.getString("sexo"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setEndereco(new EnderecoModel(rs.getInt("endereco")));
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<PessoaModel> findByLikeNomePessoa(String nome) {

        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * FROM pessoa WHERE nome LIKE '%" + nome + "%';"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PessoaModel findByCPFPessoa(String cpf) {
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * FROM pessoa WHERE cpf = '" + cpf + "';"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<PessoaModel> listAllPessoa() {
        ArrayList<PessoaModel> listPessoas = new ArrayList();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT * FROM pessoa;"
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listPessoas;
    }

    @Override
    public PessoaModel findByIdPessoa(int id) {
        try {
            String query = "SELECT * FROM pessoa WHERE id = ?";
            this.conectar();
            pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return null;
    }

    @Override
    public PessoaModel inserirPessoa(PessoaModel pessoa) {
        
        try {
            String query = "INSERT INTO pessoa "
                    + "(nome, cpf, sexo, telefone, email, endereco)"
                    + " VALUES "
                    + "(?, ?, ?, ?, ?, ?)";
            this.conectar();
            pstm = con.prepareStatement(query);
            pstm.setString(1, pessoa.getNome());
            pstm.setString(2, pessoa.getCpf());
            pstm.setString(3, pessoa.getSexo());
            pstm.setString(4, pessoa.getTelefone());
            pstm.setString(5, pessoa.getEmail());
            pstm.setInt(6, pessoa.getEndereco().getId());
            pstm.execute();
            
            rs = pstm.getGeneratedKeys();
            rs.next();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return pessoa;
    }

    @Override
    public PessoaModel atualizarPessoa(PessoaModel pessoa) {

        try {
            String query = "UPDATE pessoa SET "
                    + "nome = ?, "
                    + "cpf = ?, "
                    + "sexo = ?, "
                    + "telefone = ?, "
                    + "email = ?, "
                    + "endereco = ?, "
                    + "WHERE id = ?";
            this.conectar();
            pstm = con.prepareStatement(query);
            pstm.setString(1, pessoa.getNome());
            pstm.setString(2, pessoa.getCpf());
            pstm.setString(3, pessoa.getSexo());
            pstm.setString(4, pessoa.getTelefone());
            pstm.setString(5, pessoa.getEmail());
            pstm.setInt(6, pessoa.getEndereco().getId());
            pstm.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return null;
    }

    public boolean deletarPessoa(int id) {
        try {
            String query = "DELETE FROM pessoa WHERE id = ?;";
            this.conectar();
            pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            pstm.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}
