package model;

import java.sql.Date;
import java.sql.Time;

public class Registro {

	private int codPront;
	private String matricula;
	private String passagem;
	
	private String dataPront;
	private String timePront;

	/*
	private Date dataPront;
	private Time timePront;
	
	public Registro(String matricula, String passagem, java.util.Date date, Time timePront) {
		this.matricula = matricula;
		this.passagem = passagem;
		this.dataPront = date;
		this.timePront = timePront;
	}

	public Registro(String codPront, String matricula, String passagem, Date dataPront, Time timePront) {
		this.matricula = matricula;
		this.passagem = passagem;
		this.dataPront = date;
		this.timePront = timePront;
	}
**/
	public Registro(String matricula, String passagem, String date, String timePront) {
		this.matricula = matricula;
		this.passagem = passagem;
		this.dataPront = date;
		this.timePront = timePront;
	}

	public Registro(String codPront, String matricula, String passagem, String date, String timePront) {
		this.matricula = matricula;
		this.passagem = passagem;
		this.dataPront = date;
		this.timePront = timePront;	
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

	public String getPassagem() {
		return passagem;
	}

	public void setPassagem(String passagem) {
		this.passagem = passagem;
	}

//	public Date getDataPront() {
//		return dataPront;
//	}

	public String getDataPront() {
		return dataPront;
	}
	
//	public void setDataPront(Date dataPront) {
//		this.dataPront = dataPront;
//	}
	
	public void setDataPront(String dataPront) {
		this.dataPront = dataPront;
	}

//	public Time getTimePront() {
//		return timePront;
//	}
	
	public String getTimePront() {
		return timePront;
	}

//	public void setTimePront(Time timePront) {
//		this.timePront = timePront;
//	}
	
	public void setTimePront(String timePront) {
		this.timePront = timePront;
	}
}
