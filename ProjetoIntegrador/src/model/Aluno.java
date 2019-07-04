package model;

public class Aluno extends Pessoa {
	
	private String matricula;
	private String cpfResp;
	private String telefoneResp;
	private String nomeAluno;
	private String enderecoAluno;
	private String emailAluno;
	private Periodo periodo;
	private SimNao cursando;
	private SimNao transpPublico;
	
	public Aluno(String matricula, String cpf_resp, String telefone_resp, String nome_aluno, String endereco_aluno, String email_aluno, Periodo periodo, SimNao cursando, SimNao transp_publico) {
		super(nome_aluno, endereco_aluno, email_aluno);
		this.matricula = matricula;
		this.cpfResp = cpf_resp;
		this.telefoneResp = telefone_resp;
		this.nomeAluno = nome_aluno;
		this.enderecoAluno = endereco_aluno;
		this.emailAluno = email_aluno;
		this.periodo = periodo;
		this.cursando = cursando;
		this.transpPublico = transp_publico;
		
	}
	
	public String getMatricula() {
		return matricula;
	}
	public Periodo getPeriodo() {
		return periodo;
	}
	public SimNao getCursando() {
		return cursando;
	}
	public SimNao getTransPublico() {
		return transpPublico;
	}	
	public String getCpf_resp() {
		return cpfResp;
	}

	public void setCpf_resp(String cpf_resp) {
		this.cpfResp = cpf_resp;
	}

	public String getTelefone_resp() {
		return telefoneResp;
	}

	public void setTelefone_resp(String telefone_resp) {
		this.telefoneResp = telefone_resp;
	}

	public String getNome_aluno() {
		return nomeAluno;
	}

	public void setNome_aluno(String nome_aluno) {
		this.nomeAluno = nome_aluno;
	}

	public String getEndereco_aluno() {
		return enderecoAluno;
	}

	public void setEndereco_aluno(String endereco_aluno) {
		this.enderecoAluno = endereco_aluno;
	}

	public String getEmail_aluno() {
		return emailAluno;
	}

	public void setEmail_aluno(String email_aluno) {
		this.emailAluno = email_aluno;
	}

	public void setMatricula(String matriculaAluno) {
		this.matricula = matriculaAluno;
		
	}
}
	
	