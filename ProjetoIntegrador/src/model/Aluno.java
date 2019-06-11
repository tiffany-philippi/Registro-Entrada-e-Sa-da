package model;

public class Aluno extends Pessoa{
	
	private String codTurma;
	private String matricula;
	private Responsavel responsavel;
	private Periodo periodo;
	private SimNao cursando;
	private SimNao transpPublico;
	
	public Aluno(String codTurma, String matricula, Responsavel responsavel, Periodo periodo, SimNao cursando, SimNao transpPublico, String nome, 
			String endereco, String email) {
		super(nome, endereco, email);
		
		this.codTurma = codTurma;
		this.matricula = matricula;
		this.periodo = periodo;
		this.cursando = cursando;
		this.transpPublico = transpPublico;
		this.responsavel = responsavel;
	}

	public Aluno(String string, String string2, String string3, String string4, String string5, String string6,
			String string7, String string8, String string9, String string10, String string11) {
		super(string6, string7, string8);
			
	}
	
	public String getTurma() {
		return codTurma;
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
	public Responsavel getResponsavel() {
		return responsavel;
	}
	
}
