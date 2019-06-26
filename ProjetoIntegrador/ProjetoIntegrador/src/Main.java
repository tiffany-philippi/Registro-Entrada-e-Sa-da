// Arrumar hora: command line -- SET GLOBAL TIME_ZONE = '-3:00';
import java.sql.SQLException;
import java.util.Scanner;

import controller.AlunoController;
import controller.ResponsavelController;
import model.Aluno;
import model.Periodo;
import model.Responsavel;
import repository.ConexaoBD;

public class Main {

	public static void main(String[] args0) throws SQLException {
		ConexaoBD.getConexao();
		
		Scanner sc = new Scanner(System.in);
//		====================================================================================================================================================
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
						System.out.println("Responsável removido");
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
			
//			====================================================================================================================================================
			//ALUNO
		} else if (table == 2) {
			System.out.println("Você deseja inserir um novo aluno? (1- SIM, 2- NÃO)");
			int esc = Integer.parseInt(sc.nextLine());
			if (esc == 1) {
				inserirAluno();
			} else {
				System.out.println("Digite a matricula do aluno.");
				String matricula = sc.nextLine();
				System.out.println("Respectivamente, digite 1, 2 ou 3, caso queira consultar, remover ou alterar um aluno. Caso queira voltar ao menu anterior, digite 0.");
				int escolha = Integer.parseInt(sc.nextLine());
				System.out.println(escolha);
				switch (escolha) {
//					case 0:
//						voltar ao menu anterior;
//						break;
					case 1:
						consultarAluno(matricula);
						break;
					case 2:
						exlcuirAluno(matricula);
						System.out.println("Aluno removido");
						break;
					case 3:
						System.out.println("Qual informação você deseja alterar? (1- NOME, 2- EMAIL, 3- PERÍODO, 4- CURSANDO, 5- TRANSP. PÚBLICO)");
						int update = Integer.parseInt(sc.nextLine());
						if (update == 1) {
							System.out.print("Digite o nome atual: ");
							String atualNome = sc.next();
							System.out.print("Digite o novo nome: ");
							String updateNome = sc.next();
							alterarAlunoNome(atualNome, updateNome);
						} else if (update == 2) {
							System.out.print("Digite o email atual: ");
							String atualEmail = sc.next();
							System.out.print("Digite o novo email: ");
							String updateEmail = sc.next();
							alterarAlunoEmail(atualEmail, updateEmail);
						} else if (update == 3) {
							System.out.print("Digite o período atual: ");
							String atualPeriodo = sc.next();
							System.out.print("Digite o novo período: ");
							String updatePeriodo = sc.next();
							alterarAlunoPeriodo(atualPeriodo, updatePeriodo);
						} else if (update == 4) {
							System.out.print("Digite o status atual (cusando - sim/não: ");
							String atualCursando = sc.next();
							System.out.print("Digite o novo status (cusando - sim/não: ");
							String updateCursando = sc.next();
							alterarAlunoCursando(atualCursando, updateCursando);
						} else if (update == 5) {
							System.out.print("Digite se usa ou não transporte público: ");
							String atualTranspp = sc.next();
							System.out.print("Digite se passa ou deixa de usar transporte público: ");
							String updateTranspp = sc.next();
							alterarAlunoTranspp(atualTranspp, updateTranspp);
						}
						break;
						default:
							System.out.println("Digite uma opção válida.");
				}
			}
	
			sc.close();
		}
	}
//	====================================================================================================================================================
	//RESPONSAVEL
	
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
	
//	====================================================================================================================================================
	//ALUNO
	
	protected static void inserirAluno() throws SQLException {
		//criar o objeto Aluno
		Aluno aluno = new Aluno();
		AlunoController control = new AlunoController();
		control.persistir(aluno);
	}
	private static void consultarAluno(String matricula) {
		AlunoController control = new AlunoController();
		control.consultar(matricula);
	}

	private static void exlcuirAluno(String matricula) {
		AlunoController control = new AlunoController();
		control.excluir(matricula);
	}

	private static void alterarAlunoNome(String atualNome, String updateNome) {
		AlunoController contr = new AlunoController();
		Aluno aluno = contr.consultar(atualNome);
		aluno.setNomeAluno(updateNome);
	}

	private static void alterarAlunoEmail(String atualEmail, String updateEmail) {
		AlunoController contr = new AlunoController();
		Aluno aluno = contr.consultar(atualEmail);
		aluno.setEmailAluno(atualEmail);
	}
	
	private static void alterarAlunoPeriodo(String atualPeriodo, String updatePeriodo) {
		AlunoController contr = new AlunoController();
		Aluno aluno = contr.consultar(atualPeriodo);
		aluno.setPeriodo(atualPeriodo);
	}
	
	private static void alterarAlunoCursando(String atualCursando, String updateCursando) {
		AlunoController contr = new AlunoController();
		Aluno aluno = contr.consultar(atualCursando);
		aluno.setCursando(updateCursando);
	}
	private static void alterarAlunoTranspp(String atualTranspp, String updateTranspp) {
		AlunoController contr = new AlunoController();
		Aluno aluno = contr.consultar(atualTranspp);
		aluno.setTranspPublico(atualTranspp);
	}
}
