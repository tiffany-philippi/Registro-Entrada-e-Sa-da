package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Registro {

	private int codPront;
	private String matricula;
	private Passagem passagem;
	
	private String data;
	private String hora;
		
	
	public Registro(String matricula, Passagem str_passagem, String data, String hora) {
		this.matricula = matricula;
		this.passagem = str_passagem;
		this.data = data;
		this.hora = hora;
	}

	public Registro(int codPront, String matricula, Passagem passagem, String data, String hora) {
		this.codPront = codPront;
		this.matricula = matricula;
		this.passagem = passagem;
		this.data = data;
		this.hora = hora;
	}
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getCodPront() {
		return codPront;
	}

	public void setCodPront(int codPront) {
		this.codPront = codPront;
	}

	public Passagem getPassagem() {
		return passagem;
	}

	public void setPassagem(Passagem passagem) {
		this.passagem = passagem;
	}

	public String getDatePront() {
		return data;
	}
	
	public void setDataPront(String data) {
		this.data = data;
	}
	
	public String getTimePront() {
		return hora;
	}
	
	public void setTimePront(String hora) {
		this.hora = hora;
	}
}
