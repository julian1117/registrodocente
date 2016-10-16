package co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="T_DIANOLABORABLE")
@Entity
public class DiaNoLaborable implements Serializable {

	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column(name="causa")
	private String causa;
	
	@JoinColumn(name="semestre")
	@ManyToOne
	private Semestre semestre;
}
