package co.edu.eam.ingesoft.pa2.registrodocentes.dto;

import java.util.List;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Acceso;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Rol;

/**
 * 
 * @author Jairo Andres
 *
 */
public class AccesoRolDTO {
	/**
	 * lista de accesos de un usuario
	 */
	private List<Acceso> accesos;
	/**
	 * lista de roles de un usuario
	 */
	private List<Rol> roles;
	/**
	 * el user del usuario
	 */
	private String usuario;

	/**
	 * constructor
	 */
	public AccesoRolDTO() {
	}

	/**
	 * constructor
	 * 
	 * @param accesos
	 * @param roles
	 * @param usuario
	 */
	public AccesoRolDTO(List<Acceso> accesos, List<Rol> roles, String usuario) {
		super();
		this.accesos = accesos;
		this.roles = roles;
		this.usuario = usuario;
	}

	/**
	 * metodos accesores y modificadores
	 */
	public List<Acceso> getAccesos() {
		return accesos;
	}

	public void setAccesos(List<Acceso> accesos) {
		this.accesos = accesos;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
