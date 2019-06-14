package model;

public class Responsavel extends Pessoa {
	
	private String cpfResp;
	private String telefone;
	private String nome;
	
	public Responsavel(String cpfResp, String nome, String endereco, String telefoneResp, String email) {
		super(nome, endereco, email);

		this.cpfResp = cpfResp;
		this.telefone = telefoneResp;
	}

	public String getCPFResp () {
		return cpfResp;
	}
	public String getFoneResp () {
		return telefone;
	}
	public void setNomeResp(String nome) {
		this.nome = nome;
	}
	
	
}
