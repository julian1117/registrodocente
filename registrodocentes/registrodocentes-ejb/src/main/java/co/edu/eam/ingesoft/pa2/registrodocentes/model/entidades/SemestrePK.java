package co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades;

import java.io.Serializable;

import javax.persistence.Column;

public class SemestrePK implements Serializable {

	private int anho;
	private int periodo;
	
	
	public SemestrePK() {
	}


	/**
	 * @param anho
	 * @param periodo
	 */
	public SemestrePK(int anho, int periodo) {
		super();
		this.anho = anho;
		this.periodo = periodo;
	}


	/**
	 * @return the anho
	 */
	public int getAnho() {
		return anho;
	}


	/**
	 * @param anho the anho to set
	 */
	public void setAnho(int anho) {
		this.anho = anho;
	}


	/**
	 * @return the periodo
	 */
	public int getPeriodo() {
		return periodo;
	}


	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	
	
}
