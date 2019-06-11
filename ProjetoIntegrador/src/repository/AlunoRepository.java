package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exception.RepositoryException;
import model.Aluno;

public class AlunoRepository {

	public void persistir(Aluno aluno) throws SQLException {
		Connection conn = ConexaoBD.getConexao();
		String sql = "INSERT INTO alunos VALUES ('";
		sql = sql.concat(aluno.getMatricula() + "','");
		sql = sql.concat(aluno.getNome() + "','");
		sql = sql.concat(aluno.getTurma() + "','");
		sql = sql.concat(aluno.getEndereco() + "','");
		sql = sql.concat(aluno.getNome() + "','");
		System.out.println(sql);
		Statement stmt;
		ResultSet resultSet;
		
		try {
			Statement stmtInsert = conn.createStatement();
			stmtInsert.executeUpdate(sql);
		} catch (SQLException e) {
			throw new RepositoryException(e);
		}
	}

}
