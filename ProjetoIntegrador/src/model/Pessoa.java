package model;

public class Pessoa {

	private String nome;
	private String endereco;
	private String email;
	
	protected void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	protected void setEmail(String email) {
		this.email = email;
	}
	protected void setNome(String nome) {
		this.nome = nome;
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
} 
