package co.edu.eam.ingesoft.pa2.registrodocentes.dto;

import java.util.Date;

/**
 * DTO para transportar datos de un nuevo registro
 * 
 * @author Brian David Tafur Londoño<br/>
 *         email: tafur2401@gmail.com <br/>
 *         Fecha: 4 de nov. de 2016<br/>
 */
public class SesionDTO {

	private Date fecha;
	private long sesionId;

	/**
	 * Constructor
	 * @param fecha, la fecha de la sesión
	 * @param sesionId, el código de la sesión del curso
	 */
	public SesionDTO(Date fecha, long sesionId) {
		super();
		this.fecha = fecha;
		this.sesionId = sesionId;
	}

	/**
	 * @return El atributo fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Establece el valor del atributo fecha
	 * 
	 * @param fecha:
	 *            EL fecha a establecer
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return El atributo sesionId
	 */
	public long getSesionId() {
		return sesionId;
	}

	/**
	 * Establece el valor del atributo sesionId
	 * 
	 * @param sesionId:
	 *            EL sesionId a establecer
	 */
	public void setSesionId(long sesionId) {
		this.sesionId = sesionId;
	}

}
