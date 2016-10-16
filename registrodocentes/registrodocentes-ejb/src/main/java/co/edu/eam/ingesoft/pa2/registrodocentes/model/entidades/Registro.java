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

@Table(name = "CURSO")
@Entity
public class Registro implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
}
