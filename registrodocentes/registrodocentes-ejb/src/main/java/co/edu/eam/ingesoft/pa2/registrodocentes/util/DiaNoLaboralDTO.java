package co.edu.eam.ingesoft.pa2.registrodocentes.util;


import java.util.Date;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Semestre;


public class DiaNoLaboralDTO {

	/**
	 * anho del semestre
	 */
	private int anho;
	
	/**
	 * periodo del semestre
	 */
	 private int periodo;
	
	/**
	 * fecha del dia noo laboral
	 */
	private Date fechaNoLaboral;
	
	/**
	 * cuasa por la cual es dia no laboral
	 */
	private String causa;
	
	public DiaNoLaboralDTO() {
		// TODO Auto-generated constructor stub
	}

	public DiaNoLaboralDTO(int anho, int periodo, Date fechaNoLaboral, String causa) {
		super();
		this.anho = anho;
		this.periodo = periodo;
		this.fechaNoLaboral = fechaNoLaboral;
		this.causa = causa;
	}

	public int getAnho() {
		return anho;
	}

	public void setAnho(int anho) {
		this.anho = anho;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public Date getFechaNoLaboral() {
		return fechaNoLaboral;
	}

	public void setFechaNoLaboral(Date fechaNoLaboral) {
		this.fechaNoLaboral = fechaNoLaboral;
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}


	
	
}
