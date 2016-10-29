package co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "T_REGISTRO")
public class Registro implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_REGISTRO", length=45, nullable=false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="sesion")
	private SesionCurso sesion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha")
	private Date fecha;
	
	@Column(name="comentario")
	private String comentario;
	
	@Column(name="aprobcoord")
	private boolean aprobadoCoord;
	
	@Column(name="aprobrh")
	private boolean aprobadoRH;

	public Registro(SesionCurso sesion, Date fecha, String comentario, boolean aprobadoCoord,
			boolean aprobadoRH) {
		super();
		this.id = id;
		this.sesion = sesion;
		this.fecha = fecha;
		this.comentario = comentario;
		this.aprobadoCoord = aprobadoCoord;
		this.aprobadoRH = aprobadoRH;
	}

	public Registro() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SesionCurso getSesion() {
		return sesion;
	}

	public void setSesion(SesionCurso sesion) {
		this.sesion = sesion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public boolean isAprobadoCoord() {
		return aprobadoCoord;
	}

	public void setAprobadoCoord(boolean aprobadoCoord) {
		this.aprobadoCoord = aprobadoCoord;
	}

	public boolean isAprobadoRH() {
		return aprobadoRH;
	}

	public void setAprobadoRH(boolean aprobadoRH) {
		this.aprobadoRH = aprobadoRH;
	}
	
	
}
