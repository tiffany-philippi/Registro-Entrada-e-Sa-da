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
		int table = Integer.parseInt(sc.nextLine());
		
		if (table == 1) {
			System.out.println("Você deseja inserir um novo responsável? (1- SIM, 2- NÃO)");
			int esc = Integer.parseInt(sc.nextLine());
			if (esc == 1) {
				inserirResponsavel();
			} else {
				System.out.println("Digite o CPF do responsável.");
				String cpf = sc.nextLine();
				System.out.println("Respectivamente, digite 1, 2 ou 3, caso queira consultar, remover ou alterar um responsavel. Caso queira voltar ao menu anterior, digite 0.");
				int escolha = Integer.parseInt(sc.nextLine());
				System.out.println(escolha);
				switch (escolha) {
//					case 0:
//						voltar ao menu anterior;
//						break;
					case 1:
						consultarResp(cpf);
						break;
					case 2:
						exlcuirResp(cpf);
						System.out.println("Usuário removido");
						break;
					case 3:
						System.out.println("Qual informação você deseja alterar? (1- NOME, 2- TELEFONE, 3- EMAIL)");
						int update = Integer.parseInt(sc.nextLine());
						if (update == 1) {
							System.out.print("Digite o nome atual: ");
							String atualNome = sc.next();
							System.out.print("Digite o novo nome: ");
							String updateNome = sc.next();
							alterarRespNome(atualNome, updateNome);
						} else if (update == 2) {
							System.out.print("Digite o telefone atual: ");
							String atualFone = sc.next();
							System.out.print("Digite o telefone nome: ");
							String updateFone = sc.next();
							alterarRespFone(atualFone, updateFone);
						} else if (update == 3) {
							System.out.print("Digite o email atual: ");
							String atualEmail = sc.next();
							System.out.print("Digite o novo email: ");
							String updateEmail = sc.next();
							alterarRespEmail(atualEmail, updateEmail);
						}
						break;
						default:
							System.out.println("Digite uma opção válida.");
				}
			}
			
		} else if (table == 2) {
			executarAluno();
			System.out.println("Caso deseje remover um aluno, digite sua matrícula. Caso não, digite 'sair'.");
			String usuarioDesj = sc.nextLine();
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
	
	
	protected static void inserirResponsavel() throws SQLException {
		//criar o objeto Responsável
		Responsavel resp = new Responsavel();
		ResponsavelController contr = new ResponsavelController();
		contr.persistir(resp);
	}
	
	private static void consultarResp(String cpfResp) {
		ResponsavelController contr = new ResponsavelController();
		contr.consultar(cpfResp);
	}

	private static void alterarRespNome(String atualNome, String updateNome) {
		ResponsavelController contr = new ResponsavelController();
		Responsavel resp = contr.consultar(atualNome);
		resp.setNomeResp(updateNome);
	}
	private static void alterarRespFone(String atualFone, String updateFone) {
		ResponsavelController contr = new ResponsavelController();
		Responsavel resp = contr.consultar(atualFone);
		resp.setNomeResp(atualFone);
	}
	private static void alterarRespEmail(String atualEmail, String updateEmail) {
		ResponsavelController contr = new ResponsavelController();
		Responsavel resp = contr.consultar(atualEmail);
		resp.setNomeResp(atualEmail);
	}

	private static void exlcuirResp(String cpfResp) throws SQLException {
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
