package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exception.RepositoryException;
import model.Aluno;
import model.Periodo;
import model.Responsavel;
import model.SimNao;

public class AlunoRepository {
	
	public void persistir(Aluno aluno) throws SQLException {
		Connection conn = ConexaoBD.getConexao();
		String sql = "INSERT INTO aluno VALUES ('" + aluno.getMatricula() + "','" + aluno.getCpf_resp() + "','" + 
				aluno.getTelefone_resp() + "','" + aluno.getNome() + "','" + aluno.getEndereco() + "','" + aluno.getEmail() + "','" +
				aluno.getPeriodo() + "','" + aluno.getCursando() + "','" + aluno.getTransPublico() + "');";

		try {
			Statement stmtInsert = conn.createStatement();
			stmtInsert.executeUpdate(sql);
		} catch (SQLException e) {
			throw new RepositoryException(e);
		}
	}
	
	public Aluno consultar(String matricula) {
		Statement stmt = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM aluno WHERE matricula = '" + matricula + "';";
		Aluno aluno = null;
		
		try (Connection conn = ConexaoBD.getConexao()) {
		stmt = conn.createStatement();
		resultSet = stmt.executeQuery(sql);
		
		String matriculaAluno = null;
		String cpf_resp = null;
		String telefone_resp = null;	
		String nome_aluno = null;	
		String endereco_aluno = null;	
		String email_aluno = null;	
		String periodoAluno = null;
		Periodo periodo = null;
		String cursandoAluno = null;
		SimNao cursando = null;
		String transp_publicoAluno = null;
		SimNao transp_public = null;
		
			while(resultSet.next()) {
				matriculaAluno = resultSet.getString("matricula");
				cpf_resp = resultSet.getString("cpf_resp");
				telefone_resp = resultSet.getString("telefone_resp");
				nome_aluno = resultSet.getString("nome_aluno");
				endereco_aluno = resultSet.getString("endereco_aluno");
				email_aluno = resultSet.getString("email_aluno");
				periodoAluno = resultSet.getString("periodo");
				cursandoAluno = resultSet.getString("cursando");
				transp_publicoAluno = resultSet.getString("transp_publico");

				switch (periodoAluno) {
					case "MATUTINO": 
						periodo = Periodo.MATUTINO; 
						break;
					case "VESPERTINO": 
						periodo = Periodo.VESPERTINO; 
						break;
					case "INTEGRAL": 
						periodo = Periodo.INTEGRAL; 
						break;
					default: 
						periodo = null; 				
				} 
				
				switch (cursandoAluno) {
					case "SIM": 
						cursando = SimNao.SIM; 
						break;
					case "NÃO": 
						cursando = SimNao.NÃO; 
						break;
					default: 
						cursando = null;
				}
				
				switch (transp_publicoAluno) {
					case "SIM": 
						transp_public = SimNao.SIM; 
						break;
					case "NÃO": 
						transp_public = SimNao.NÃO; 
						break;
					default: 
						transp_public = null;
				}
						
				aluno =  new Aluno(matriculaAluno, cpf_resp, telefone_resp, nome_aluno, endereco_aluno, email_aluno, periodo, cursando, transp_public );
						
			}
			
		} catch (SQLException e) {
			throw new RepositoryException(e);
		}
		return aluno;
		
		
	}
	
	
	public void atualizar(String matricula, String periodoAtual) throws SQLException {
		String sqlup = "UPDATE aluno SET periodo = '"+ periodoAtual + "'  WHERE matricula = '" + matricula + "';";
		Statement stmtUpdate;
		try (Connection conn = ConexaoBD.getConexao()){
			stmtUpdate = conn.createStatement();
			stmtUpdate.executeUpdate(sqlup);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void remover(String matricula) throws SQLException {
		Connection conn = ConexaoBD.getConexao();
		String sql = "DELETE FROM aluno WHERE matricula = '" + matricula + "';";
		Statement stmtUpdate;
		try {
			stmtUpdate = conn.createStatement();
			stmtUpdate.executeUpdate(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	public void alterar(Aluno aluno) throws SQLException {
		Connection conn = ConexaoBD.getConexao();
		String sql = "UPDATE aluno SET nome_aluno = '" + aluno.getNome() + "', endereco_aluno = '" + aluno.getEndereco() + 
				"', email_aluno = '" + aluno.getEmail() + "', periodo = '" + aluno.getPeriodo() + "', cursando = '" + aluno.getCursando() + 
				"', transp_publico = '" + aluno.getTransPublico() + "' WHERE matricula = '" + aluno.getMatricula() + "';";
		Statement stmtUpdate;
		try {
			stmtUpdate = conn.createStatement();
			stmtUpdate.executeUpdate(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}		
	}
	
	

}
