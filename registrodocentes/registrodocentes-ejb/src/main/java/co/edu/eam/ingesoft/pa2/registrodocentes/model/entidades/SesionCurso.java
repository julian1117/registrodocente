package co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.enumeraciones.DiaEnum;

@Entity
@Table(name="sesioncurso")
public class SesionCurso implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name = "curso")
	@ManyToOne
	private Curso curso;

	@Enumerated(EnumType.STRING)
	@JoinColumn(name = "DIA")
	private DiaEnum dia;
	
	@Column(name="horainicial")
	@Temporal(TemporalType.TIME)
	private Date horaInicial;
	
	@Column(name="horafinal")
	@Temporal(TemporalType.TIME)
	private Date horaFinal;
}
