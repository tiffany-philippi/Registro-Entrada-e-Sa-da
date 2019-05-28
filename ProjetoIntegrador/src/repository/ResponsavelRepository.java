package repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import exception.RepositoryException;
import model.Responsavel;

public class ResponsavelRepository {

	public void persistir(Responsavel responsavel) {
		
		String sql = "INSERT INTO";
		try (Connection conn = ConexaoBD.getConexao()){
			Statement st = conn.createStatement();
			st.execute(sql);
		} catch (SQLException e) {
			throw new RepositoryException(e);
		}
	}
	
	public Responsavel consultar(int id) {
		
		return null;
	}
	
	public void remover(int id) {
		
	}
	
	public void atualizar(Responsavel responsavel) {
		
	}
}
