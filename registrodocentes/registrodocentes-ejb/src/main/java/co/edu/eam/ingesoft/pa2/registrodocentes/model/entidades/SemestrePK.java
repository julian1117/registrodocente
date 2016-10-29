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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anho;
		result = prime * result + periodo;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SemestrePK other = (SemestrePK) obj;
		if (anho != other.anho)
			return false;
		if (periodo != other.periodo)
			return false;
		return true;
	}
	
	
	
	
}
