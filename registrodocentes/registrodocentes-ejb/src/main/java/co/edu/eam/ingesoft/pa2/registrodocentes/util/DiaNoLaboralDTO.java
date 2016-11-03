package co.edu.eam.ingesoft.pa2.registrodocentes.util;


import java.util.Date;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Semestre;


public class DiaNoLaboralDTO {

	private Semestre semestre;
	private Date fecha;
	private String causa;
	
	public DiaNoLaboralDTO() {
		// TODO Auto-generated constructor stub
	}

	public DiaNoLaboralDTO(Semestre semestre, Date fecha, String causa) {
		super();
		this.semestre = semestre;
		this.fecha = fecha;
		this.causa = causa;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}
	
	
	
}
