package model;

public class Pessoa {

	private String nome;
	private String endereco;
	private String email;
	
	public Pessoa (String nome, String endereco, String email) {
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getEmail() {
		return email;
	}
} 
