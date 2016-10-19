package co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.enumeraciones.GrupoEnum;

@Table(name = "T_CURSO")
@Entity
public class Curso implements Serializable {

	@Id
	@Column(name = "codigo")
	private String codigo;
	
	@JoinColumns({
		@JoinColumn(name="semestre_anho",referencedColumnName="anho"),
		@JoinColumn(name="semestre_periodo",referencedColumnName="periodo"),
	})
	@ManyToOne
	private Semestre semestre;

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
		return "";//semestre.+periodo+asignatura.getId()+grupo;
	}
	
	
}
