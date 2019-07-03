package model;

public class Responsavel extends Pessoa {
	
	private String cpfResp;
	private String nomeResp;
	private String enderecoResp;
	private String telefone;
	private String emailResp;
	
	public Responsavel(String cpfResp, String nome, String endereco, String telefoneResp, String email) {
		super(nome, endereco, email);

		this.cpfResp = cpfResp;
		this.telefone = telefoneResp;
		this.nomeResp = nome;
//		this.enderecoResp = endereco;
//		this.emailResp = email;
	}

	public String getCPFResp () {
		return cpfResp;
	}
	public String getFoneResp () {
		return telefone;
	}
	public void setNomeResp(String nome) {
		this.nomeResp = nome;
	}
	public String getNomeResp () {
		return nomeResp;
	}
//	public String getEndResp() {
//		return enderecoResp;
//	}
//	public String getEmailResp() {
//	return emailResp;
//}
}

	

