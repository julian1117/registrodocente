package co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase para el manejo del docente en general con sus datos
 * 
 * @author Giraldo
 */

@Entity
@Table(name = "T_DOCENTE")
public class Docente extends Usuario implements Serializable{

	

	@ManyToOne
	@JoinColumn(name = "ID_PROGRAMA", nullable = false)
	private Programa programa;

		
	public Docente(){
		
	}

	

	
	
	
}
