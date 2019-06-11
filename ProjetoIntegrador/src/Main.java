import java.sql.SQLException;
import java.util.Scanner;

import controller.AlunoController;
import controller.ResponsavelController;
import model.Aluno;
import model.Responsavel;
import repository.ConexaoBD;

public class Main {

	public static void main(String[] args0) throws SQLException {
		ConexaoBD.getConexao();
		
		Scanner sc = new Scanner(System.in);
		//RESPONSÁVEL
		System.out.println("Deseja atuar em qual tabela do banco de dados? (1- Responsavel, 2- Aluno)");
		int table = sc.nextInt();
		String usuarioDesj;
		
		if (table == 1) {
			executarResponsavel();
			System.out.println("Caso deseje remover um responsável, digite seu CPF. Caso não, digite 'sair'.");
			usuarioDesj = sc.nextLine();
			if (usuarioDesj != "sair") {
				exlcuirResp(usuarioDesj);
			}
			System.out.println("Caso deseje alterar um responsável, digite seu CPF. Caso não, digite 'sair'.");
			usuarioDesj = sc.nextLine();
			if (usuarioDesj != "sair") {
				System.out.println("Insira o nome atual.");
				String nomeAtual = sc.nextLine();
				alterarResp(usuarioDesj, nomeAtual);
			}
			System.out.println("Caso deseje consultar os dados de um responsável, digite seu CPF. Caso não, digite 'sair'.");
			usuarioDesj = sc.nextLine();
			if (usuarioDesj != "sair") {
				consultarResp(usuarioDesj);
			}
		} else if (table == 2) {
			executarAluno();
			System.out.println("Caso deseje remover um aluno, digite sua matrícula. Caso não, digite 'sair'.");
			usuarioDesj = sc.nextLine();
			if (usuarioDesj != "sair") {
				exlcuirAluno(usuarioDesj);
			}
			System.out.println("Caso deseje alterar um aluno, digite sua matrícula. Caso não, digite 'sair'.");
			usuarioDesj = sc.nextLine();
			if (usuarioDesj != "sair") {
				System.out.println("Insira a turma atual.");
				String turmaAtual = sc.nextLine();
				System.out.println("Insira o período atual.");
				String periodoAtual = sc.nextLine();
				alterarAluno(usuarioDesj, turmaAtual, periodoAtual);
			}
			System.out.println("Caso deseje consultar os dados de um aluno, digite sua matrícula. Caso não, digite 'sair'.");
			usuarioDesj = sc.nextLine();
			if (usuarioDesj != "sair") {
				consultarAluno(usuarioDesj);
			}
		}
	
		sc.close();
	}
	
	
	protected static void executarResponsavel() throws SQLException {
		//criar o objeto Responsável
		Responsavel resp = new Responsavel("102.391.293-12", "Carlos Alberto Gomes", "Rua João Carvalho", "48991284720", "calbg@outlook.com");
		ResponsavelController contr = new ResponsavelController();
		contr.persistir(resp);
	}
	
	private static void consultarResp(String cpfResp) {
		ResponsavelController contr = new ResponsavelController();
		contr.consultar(cpfResp);
	}

	private static void alterarResp(String cpfResp, String nomeAtual) {
		ResponsavelController contr = new ResponsavelController();
		contr.alterar(cpfResp, nomeAtual);
	}

	private static void exlcuirResp(String cpfResp) {
		ResponsavelController contr = new ResponsavelController();
		contr.excluir(cpfResp);
	}
	
	
	protected static void executarAluno() throws SQLException {
		//criar o objeto Aluno
		Aluno aluno = new Aluno("2014-101","2014101008", "102.391.293-12", "48991284720", "2014-101", "Maria Fernanda Gomes","Rua João Carvalho", "nandamaria@gmail.com", "Matutino", "NÃO", "SIM");
		AlunoController control = new AlunoController();
		control.persistir(aluno);
	}
	private static void consultarAluno(String matricula) {
		AlunoController control = new AlunoController();
		control.consultar(matricula);
	}

	private static void alterarAluno(String matricula, String turmaAtual, String periodoAtual) {
		AlunoController control = new AlunoController();
		control.alterar(matricula, turmaAtual, periodoAtual);
	}

	private static void exlcuirAluno(String matricula) {
		AlunoController control = new AlunoController();
		control.excluir(matricula);
	}
}
