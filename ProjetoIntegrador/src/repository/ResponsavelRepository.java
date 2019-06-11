package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exception.RepositoryException;
import model.Aluno;
import model.Responsavel;

public class ResponsavelRepository {
 
	public void persistir(Responsavel responsavel) throws SQLException {
		Connection conn = ConexaoBD.getConexao();
		String sql = "INSERT INTO responsavel VALUES ('"+ resp.getCPFResp() + "','" + resp.getNome() + "','" + resp.getFoneResp() + "','" + resp.getEndereco() + "','" + resp.getEmail() + "');";
		System.out.println(sql);
		try {
			Statement stmtInsert = conn.createStatement();
			stmtInsert.executeUpdate(sql);
		} catch (SQLException e) {
			throw new RepositoryException(e);
		}
	}
	
	public Responsavel consultar(String cpf_resp, String nome_resp, String endereco_resp, String endereco_comercial, String telefone_resp, String telefone_comercial, String email_resp) {
		Statement stmt = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM responsavel WHERE cpf_resp = '" + cpf_resp + "';";
		
		try (Connection conn = ConexaoBD.getConexao()){
		stmt = conn.createStatement();
		resultSet = stmt.executeQuery(sql);
		
		String cpf = null;
		String nome = null;
		String endereco = null;
		String telefone = null;
		String email = null;
		
			while(resultSet.next()) {
				cpf = resultSet.getString(cpf_resp);
				nome = resultSet.getString(nome_resp);
				endereco = resultSet.getString(endereco_resp);
				telefone = resultSet.getString(telefone);
				email = resultSet.getString(email_resp);

				Responsavel resp = new Responsavel(cpf, nome, endereco, telefone_resp, email);
				System.out.println("CPF: " + cpf + "\nNome: " + nome + 
						"\nEndereço: " + endereco + "\nTelefone: " + telefone 
						+ "\nEmail: " + email);
			}
			
		} catch (SQLException e) {
			throw new RepositoryException(e);
		}
		return sql;
		
		
	}
	
	public void remover(String cpfResp) throws SQLException {
		Connection conn = ConexaoBD.getConexao();
		String sql = "DELETE FROM responsavel WHERE cpfResp = '" + cpfResp + "';";
		Statement stmtUpdate;
		try {
			stmtUpdate = conn.createStatement();
			stmtUpdate.executeUpdate(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void atualizar(Responsavel resp) throws SQLException {
		Connection conn = ConexaoBD.getConexao();
		String sql = "UPDATE responsavel SET nome_resp = '" + nomeAtual + "' WHERE cpf_resp = '" + resp + "';";
		Statement stmtUpdate;
		try {
			stmtUpdate = conn.createStatement();
			stmtUpdate.executeUpdate(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
