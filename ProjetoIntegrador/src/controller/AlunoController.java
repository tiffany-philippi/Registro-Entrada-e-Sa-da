package controller;

import java.sql.SQLException;

import model.Aluno;
import repository.AlunoRepository;

public class AlunoController {
	
	private AlunoRepository repository;
	
	public AlunoController() {
		this.repository = new AlunoRepository();
	}

/**
 * Método para salvar o Aluno no repositório.
 * @param aluno Novo aluno
 * @throws SQLException 
 */

	public void persistir(Aluno aluno) throws SQLException {
		this.repository.persistir(aluno);
	}


	public void alterar(Aluno aluno) throws SQLException {
		// TODO Auto-generated method stub
		this.repository.atualizar(aluno);
	}

	public void consultar(String matricula){
		// TODO Auto-generated method stub
	}

	public void excluir(String matricula) throws SQLException {
		// TODO Auto-generated method stub
		this.repository.remover(matricula);
	}

}
