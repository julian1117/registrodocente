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

@Entity
@Table(name = "T_CURSO")
public class Curso implements Serializable {

	@Id
	@Column(name = "ID_CURSO", length = 12, nullable = false)
	private String codigo;

	@JoinColumns({ @JoinColumn(name = "semestre_anho", referencedColumnName = "anho"),
			@JoinColumn(name = "semestre_periodo", referencedColumnName = "periodo"), })
	@ManyToOne
	private Semestre semestre;

	@ManyToOne
	@JoinColumn(name = "asignatura")
	private Asignatura asignatura;

	@ManyToOne
	@JoinColumn(name = "docente")
	private Docente docente;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "GRUPO")
	private GrupoEnum grupo;

	public Curso() {

	}

	public Curso(String codigo, Semestre semestre, Asignatura asignatura, Docente docente, GrupoEnum grupo) {
		super();
		this.codigo = codigo;
		this.semestre = semestre;
		this.asignatura = asignatura;
		this.docente = docente;
		this.grupo = grupo;
	}

	public String getCodigo() {
		return codigo;// semestre.+periodo+asignatura.getId()+grupo;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public GrupoEnum getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoEnum grupo) {
		this.grupo = grupo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	

}
