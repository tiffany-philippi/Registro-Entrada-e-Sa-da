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
		String sql = "INSERT INTO resp VALUES ('"+ responsavel.getCPFResp() + "','" + responsavel.getNome() + "','" + responsavel.getEndereco() + "','" + responsavel.getFoneResp() + "','" + responsavel.getEmail() + "');";
//		System.out.println(sql);
		try (Connection conn = ConexaoBD.getConexao()) {
			Statement stmtInsert = conn.createStatement();
			stmtInsert.executeUpdate(sql);
		} catch (SQLException e) {
			throw new RepositoryException(e);
		}
	}
	
	public Responsavel consultar(String cpf_resp) {
		Statement stmt = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM resp WHERE cpf_resp = '" + cpf_resp + "';";
		Responsavel resp = null;
		
		try (Connection conn = ConexaoBD.getConexao()) {
		stmt = conn.createStatement();
		resultSet = stmt.executeQuery(sql);
		
		String cpf = null;
		String nome = null;
		String endereco = null;
		String telefone = null;
		String email = null;
		
			while(resultSet.next()) {
				cpf = resultSet.getString("cpf_resp");
				nome = resultSet.getString("nome_resp");
				endereco = resultSet.getString("endereco_resp");
				telefone = resultSet.getString("telefone_resp");
				email = resultSet.getString("email_resp");

				resp = new Responsavel(cpf, nome, endereco, telefone, email);
				
			}
			
		} catch (SQLException e) {
			throw new RepositoryException(e);
		}
		return resp;
		
		
	}
	
	public void remover(String cpfResp) throws SQLException {
		Connection conn = ConexaoBD.getConexao();
		String sql = "DELETE FROM resp WHERE cpf_resp = '" + cpfResp + "';";
		Statement stmtUpdate;
		try {
			stmtUpdate = conn.createStatement();
			stmtUpdate.executeUpdate(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void atualizar(String nomeAtual, String cpfResp) throws SQLException {
		String sqlup = "UPDATE resp SET nome_resp = '" + nomeAtual + "' WHERE cpf_resp = '" + cpfResp + "';";
		Statement stmtUpdate;
		try (Connection conn = ConexaoBD.getConexao()){
			stmtUpdate = conn.createStatement();
			stmtUpdate.executeUpdate(sqlup);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return;
	}
	
	
}
