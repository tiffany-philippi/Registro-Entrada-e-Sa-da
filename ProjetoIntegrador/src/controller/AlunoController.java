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


	public void alterar(String matricula, String periodoAtual) throws SQLException {
		this.repository.atualizar(matricula, periodoAtual);
		
	}

	public Aluno consultar(String matricula) {
		return this.repository.consultar(matricula);
		
	}

	public void excluir(String matricula) throws SQLException {
		this.repository.remover(matricula);
		
	}

	
}
