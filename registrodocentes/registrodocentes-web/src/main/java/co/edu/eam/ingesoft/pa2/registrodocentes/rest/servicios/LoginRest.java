package co.edu.eam.ingesoft.pa2.registrodocentes.rest.servicios;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.registrodocentes.rest.dto.LoginOutDTO;
import co.edu.eam.ingesoft.pa2.registrodocentes.rest.dto.RespuestaDTO;

@Path("/seguridad")
public class LoginRest {

//	@EJB
//	private ClienteEJB cliEJB;

	public static Map<String, Object> tokens = new HashMap<>();

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/login")
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO login(@FormParam(value = "user") String user, 
			@FormParam(value = "pass") String pass) {

//		Credenciales cred = cliEJB.buscarCredencialesCliente(user);

		if (null != null) {
			String token = UUID.randomUUID().toString();
//			tokens.put(token, cred.getCliente());
			return new RespuestaDTO(new LoginOutDTO(token, user, null));
		} else {
			return new RespuestaDTO(null, "NO AUTORIZADO", "-1");
		}

	}
}
