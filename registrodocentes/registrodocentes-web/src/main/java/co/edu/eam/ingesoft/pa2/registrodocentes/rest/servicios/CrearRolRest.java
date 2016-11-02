package co.edu.eam.ingesoft.pa2.registrodocentes.rest.servicios;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.registrodocentes.rest.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa2.registrodocentes.rest.dto.RolInDTO;
import co.edu.eam.ingesoft.pa2.registrodocentes.service.RolEJB;

@Path("/gestionRol")
public class CrearRolRest {

	@EJB
	private RolEJB rolEJB;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/crear")
	public RespuestaDTO crearRol(RolInDTO rol) {
		boolean resp = rolEJB.crearRol(rol.getRol());
		if(resp) {
			return new RespuestaDTO(resp, "El Rol se registro con exito", "00");
		}
		return new RespuestaDTO(resp, "El Rol ya existe", "-12");
	}
}
