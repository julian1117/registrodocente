package co.edu.eam.ingesoft.pa2.registrodocentes.rest.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import co.edu.eam.ingesoft.pa2.registrodocentes.data.DocenteEJB;
import co.edu.eam.ingesoft.pa2.registrodocentes.data.ProgramaEJB;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Docente;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Programa;
import co.edu.eam.ingesoft.pa2.registrodocentes.dto.RespuestaDTO;;

@Path("/programas")
public class ProgramaRest {

	@EJB
	private ProgramaEJB programaEJB;
	
	@EJB
	private DocenteEJB docenteEJB;
	
	@GET
	@Path("/listar-programas")
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listarProgramas(){
		return new RespuestaDTO( programaEJB.listarProgramas()); 
	}
	
	@POST
	@Path("/listar-docentes")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public RespuestaDTO listarDocentes(@FormParam(value="codigo")String codigo){
		List<Docente> lista = docenteEJB.listarDocentes(codigo);
		return new RespuestaDTO(lista);
	}
	
}
