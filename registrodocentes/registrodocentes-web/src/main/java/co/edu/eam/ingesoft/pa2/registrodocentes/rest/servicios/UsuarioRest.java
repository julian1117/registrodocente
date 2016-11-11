package co.edu.eam.ingesoft.pa2.registrodocentes.rest.servicios;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.registrodocentes.data.UsuarioEJB;
import co.edu.eam.ingesoft.pa2.registrodocentes.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Usuario;

/**
 * 
 * Clase responsable de los servicios REST del usuario <br>
 * 
 * @author Camilo Andres Ferrer Bustos<br>
 * 
 * 
 * @date 5/11/2016
 * @version 1.0
 */
@Path("/usuario")
public class UsuarioRest {

	@EJB
	private UsuarioEJB usuarioEJB;

	/**
	 * 
	 * Método que lista todos los usuario.<br>
	 * 
	 * @author EAM <br>
	 *         Camilo Andres Ferrer Bustos<br>
	 * 
	 * 
	 * @date 5/11/2016
	 * @version 1.0
	 * @return
	 *
	 */
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listarTodos() {
		return new RespuestaDTO(usuarioEJB.listaUsuario());
	}
	
	@POST
	@Path("/crear")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RespuestaDTO crearUsuario(Usuario usuario){
		usuario.setId((int)System.nanoTime());
		usuarioEJB.crear(usuario);
		return new RespuestaDTO("Usuario creado con exito");
	}
	
	
	@POST
	@Path("/eliminar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RespuestaDTO eliminar(Usuario usuario){
		
		usuarioEJB.eliminar(usuario);
		return new RespuestaDTO("Usuario eliminado con exito");
	}
	

}
