package co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_DIANOLABORABLE")
public class DiaNoLaborable implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_DIANOLABORABLE", length=45, nullable=false)
	private Long id;
	
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column(name="causa")
	private String causa;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="semestre_anho",referencedColumnName="anho"),
		@JoinColumn(name="semestre_periodo",referencedColumnName="periodo"),
	})
	private Semestre semestre;

	public DiaNoLaborable( Date fecha, String causa, Semestre semestre) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.causa = causa;
		this.semestre = semestre;
	}

	public DiaNoLaborable() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}
	
	
}
