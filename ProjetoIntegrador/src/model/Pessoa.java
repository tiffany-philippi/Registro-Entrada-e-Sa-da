package model;

public class Pessoa {

	private String nome;
	private String endereco;
	private String email;
	
	public Pessoa (String nome, String endereco, String email) {
		this.setNomeResp(nome);
		this.endereco = endereco;
		this.email = email;
	}
	public String getNome() {
		return getNomeResp();
	}
	public String getEndereco() {
		return endereco;
	}
	public String getEmail() {
		return email;
	}
	public String getNomeResp() {
		return nome;
	}
	public void setNomeResp(String nome) {
		this.nome = nome;
	}
} 
