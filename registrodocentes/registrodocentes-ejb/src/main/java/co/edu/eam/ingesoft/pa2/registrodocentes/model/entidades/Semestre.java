package co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "T_SEMESTRE")
@Entity
@IdClass(SemestrePK.class)
public class Semestre implements Serializable {

	
	@Column(name="fecha_inicio")
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	
	@Id
	@Column(name = "anho")
	private int anho;
	@Id
	@Column(name = "periodo")
	private int periodo;
	
	
}
