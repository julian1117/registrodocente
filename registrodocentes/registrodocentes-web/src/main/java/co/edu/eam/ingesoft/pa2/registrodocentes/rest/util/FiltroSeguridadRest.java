package co.edu.eam.ingesoft.pa2.registrodocentes.rest.util;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import co.edu.eam.ingesoft.pa2.registrodocentes.rest.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa2.registrodocentes.rest.servicios.LoginRest;

//@Secured//indicar al filtro que se interceptara lo anotado con esto
@Provider
public class FiltroSeguridadRest implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext ctxReq) throws IOException {

		String token=ctxReq.getHeaderString("Authorization");
		//TODO: revisar el usuario del token y el permiso de acceso al servicio
		if(!LoginRest.tokens.containsKey(token)){
			RespuestaDTO dto = new RespuestaDTO(null, "No Autorizado", "-3");
			Response res=Response.status(401).entity(dto).build();
			ctxReq.abortWith(res);
		}
		
	}

}
