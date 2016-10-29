package co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_SEMESTRE")
@IdClass(SemestrePK.class)
public class Semestre implements Serializable {

	
	@Column(name="fecha_inicio", nullable=false)
	@Temporal(value=TemporalType.DATE)
	private Date fechaInicio;
	
	@Id
	@Column(name = "anho", length=4, nullable=false)
	private int anho;
	
	@Id
	@Column(name = "periodo", length=5, nullable=false)
	private int periodo;

	public Semestre(Date fechaInicio, int anho, int periodo) {
		super();
		this.fechaInicio = fechaInicio;
		this.anho = anho;
		this.periodo = periodo;
	}

	public Semestre() {
		super();
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
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
	
	
	
	
}
