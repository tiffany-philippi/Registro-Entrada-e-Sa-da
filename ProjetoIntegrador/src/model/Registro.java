package model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Registro {

	private int codPront;
	private String matricula;
	private Passagem passagem;
	
	private String data;
	private String hora;
	
	private LocalDate date;
	private LocalTime time;
		
	
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
	
	public Registro(String matricula, Passagem passagem, LocalDate date, LocalTime time) {
		// TODO Auto-generated constructor stub
		this.matricula = matricula;
		this.passagem = passagem;
		this.date = date;
		this.time = time;
		
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

	public LocalDate getDatePront() {
		return date;
	}
	
	public void setDataPront(LocalDate date) {
		this.date = date;
	}
	
	public LocalTime getTimePront() {
		return time;
	}
	
	public void setTimePront(LocalTime time) {
		this.time = time;
	}
}
