package co.edu.eam.ingesoft.pa2.registrodocentes.rest.util;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import co.edu.eam.ingesoft.pa2.registrodocentes.bo.AccesoEJB;
import co.edu.eam.ingesoft.pa2.registrodocentes.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa2.registrodocentes.rest.servicios.LoginRest;

//@Secured//indicar al filtro que se interceptara lo anotado con esto
//@Provider
public class FiltroSeguridadRest implements ContainerRequestFilter {
//	@EJB
//	AccesoEJB acc;

	@Override
	public void filter(ContainerRequestContext ctxReq) throws IOException {
		String token=ctxReq.getHeaderString("Authorization");
		
//		List<String> meto = ctxReq.getUriInfo().getMatchedURIs();
//		String metod = meto.get(0);
		//TODO: revisar el usuario del token y el permiso de acceso al servicio
		if(!LoginRest.tokens.containsKey(token)){
			RespuestaDTO dto = new RespuestaDTO(null, "No Autorizado", "-3");
			Response res=Response.status(401).entity(dto).build();
			ctxReq.abortWith(res);
		}
//		String usere =(String)LoginRest.tokens.get(token);
//		if(meto!=null){
//			
//		}
		
	}

}
