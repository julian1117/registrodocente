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
	@JoinColumn(name = "sesion")
	private SesionCurso sesion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha")
	private Date fecha;

	@Column(name = "comentario")
	private String comentario;

	@Column(name = "aprobcoord")
	private boolean aprobadoCoord;

	@Column(name = "aprobrh")
	private boolean aprobadoRH;


   	/**
	 * Constructor vacío
	 */
	public Registro() {
	}
	
	/**
	 * Constructor
	 * @param sesion, la sesión a la que corresponde el registro
	 * @param fecha, la fecha en la que se genera el registro
	 * @param comentario, el comentario del registro
	 */
	public Registro(SesionCurso sesion, Date fecha, String comentario) {
		super();
		this.sesion = sesion;
		this.fecha = fecha;
		this.comentario = comentario;
		aprobadoCoord = false;
		aprobadoRH = false;
	}

	/**
	 * @return El atributo id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Establece el valor del atributo id
	 * @param id: EL id a establecer
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return El atributo sesion
	 */
	public SesionCurso getSesion() {
		return sesion;
	}

	/**
	 * Establece el valor del atributo sesion
	 * @param sesion: EL sesion a establecer
	 */
	public void setSesion(SesionCurso sesion) {
		this.sesion = sesion;
	}

	/**
	 * @return El atributo fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Establece el valor del atributo fecha
	 * @param fecha: EL fecha a establecer
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return El atributo comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * Establece el valor del atributo comentario
	 * @param comentario: EL comentario a establecer
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
	 * @return El atributo aprobadoCoord
	 */
	public boolean isAprobadoCoord() {
		return aprobadoCoord;
	}

	/**
	 * Establece el valor del atributo aprobadoCoord
	 * @param aprobadoCoord: EL aprobadoCoord a establecer
	 */
	public void setAprobadoCoord(boolean aprobadoCoord) {
		this.aprobadoCoord = aprobadoCoord;
	}

	/**
	 * @return El atributo aprobadoRH
	 */
	public boolean isAprobadoRH() {
		return aprobadoRH;
	}

	/**
	 * Establece el valor del atributo aprobadoRH
	 * @param aprobadoRH: EL aprobadoRH a establecer
	 */
	public void setAprobadoRH(boolean aprobadoRH) {
		this.aprobadoRH = aprobadoRH;
	}	
}
   	
	

