package co.edu.eam.ingesoft.pa2.registrodocentes.rest.dto;

import java.util.List;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Acceso;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Rol;

public class AccesoRolDTO {

	private List<Acceso> accesos;
	private List<Rol> roles;
	private String usuario;

	
	public AccesoRolDTO() {
	}

	public AccesoRolDTO(List<Acceso> accesos, List<Rol> roles, String usuario) {
		super();
		this.accesos = accesos;
		this.roles = roles;
		this.usuario = usuario;
	}

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
