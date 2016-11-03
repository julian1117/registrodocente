package co.edu.eam.ingesoft.pa2.registrodocentes.rest.servicios;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.registrodocentes.bo.BORegistroEJB;
import co.edu.eam.ingesoft.pa2.registrodocentes.dto.RespuestaDTO;

@Path("/registro")
public class RegistroRest {

	@EJB
	private BORegistroEJB registroEJB;

	/**
	 * Metodo rest para obtener el listado de registros
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	@GET
	@Path("/listar-registros")
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listarRegistros(){
		return registroEJB.listarRegistros();
	}
	
	@POST
	@Path("/listar-registros-fechas")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listarRegistrosEntreFechas(@FormParam(value = "cod")String cod, @FormParam(value = "ced") int ced){
		RespuestaDTO res = new RespuestaDTO(registroEJB.listarRegistroEntreFechas(cod, ced));
		return res;
	}
	
	
	
}
