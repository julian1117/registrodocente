package co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.enumeraciones.GrupoEnum;

@Table(name = "T_CURSO")
@Entity
public class Curso implements Serializable {

	@Id
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "anho")
	private int anho;
	@Column(name = "periodo")
	private int periodo;

	@JoinColumn(name = "asignatura")
	@ManyToOne
	private Asignatura asignatura;

	@JoinColumn(name = "docente")
	@ManyToOne
	private Docente docente;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "GRUPO")
	private GrupoEnum grupo;
	
	public Curso() {
		
	}
	
	
	
	public String getCodigo() {
		return anho+periodo+asignatura.getId()+grupo;
	}
	
	
}
