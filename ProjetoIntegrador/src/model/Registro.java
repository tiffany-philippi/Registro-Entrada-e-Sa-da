package model;

import java.sql.Date;
import java.sql.Time;

public class Registro {

	private int codPront;
	private String matricula;
	private String passagem;
	private Date dataPront;
	private Time timePront;
	
	public int getCodPront() {
		return codPront;
	}
	public String getMatricula() {
		return matricula;
	}
	public String getPassagem() {
		return passagem;
	}
	public Date getDataPront() {
		return dataPront;
	}
	public Time getTimePront() {
		return timePront;
	}
}
