package model;

public class Responsavel {
	
	private String cpfResp;
	private String nomeResp;
	private String enderecoResp;
	private String telefone;
	private String emailResp;

	public String getCPFResp () {
		return cpfResp;
	}
	public String getNomeResp () {
		return nomeResp;
	}
	public String setNomeResp(String nomeResp) {
		return this.nomeResp = nomeResp;
	}

	public String getEnderecoResp () {
		return enderecoResp;
	}
	public String setEnderecoResp(String enderecoResp) {
		return this.enderecoResp = enderecoResp;
	}
	public String setCpfResp(String cpfResp) {
		return this.cpfResp = cpfResp;
	}
	public String setTelefone(String telefone) {
		return this.telefone = telefone;
	}
	public String getFoneResp () {
		return telefone;
	}
	public String setFoneResp(String telefone) {
		return this.telefone = telefone;
	}
	public String getEmailResp () {
		return emailResp;
	}
	public String setEmailResp(String emailResp) {
		return this.emailResp = emailResp;
	}
	
	
}
