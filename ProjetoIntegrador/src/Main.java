import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

import controller.AlunoController;
import controller.RegistroController;
import controller.ResponsavelController;
import model.Aluno;
import model.Passagem;
import model.Responsavel;
import repository.ConexaoBD;

import model.SimNao;
import model.Periodo;
import model.Registro;

public class Main {
	

	public static void main(String[] args0) throws SQLException, ParseException {

		ConexaoBD.getConexao(); // Estabelece a conexão com o banco configurada em repository.ConexaoDB.java
		
		ResponsavelController respControl = new ResponsavelController(); // Controller respons�vel pelas intera��es de Responsável 
		AlunoController alunoControl = new AlunoController(); // Controller responsável pelas interações de Aluno 
		RegistroController registroControl = new RegistroController(); // Controller responsável pelas interações de Prontuário 
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Deseja interagir com: (1) Responsavel,  (2) Aluno ou (3) Prontuário de Entrada e Saída?");
		int table = sc.nextInt();
		
		switch (table) {
		
//	=================================[ INTERAÇÕES DE RESPONSÁVEL ]==================================	
		case 1: 
			System.out.println("O que você gostaria de fazer? (1) Cadastrar um novo Responsável, (2) Localizar um Responsável existente, (3) Editar um Responsável existente ou (4) Remover um Responsável?"); 
			int tipoInteracaoResponsavel = sc.nextInt();
			
			switch (tipoInteracaoResponsavel) {
			
			case 1: // Cadastrar responsável
				
				System.out.println("Para cadastrar um novo Responsável precisaremos do CPF (000.000.000-00): "); 
				String cpf_resp = sc.next();
				
				System.out.println("Precisaremos ainda do nome do Responsável: "); 
				sc.nextLine();
				String nome_resp = sc.next();
				
				System.out.println("Além disso, do endereço: "); 
				sc.nextLine();
				String endereco_resp = sc.next();
				
				System.out.println("Também o número do telefone (12345678): "); 
				sc.nextLine();
				String telefone_resp = sc.next();
				
				System.out.println("Por fim o endereço de email (nome@dominio.com): "); 
				sc.nextLine();
				String email_resp = sc.next();
	
				// Criar um novo respons�vel de acordo com o m�todo construtor para ser persistido:
				Responsavel responsavel = new Responsavel(cpf_resp, nome_resp, endereco_resp, telefone_resp, email_resp);
				respControl.persistir(responsavel);

				System.out.println("Responsável com os dados de cpf: "+ cpf_resp + " nome: " + nome_resp + " endereco: " + endereco_resp + " telefone: " + telefone_resp + " email: " + email_resp + " cadastrado com sucesso!");
			
			break; // Fim do cadastrar reponsável
			
			case 2: // Localizar responsável
				System.out.println("Para encontrar um Responsável precisaremos do CPF (000.000.000-00): ");
				String busca_cpf_resp = sc.next();
			
				Responsavel busca_responsavel = respControl.consultar(busca_cpf_resp);

				if(busca_responsavel == null) {
					System.out.println("Não foram encontrados resultados.");
				}
				else {
				System.out.println("CPF: " + busca_responsavel.getCPFResp() + "\nNome: " + busca_responsavel.getNome() + 
						"\nEndereço: " + busca_responsavel.getEndereco() + "\nTelefone: " + busca_responsavel.getFoneResp() 
						+ "\nEmail: " + busca_responsavel.getEmail());
				}
				
			break; // Fim do localizar responsável

			case 3: // Alterar responsável 
				System.out.println("Para alterar um Responsável precisaremos do CPF (000.000.000-00): ");
				String busca_cpf_resp2 = sc.next();
				sc.nextLine();  // limpar buffer teclado, às vezes o Java se perde lendo o teclado.
			
				Responsavel busca_responsavel2 = respControl.consultar(busca_cpf_resp2);

				if(busca_responsavel2 == null) {
					System.out.println("Não foram encontrados resultados.");
				}
				else {
				System.out.println("CPF: " + busca_responsavel2.getCPFResp() + "\nNome: " + busca_responsavel2.getNome() + 
						"\nEndereço: " + busca_responsavel2.getEndereco() + "\nTelefone: " + busca_responsavel2.getFoneResp() 
						+ "\nEmail: " + busca_responsavel2.getEmail());
				
				
				System.out.println("Insira o novo valor para nome: ");
				String novoNomeResp = sc.nextLine();
								
				respControl.atualizar(busca_cpf_resp2, novoNomeResp);
				
				System.out.println("Responsável editado com sucesso!");
				
				}				
			break; // Fim do alterar respons�vel
			
			
			
			case 4: // remover responsavel
				System.out.println("Para remover um Responsável precisaremos do seu CPF (000.000.000-00): ");
				String busca_cpf = sc.next();
				
				respControl.excluir(busca_cpf);
				
				System.out.println("Responsável com CPF : " + busca_cpf + " removido com Sucesso!" );

			break; // Fim do remover responsavel
			
			default: System.out.println("Opção inválida."); // Caso escolham qualquer número fora do limite 1 a 4
			}
		
		break; // Fim das interações de responsável
		
//		=================================[ FIM DAS INTERA��ES DE RESPONS�VEL ]==================================	
		
		
//		=================================[ INTERA��ES DE ALUNO ]==================================	
		
		case 2: 
			System.out.println("O que você gostaria de fazer? (1) Cadastrar um novo Aluno, (2) Localizar um Aluno existente, (3) Editar um Aluno existente ou (4) Remover um Aluno?"); 
			int tipoInteracaoAluno = sc.nextInt();
			
			switch (tipoInteracaoAluno) {
			
			case 1: // cadastrar aluno 
				System.out.println("Para cadastrar um novo Aluno precisaremos do CPF do Responsável (000.000.000-00): "); 
				String cpf_resp = sc.next();
				sc.nextLine(); // apagar o buffer do teclado
				
				Responsavel busca_responsavel = respControl.consultar(cpf_resp);
				
				if(busca_responsavel == null) {
					cpf_resp = null;
					System.out.println("Não foram encontrados resultados.");
				} 
				else {
				
					String telefoneResponsavel = busca_responsavel.getFoneResp();
					
					
					System.out.println("Precisaremos ainda da matrícula do Aluno: "); 
					String matriculaAluno = sc.nextLine();
					
					System.out.println("Precisaremos ainda do nome do Aluno: "); 
					String nomeAluno = sc.nextLine();
					
					System.out.println("Além disso, do endereço: "); 
					String enderecoAluno = sc.nextLine();
					
					System.out.println("Por fim o endereço de email (nome@dominio.com): "); 
					String emailAluno = sc.nextLine();
								
					System.out.println("O periodo do Aluno (1 - Matutino, 2 - Vespertino ou 3 - Integral): "); 
					int periodoAluno = sc.nextInt();
					sc.nextLine(); // limpar buffer teclado, às vezes o Java se perde lendo o teclado.
					Periodo periodo = null;
					
					switch (periodoAluno) { // Esse switch é para transformar a variável de inteiro para "Periodo", conforme pede o método contrutor de Aluno
						case 1: 
							periodo = Periodo.MATUTINO; 
							break;
						case 2: 
							periodo = Periodo.VESPERTINO; 
							break;
						case 3: 
							periodo = Periodo.INTEGRAL; 
							break;
						default: periodo = null;
						System.out.println("Opção de período inválida " + periodoAluno + " "+ periodo); 				
					} 
					
					System.out.println("O Aluno está cursando atualmente? (1 - Sim e 2 - Não): "); 
					int cursandoAluno = sc.nextInt();
					SimNao cursando = null;
					
					switch (cursandoAluno) {  // Esse switch é para transformar a variável de inteiro para "SimNao", conforme pede o método contrutor de Aluno
						case 1: 
							cursando = SimNao.SIM; 
							break;
						case 2: 
							cursando = SimNao.NÃO; 
							break;
						default: 
							cursando = null;
						System.out.println("Opção de cursando inválida " + cursandoAluno + " "+ cursando);
					}
										
					
					System.out.println("O Aluno faz uso de transporte público? (1 - Sim e 2 - Não): "); 
					int transporteAluno = sc.nextInt();
					SimNao transporte = null;
					
					switch (transporteAluno) { // Esse switch é para transformar a variável de inteiro para "SimNao", conforme pede o método contrutor de Aluno
						case 1: 
							transporte = SimNao.SIM; 
							break;
						case 2: 
							transporte = SimNao.NÃO; 
							break;
						default: 
							transporte = null;
						System.out.println("Opção transporte inválida " + transporteAluno + " " + transporte);
					}
							
					// Criar um novo aluno de acordo com o método construtor para ser persistido:
					Aluno aluno = new Aluno(matriculaAluno, cpf_resp, telefoneResponsavel, nomeAluno, enderecoAluno, emailAluno, periodo, cursando, transporte);
					
					alunoControl.persistir(aluno);
	
					System.out.println("\nAluno com matrícula: " + matriculaAluno + 
										"\nCPF do Responsável: " + cpf_resp +
										"\nTelefone do Responsável: "+ telefoneResponsavel +
										"\nNome: " + nomeAluno +
										"\nEndereço: " + enderecoAluno +
										"\nEmail: " + emailAluno + 
										"\nPeríodo: " + periodo +
										"\nCursando: " + cursando +
										"\nTransporte: " + transporte +
										"\n\nCadastrado com sucesso!");
				} // Fim do cadastrar aluno
			
			
			break;
				
			case 2: // localizar aluno
				System.out.println("Para encontrar um Aluno precisaremos da sua matrícula (0000000000): ");
				String busca_matricula_aluno= sc.next();
			
				Aluno busca_aluno = alunoControl.consultar(busca_matricula_aluno);

				
				if(busca_aluno == null) {
					System.out.println("Não foram encontrados resultados.");
				}
				else {
					System.out.println("\nEncontrado Aluno com matrícula: " + busca_aluno.getMatricula() + 
							"\nCPF do Responsável: " + busca_aluno.getCpf_resp() +
							"\nTelefone do Responsável: "+ busca_aluno.getTelefone_resp() +
							"\nNome: " + busca_aluno.getNome_aluno() +
							"\nEndereço: " + busca_aluno.getEndereco_aluno() +
							"\nEmail: " + busca_aluno.getEmail_aluno() + 
							"\nPeríodo: " + busca_aluno.getPeriodo() +
							"\nCursando: " + busca_aluno.getCursando() +
							"\nTransporte: " + busca_aluno.getTransPublico());
				}	
			break; // Fim do localizar aluno
		
			case 3: // Alterar aluno (implementados alterar turma e periodo)
				System.out.println("Para editar um Aluno precisaremos da sua matrícula (0000000000): ");
				String busca_matricula_aluno2 = sc.next();
			
				Aluno busca_aluno2 = alunoControl.consultar(busca_matricula_aluno2);
				
				if(busca_aluno2 == null) {
					System.out.println("Não foram encontrados resultados.");
				}
				else {
					System.out.println("\nEncontrado Aluno com matrícula: " + busca_aluno2.getMatricula() + 
							"\nCPF do Responsável: " + busca_aluno2.getCpf_resp() +
							"\nTelefone do Responsável: "+ busca_aluno2.getTelefone_resp() +
							"\nNome: " + busca_aluno2.getNome_aluno() +
							"\nEndereço: " + busca_aluno2.getEndereco_aluno() +
							"\nEmail: " + busca_aluno2.getEmail_aluno() + 
							"\nPeríodo: " + busca_aluno2.getPeriodo() +
							"\nCursando: " + busca_aluno2.getCursando() +
							"\nTransporte: " + busca_aluno2.getTransPublico());
										
					System.out.println("\nInsira o novo valor para período: ");
					String novoPeriodoAluno = sc.next();					
					
					alunoControl.alterar(busca_matricula_aluno2, novoPeriodoAluno);
					
					System.out.println("Aluno editado com sucesso!");
					
				}	
				
			break; // Fim do alterar aluno
			
			
			case 4: // Remover aluno
				System.out.println("Para remover um Aluno precisaremos da sua matrícula (0000000000): ");
				String busca_matricula_aluno3 = sc.next();
				
				Aluno busca_aluno3 = alunoControl.consultar(busca_matricula_aluno3);

				
				if(busca_aluno3 == null) {
					System.out.println("Não foram encontrados resultados.");
				}
				else {
				
				alunoControl.excluir(busca_matricula_aluno3);				
				System.out.println("Aluno com matrícula : " + busca_matricula_aluno3 + " removido com Sucesso!" );
				
				}

			break; // Fim do remover aluno
		
			default: System.out.println("Opção de Aluno inválida.");
			
			}
//			=================================[ FIM DAS INTERA��ES DE ALUNO ]==================================	
	
		break;	

//			=================================[ INTERA��ES DE PRONTU�RIO ]==================================	
		case 3: 
			System.out.println("O que você gostaria de fazer? (1) Cadastrar um novo Prontuário, (2) Localizar um Prontuário existente, (3) Remover um Prontuário?"); 
			int tipoInteracaoProntuario = sc.nextInt();
		
			switch(tipoInteracaoProntuario) {
			
			case 1: 
				System.out.println("Para cadastrar um novo Prontu�rio precisaremos da Matr�cula do Aluno (0000000000): "); 
				String matricula_prontuario = sc.next();
				sc.nextLine(); // apagar o buffer do teclado
				
				Aluno busca_aluno = alunoControl.consultar(matricula_prontuario);
				
				if(busca_aluno == null) {
					matricula_prontuario = null;
					System.out.println("Não foram encontrados resultados.");
				}
				else {
										
					System.out.print("Digite (1) para entrada ou (2) para saída: ");
					int passagem = sc.nextInt();
					Passagem str_passagem = null;

					switch(passagem) {
						case 1: 
							str_passagem = Passagem.ENTRADA; 
							break;
						case 2: 
							str_passagem = Passagem.SAÍDA; 
							break;
						default: 
							str_passagem = null;
						System.out.println("Opção entrada inválida " + passagem);
					}
					
					System.out.print("Digite a data atual no seguinte formato: DD-MM-AAAA (Ex.: 31-12-2014)");
					String data = sc.next();
									
					
					System.out.print("Digite a hora atual no seguinte formato: HHMMSS (Ex.: 07:31:59)");
					String hora = sc.next();
					
					
					// Criar um novo prontuario de acordo com o m�todo construtor para ser persistido:
					Registro registro = new Registro(matricula_prontuario, str_passagem, data, hora);
					
					registroControl.persistir(registro);
					
				}
			break;
			
			case 2: 
			
				System.out.print("Digite a matrícula do Aluno: ");
				String registro = sc.next();
				Registro buscaRegistro = registroControl.consultar(registro);
				
				if(buscaRegistro == null) {
					System.out.println("Não foram encontrados resultados.");
				}
				
				else {
				
				System.out.println("Código: " + buscaRegistro.getCodPront() + "\nMatrícula: " +  buscaRegistro.getMatricula() + 
						"\nTipo de passagem: " +  buscaRegistro.getPassagem() + "\nData: " +  buscaRegistro.getDatePront() 
						+ "\nHora: " +  buscaRegistro.getTimePront() +"\n");
				}
				
			break;
			
			case 3: 
				System.out.println("Para remover um Prontuário precisaremos de seu código: ");
				String buscaRegistro_2 = sc.next();
							
				Registro buscaRegistro_3 = registroControl.consultar(buscaRegistro_2);

				
				if(buscaRegistro_3 == null) {
					System.out.println("Não foram encontrados resultados.");
				}
				else {
				
				alunoControl.excluir(buscaRegistro_2);				
				System.out.println("Aluno com matrícula : " + buscaRegistro_2 + " removido com Sucesso!" );
				
				}
				
				break;
			default: System.out.println("Opção de Prontuário inválida.");
			
			}
			
			
		break;	

		
//		    =================================[ FIM DAS INTERAÇÕES DE PRONTU�RIO ]==================================	

		default: System.out.println("Opção de tabela inválida.");

			
		}		
		
		sc.close(); // fecha a leitura de teclado
	}
		
}
