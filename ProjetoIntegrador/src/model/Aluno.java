package model;

public class Aluno extends Pessoa{
	
	private String matricula;
	private String cpf_resp;
	private String telefone_resp;
	private String nome_aluno;
	private String endereco_aluno;
	private String email_aluno;
	private Periodo periodo;
	private SimNao cursando;
	private SimNao transpPublico;

	
	public Aluno(String matricula, String cpf_resp, String telefone_resp, String nome_aluno, String endereco_aluno, String email_aluno, Periodo periodo, SimNao cursando, SimNao transp_publico) {

		this.matricula = matricula;
		this.cpf_resp = cpf_resp;
		this.telefone_resp = telefone_resp;
		this.nome_aluno = nome_aluno;
		this.endereco_aluno = endereco_aluno;
		this.email_aluno = email_aluno;
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
		return cpf_resp;
	}

	public void setCpf_resp(String cpf_resp) {
		this.cpf_resp = cpf_resp;
	}

	public String getTelefone_resp() {
		return telefone_resp;
	}

	public void setTelefone_resp(String telefone_resp) {
		this.telefone_resp = telefone_resp;
	}

	public String getNome_aluno() {
		return nome_aluno;
	}

	public void setNome_aluno(String nome_aluno) {
		this.nome_aluno = nome_aluno;
	}

	public String getEndereco_aluno() {
		return endereco_aluno;
	}

	public void setEndereco_aluno(String endereco_aluno) {
		this.endereco_aluno = endereco_aluno;
	}

	public String getEmail_aluno() {
		return email_aluno;
	}

	public void setEmail_aluno(String email_aluno) {
		this.email_aluno = email_aluno;
	}
	
}
