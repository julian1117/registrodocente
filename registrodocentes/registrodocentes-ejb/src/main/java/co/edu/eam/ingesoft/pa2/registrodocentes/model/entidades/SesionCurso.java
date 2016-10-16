package co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.enumeraciones.DiaEnum;

@Entity
@Table(name="sesioncurso")
public class SesionCurso implements Serializable{

	@JoinColumn(name = "curso")
	@ManyToOne
	private Curso curso;

	@ManyToOne
	@JoinColumn(name = "DIA")
	private DiaEnum dia;
}
