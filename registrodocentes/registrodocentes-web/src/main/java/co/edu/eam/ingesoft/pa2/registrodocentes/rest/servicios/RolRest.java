package co.edu.eam.ingesoft.pa2.registrodocentes.rest.servicios;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Acceso;
import co.edu.eam.ingesoft.pa2.registrodocentes.rest.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa2.registrodocentes.rest.dto.RolInDTO;
import co.edu.eam.ingesoft.pa2.registrodocentes.service.AccesoEJB;
import co.edu.eam.ingesoft.pa2.registrodocentes.service.RolEJB;

@Path("/gestionRol")
public class RolRest {

	@EJB
	private RolEJB rolEJB;
	@EJB
	private AccesoEJB accesoEJB;
	
	/**
	 * Servicio que se encarga de crear los Roles
	 * @param rol, el Rol que se desea crear
	 * @return un RespuestaDTO indicando si el registro fue exitoso, de lo contrario
	 * un error (-12)
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/crearRol")
	public RespuestaDTO crearRol(RolInDTO rol) {
		System.out.println("Id: "+rol.getRol().getId());
		boolean resp = rolEJB.crearRol(rol.getRol());
		if(resp) {
			return new RespuestaDTO(resp);
		}
		return new RespuestaDTO(null, "El Rol ya existe", "-12");
	}
	
	/**
	 * Servicio que se encarga de listar los accesos
	 * @return un RespuestaDTO con la lista de los accesos, si esta vacia envia 
	 * un mensaje indicando esto con codigo -13
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listarAccesos")
	public RespuestaDTO listarAccesos() {
		ArrayList<Acceso> resp = (ArrayList<Acceso>)accesoEJB.listarAcceso();
		if(resp.isEmpty()) {
			return new RespuestaDTO(null, "No hay accesos", "-13");
		}
		return new RespuestaDTO(resp);
	}
}
