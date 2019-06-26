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
	public void setNomeResp(String nomeResp) {
		this.nomeResp = nomeResp;
	}

	public String getEnderecoResp () {
		return enderecoResp;
	}
	public void setEnderecoResp(String enderecoResp) {
		this.enderecoResp = enderecoResp;
	}
	public String getFoneResp () {
		return telefone;
	}
	public void setFoneResp(String telefone) {
		this.telefone = telefone;
	}
	public String getEmailResp () {
		return emailResp;
	}
	public void setEmailResp(String emailResp) {
		this.emailResp = emailResp;
	}
	
	
}
