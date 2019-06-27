// Arrumar hora: command line -- SET GLOBAL TIME_ZONE = '-3:00';
import java.sql.SQLException;
import java.util.Scanner;

import controller.AlunoController;
import controller.RegistroController;
import controller.ResponsavelController;
import model.Aluno;
import model.Periodo;
import model.Registro;
import model.Responsavel;
import repository.ConexaoBD;

public class Main {

	public static void main(String[] args0) throws SQLException {
		ConexaoBD.getConexao();
		
		Scanner sc = new Scanner(System.in);
//		====================================================================================================================================================
		//RESPONS�VEL
		System.out.println("Deseja atuar em qual tabela do banco de dados? (1- Responsavel, 2- Aluno, 3- Prontu�rio de entrada e sa�da)");
		int table = Integer.parseInt(sc.nextLine());
		
		if (table == 1) {
			System.out.println("Voc� deseja inserir um novo respons�vel? (1- SIM, 2- N�O)");
			int esc = Integer.parseInt(sc.nextLine());
			if (esc == 1) {
				inserirResponsavel();
			} else {
				System.out.println("Digite o CPF do respons�vel.");
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
						System.out.println("Respons�vel removido");
						break;
					case 3:
						System.out.println("Digite os novos campos (1- NOME, 2- TELEFONE, 3- EMAIL):");
						System.out.println("Os campos ser�o alterados para o respons�vel de cpf: " + cpf);
							System.out.print("Digite o novo nome: ");
							String updateNome = sc.next();
							System.out.print("Digite o telefone novo: ");
							String updateFone = sc.next();
							System.out.print("Digite o novo email: ");
							String updateEmail = sc.next();
							alterarResp(cpf, updateNome, updateFone, updateEmail);
						break;
						default:
							System.out.println("Digite uma op��o v�lida.");
				}
			}
	
//			====================================================================================================================================================
			//ALUNO
		} else if (table == 2) {
			System.out.println("Voc� deseja inserir um novo aluno? (1- SIM, 2- N�O)");
			int esc = Integer.parseInt(sc.nextLine());
			if (esc == 1) {
				inserirAluno();
			} else {
				System.out.println("Digite a matricula do aluno.");
				String matricula = sc.nextLine();
				System.out.println("Respectivamente, digite 1, 2 ou 3, caso queira consultar, remover ou alterar um aluno. Caso queira voltar ao menu anterior, digite 0.");
				int escolha = Integer.parseInt(sc.nextLine());
//				System.out.println(escolha);
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
						System.out.println("Digite a informa��o voc� deseja alterar: (1- NOME, 2- EMAIL, 3- PER�ODO, 4- CURSANDO, 5- TRANSP. P�BLICO)");
							System.out.print("Os dados ser�o alterados para o aluno da seguinte matr�cula: " + matricula);
							System.out.print("Digite o novo nome: ");
							String updateNome = sc.next();
							System.out.print("Digite o novo email: ");
							String updateEmail = sc.next();
							System.out.print("Digite o novo per�odo: ");
							String updatePeriodo = sc.next();
							System.out.print("Digite o novo status (cusando - sim/n�o): ");
							String updateCursando = sc.next();
							System.out.print("Digite se o aluno usa ou n�o transporte p�blico: ");
							String updateTranspp = sc.next();
//							alterarAluno(matricula, updateNome, updateEmail, updatePeriodo, updateCursando, updateTranspp);
						break;
						default:
							System.out.println("Digite uma op��o v�lida.");
							break;
				}
			} else if (table == 3) {
				System.out.println("Deseja consultar, remover ou inserir? (1, 2, 3 respectivamente");
				int escolha = Integer.parseInt(sc.nextLine());
				System.out.println(escolha);
				switch (escolha) {
				case 1:
					System.out.print("Digite a matr�cula do aluno: ");
					String matcons = sc.next();
					consultarRegistro(matcons);
					break;
				case 2:
					System.out.print("Digite a matr�cula do aluno: ");
					String matremov = sc.next();
					removerRegistro(matremov);
					break;
				case 3:
					System.out.print("Digite a matr�cula do aluno: ");
					String matricula = sc.next();
					System.out.print("Digite se � entrada ou sa�da: ");
					String passagem = sc.next();
					System.out.print("Digite a data atual no seguinte formato: AAAAMMDD (Ex.: 20141231)");
					String data = sc.next();
					System.out.print("Digite a hora atual no seguinte formato: HHMMSS (Ex.: 073159)");
					String hora = sc.next();
					inserirRegistro(matricula, passagem, data, hora);
					break;
				default:
					break;
				}
	
			sc.close();
		}
	}
//	====================================================================================================================================================
	//RESPONSAVEL
	
	protected static void inserirResponsavel() {
		//criar o objeto Respons�vel
		Responsavel resp = new Responsavel();
		ResponsavelController contr = new ResponsavelController();
		contr.persistir(resp);
	}
	
	private static void consultarResp(String cpfResp) {
		ResponsavelController contr = new ResponsavelController();
		contr.consultar(cpfResp);
	}

	private static void alterarResp(String cpf, String atualNome, String updateNome, String updateEmail) {
		ResponsavelController contr = new ResponsavelController();
		Responsavel resp = contr.consultar(cpf);
		resp.setNomeResp(updateNome);
		contr.atualizar(resp);
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

//	private static void alterarAluno(Aluno matricula, String updateNome, String updateEndereco, String updateEmail, String updateCursando, String updatePeriodo, String updateTranspp) {
//		AlunoController contr = new AlunoController();
//		Aluno aluno = contr.consultar(matricula);
//		aluno.setNomeAluno(matricula);
//	}
	}

	private static void inserirRegistro(String matricula, String passagem, String data, String hora) {
		Registro registro = new Registro();
		RegistroController cont = new RegistroController();
		cont.persistir(matricula, passagem, data, hora);
	}

	private static void removerRegistro(String matremov) {
		RegistroController cont = new RegistroController();
		cont.persistir(matremov);		
	}

	private static void consultarRegistro(String matcons) {
		RegistroController cont = new RegistroController();
		cont.persistir(matcons);
	}
}
