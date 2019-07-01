package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exception.RepositoryException;
import model.Aluno;
import model.Responsavel;

public class AlunoRepository {

	public void persistir(Aluno aluno) throws SQLException {
		String sql = "INSERT INTO aluno VALUES ('"+ aluno.getMatricula() + "','" + aluno.getCpfResp() + "','" + 
					aluno.getTelefoneResp() + "','" + aluno.getNomeAluno() + "','" + aluno.getEnderecoAluno() + "','" + aluno.getEmailAluno() + 
					 "','" + aluno.getPeriodo() + "','" + aluno.getCursando() + "','"+  aluno.getTranspPublico() + "');";
//		System.out.println(sql);
		try (Connection conn = ConexaoBD.getConexao()) {
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
		
		String cpfResp = null;
		String telefoneResp = null;
		String nomeAluno = null;
		String enderecoAluno = null;
		String emailAluno = null;
		String periodo = null;
		String cursando = null;
		String transpPublico = null;
		
			while(resultSet.next()) {
				matricula = resultSet.getString("matricula");
				cpfResp = resultSet.getString("cpf_resp");
				telefoneResp = resultSet.getString("telefone_resp");
				nomeAluno = resultSet.getString("nome_aluno");
				enderecoAluno = resultSet.getString("endereco_aluno");
				emailAluno = resultSet.getString("email_aluno");
				periodo = resultSet.getString("cursando");
				cursando = resultSet.getString("periodo");
				transpPublico = resultSet.getString("transp_publico");

				aluno = new Aluno();
				System.out.println("Matrícula: " + matricula + "\nCPF do responsável: " + cpfResp + 
						"\nTelefone do responsável: " + telefoneResp + "\nNome do aluno: " + nomeAluno + "\nEndereço: " + enderecoAluno 
						+ "\nEmail: " + emailAluno +"\nPeríodo: " + periodo + "\nCursando: " + cursando + 
						"\nTransporte público: " + transpPublico +"\n");
			}
			
		} catch (SQLException e) {
			throw new RepositoryException(e);
		}
		return aluno;
		
		
	}
	
	public void remover(String matricula) throws SQLException {
		
		String sql = "DELETE FROM aluno WHERE matricula = '" + matricula + "';";
		Statement stmtUpdate;
		try (Connection conn = ConexaoBD.getConexao()){
			stmtUpdate = conn.createStatement();
			stmtUpdate.executeUpdate(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void atualizar(Aluno aluno) throws SQLException {
		String sql = "UPDATE aluno SET nome_aluno = '" + aluno.getNomeAluno() + "', endereco_aluno = '" + aluno.getEnderecoAluno() +
				"',email_aluno = '" + aluno.getEmailAluno() + "', periodo = '" + aluno.getPeriodo() + "', cursando = '" + aluno.getCursando() + 
				"', transp_publico = '"+  aluno.getTranspPublico() + "' WHERE matricula = '"+ aluno.getMatricula() + "';";
		Statement stmtUpdate;
		try (Connection conn = ConexaoBD.getConexao()){
			stmtUpdate = conn.createStatement();
			stmtUpdate.executeUpdate(sql);
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
