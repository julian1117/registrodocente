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
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Registro;

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
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listarRegistros(){
		return new RespuestaDTO(registroEJB.listarRegistros());
	}

	/**
	 * Servicio REST para listar los registros de 8 días antes y después
	 * @author Brian David Tafur Londoño<br/>
	 *         email: tafur2401@gmail.com <br/>
	 *         Fecha: 3 de nov. de 2016<br/>
	 * @param cod, código del curso
	 * @param ced, cédula del docente
	 * @return una cadena JSON con la lista de registros en ese rango
	 */
	@POST
	@Path("/listarregistrosfechas")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listarRegistrosEntreFechas(@FormParam(value = "cod")String cod, @FormParam(value = "ced") int ced){
		RespuestaDTO res = new RespuestaDTO(registroEJB.listarRegistroEntreFechas(cod, ced));
		return res;
	}
	
	
	/**
	 * Metodo REST para listar los registros sin aprobar de un docente en una
	 * asignatura especifica
	 * @param idDoc, es la identificacion del docente
	 * @param idAsig, es la identificacion de la asignatura
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	@POST
	@Path("/listar-registros-docente-asignatura-sin-aprobar")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listarRegistrosDocenteAsignaturaNA(@FormParam(value="doc") int idDoc,
			                                               @FormParam(value="asig") String idAsig){
		return new RespuestaDTO(registroEJB.listarRegistrosDocenteAsignaturaNA(idDoc, idAsig));
	}
	
	
	/**
	 * Metodo para aprobar un registro
	 * @param idReg, es el id del registro a aprobar
	 * @param coment, es el comentario del registro a aprobar
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
	@POST
	@Path("/aprobar-registro")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO aprobarRegistro(@FormParam(value="idReg") Long idReg,
                                        @FormParam(value="coment") String coment){
		return new RespuestaDTO(registroEJB.aprobarRegistro(idReg, coment));
	}
	
}
