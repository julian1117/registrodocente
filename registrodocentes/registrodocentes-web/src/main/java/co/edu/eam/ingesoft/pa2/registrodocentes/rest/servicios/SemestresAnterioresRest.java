/**
 * 
 */
package co.edu.eam.ingesoft.pa2.registrodocentes.rest.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.registrodocentes.data.CursosEJB;
import co.edu.eam.ingesoft.pa2.registrodocentes.data.UsuarioEJB;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Curso;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Docente;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Usuario;
import co.edu.eam.ingesoft.pa2.registrodocentes.dto.RespuestaDTO;

/**
 * @author Alejandro
 *
 */
@Path("/semestresAnteriores")
public class SemestresAnterioresRest {

	/**
	 * Inyeccion de los EJB
	 */
	@EJB
	private UsuarioEJB usuarioEJB;

	@EJB
	private CursosEJB cursoEJB;

	/**
	 * Servicio rest que trae una lista de usuarios
	 * @return la lista si esta esta llena
	 */
	@GET
	@Path("/listaUsuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listarUsuarios() {
		List<Usuario> lista = usuarioEJB.listaUsuario();
		if (lista.isEmpty()) {
			return new RespuestaDTO(null, "La lista esta vacia", "5");
		} else {
			return new RespuestaDTO(lista);
		}

	}


	/**
	 * Servicio REST para listar los cursos con datos especificos
	 * @param anio el año seleccionado
	 * @param periodo, periodo del año 1 o 2 
	 * @param docente, el docente del cual se quiere ver los cursos
	 * @return, la lista con los cursos si se encuentra 
	 */
	@POST
	@Path("/listarCursos")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public RespuestaDTO listaCursos(@FormParam("anio") int anio, @FormParam("periodo") int periodo,
			@FormParam("docente") int docente) {
		List<Curso> listaCur = cursoEJB.listaCursos(anio, periodo, docente);
		if (listaCur.isEmpty()) {
			return new RespuestaDTO(listaCur, "No hay cursos con estos datos", "5");
		} else {
			return new RespuestaDTO(listaCur);
		}

	}

}
