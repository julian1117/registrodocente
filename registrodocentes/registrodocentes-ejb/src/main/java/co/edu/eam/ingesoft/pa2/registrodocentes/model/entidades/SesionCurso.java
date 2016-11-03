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
@Table(name="T_SESION_CURSO")
public class SesionCurso implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_SESIONCURSO")
	private Long id;
	
	@JoinColumn(name = "ID_CURSO")
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

	public SesionCurso(Curso curso, DiaEnum dia, Date horaInicial, Date horaFinal) {
		super();
		this.id = id;
		this.curso = curso;
		this.dia = dia;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
	}

	public SesionCurso() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public DiaEnum getDia() {
		return dia;
	}

	public void setDia(DiaEnum dia) {
		this.dia = dia;
	}

	public Date getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(Date horaInicial) {
		this.horaInicial = horaInicial;
	}

	public Date getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}
	
	
	
}
