package co.edu.eam.ingesoft.pa2.registrodocentes.rest.servicios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.registrodocentes.dto.AccesoRolDTO;
import co.edu.eam.ingesoft.pa2.registrodocentes.dto.LoginOutDTO;
import co.edu.eam.ingesoft.pa2.registrodocentes.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa2.registrodocentes.bo.AccesoRolEJB;
import co.edu.eam.ingesoft.pa2.registrodocentes.bo.LoginEJB;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Acceso;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Rol;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Usuario;


/**
 * 
 * @author Jairo
 *
 */
@Path("/login")
public class LoginRest {

	@EJB
	private LoginEJB loginEJB;

	@EJB
	private AccesoRolEJB accesoRolEJB;

	public static Map<String, Object> tokens = new HashMap<>();

	@POST
	@Path("/verificar")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO login(@FormParam(value = "usuario") String usuario,
			@FormParam(value = "contrasenia") String contrasenia) {
		Usuario u = loginEJB.buscarUsuario(usuario, contrasenia);
		if (u != null) {
			String token = UUID.randomUUID().toString();
			tokens.put(token, u.getId());
			LoginOutDTO obj = new LoginOutDTO(token, usuario, "1");
			return new RespuestaDTO(obj);
		} else {
			return new RespuestaDTO(null, "NO AUTORIZADO", "-1");
		}
	}

	
	@POST
	@Path("/accesos")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO accesos(@FormParam(value = "usuario") String usuario) {
		System.out.println("usuario-------" + usuario);
		List<Rol> roles = accesoRolEJB.listarRoles(usuario);
		List<Acceso> accesos = accesoRolEJB.listarAccesos();
		if (!roles.isEmpty()) {
			AccesoRolDTO obj = new AccesoRolDTO(accesos, roles, usuario);
			return new RespuestaDTO(obj);
		} else {
			return new RespuestaDTO(null, "Usted no cuenta con accesos asignados", "-1");
		}
	}

}
