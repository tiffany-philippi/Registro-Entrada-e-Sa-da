package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.Periodo;
import model.Registro;
import model.SimNao;

public class RelatorioRepository {

public List<Aluno> RelatorioAluno() {

		

		List<Aluno> alunos = new ArrayList<Aluno>();
		
		String sql = "SELECT * FROM aluno"; 
		ResultSet resultSet = null;
		Aluno aluno = null;
		try (Connection conn = ConexaoBD.getConexao()) {

			Statement stmt = conn.createStatement();
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
			
			while (resultSet.next()) {
				matriculaAluno = resultSet.getString("matricula");
				cpf_resp = resultSet.getString("cpf_resp");
				telefone_resp = resultSet.getString("telefone_resp");
				nome_aluno = resultSet.getString("nome_aluno");
				endereco_aluno = resultSet.getString("endereco_aluno");
				email_aluno = resultSet.getString("email_aluno");
				periodoAluno = resultSet.getString("periodo");
				cursandoAluno = resultSet.getString("cursando");
				transp_publicoAluno = resultSet.getString("transp_publico");

				aluno = new Aluno(matriculaAluno, cpf_resp, telefone_resp, nome_aluno, endereco_aluno, email_aluno, periodo, cursando, transp_public);
				
				aluno.setMatricula(matriculaAluno);
				
				alunos.add(aluno);
				
			}
	}catch (SQLException ex) {
		ex.printStackTrace();
		ex.getMessage();
	}
		return alunos;

		}
	
	
	// RELATORIO ENTRADA E SAIDA DE ALUNOS
	
//	public List<Registro> Registros() {
//
//		
//
//		List<Registro> registros = new ArrayList<Registro>();
//		
//		String sql = "SELECT alunos.Matricula, Nome, Sexo, Data_Nascimento, CPF, Endereco, telefone_alunos.numero, Turma.descricao " +
//		"FROM alunos " +
//		"INNER JOIN telefone_alunos ON telefone_alunos.matricula = alunos.matricula " +
//		"INNER JOIN Turma ON Turma.Cd_Turma = alunos.Cd_Turma ";
//
//		ResultSet rs = null;
//		Registro registro = null;
//		try (Connection conn = ConexaoBD.getConexao()) {
//
//			Statement stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
//
//			while (rs.next()) {
//				
//				int matricula = rs.getInt("alunos.Matricula");
//				String nome = rs.getString("Nome");
//				String sexo = rs.getString("Sexo");
//				String telefone = rs.getString("telefone_alunos.numero");
//				String cpf = rs.getString("CPF");
//				String endereco = rs.getString("Endereco");
//				String turma = rs.getString("Turma.descricao");
//				
//
//
//				aluno = new Aluno(nome, sexo, data, cpf, endereco, telefone);
//				
//				aluno.setMatricula(matricula);
//				aluno.setTurmaDesc(turma);
//				
//				registros.add(registro);
//				
//			}
//	}catch (SQLException ex) {
//		ex.printStackTrace();
//		ex.getMessage();
//	}
//		return alunos;
//
//		}
}
