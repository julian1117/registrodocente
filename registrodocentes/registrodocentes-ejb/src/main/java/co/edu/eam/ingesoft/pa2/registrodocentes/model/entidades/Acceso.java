package co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.enumeraciones.TipoAcceso;

@Entity
@Table(name="T_ACCESO")
@NamedQueries({@NamedQuery(name=Acceso.LISTAR_ACCESOS_ROL,
query="SELECT ar.acceso FROM AccesoRol ar WHERE ar.rol.id = ?1")})
public class Acceso implements Serializable{

	/*
	 * Atributos
	 */
	
	public static final String LISTAR_ACCESOS_ROL = "Acceso.listarAccesosRol";
	
	@Id
	@Column(name="ID_ACCESO", length=12, nullable=false)
	private int id;
	
	@Column(name="URL", length=200, nullable=false)
    private String url;
    
	@Column(name="NOMBRE", length=60, nullable=false)
    private String nombre;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipoacceso")
	private TipoAcceso tipoAcceso;
	
	/*
	 * Constructor 
	 */
	

	public Acceso(int id, String url, String nombre) {
		super();
		this.id = id;
		this.url = url;
		this.nombre = nombre;
	}

	public Acceso() {
	
	}
	
	/*
	 * Getters and setters
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
	
	
	
}
