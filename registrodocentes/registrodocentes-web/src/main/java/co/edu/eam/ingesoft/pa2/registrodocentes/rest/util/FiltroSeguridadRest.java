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
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Acceso;
import co.edu.eam.ingesoft.pa2.registrodocentes.rest.servicios.LoginRest;

@Secured // indicar al filtro que se interceptara lo anotado con esto
@Provider
public class FiltroSeguridadRest implements ContainerRequestFilter {
	@EJB
	AccesoEJB acc;
/**
 * Jhohanns villa vasquez
 * Metodo que hace filtro para los servicios por medio de el token saca el user y 
 * revisa si tiene algun acceso al servicio
 */
	@Override
	public void filter(ContainerRequestContext ctxReq) throws IOException {
		String token = ctxReq.getHeaderString("Authorization");
		System.out.println(token + "hh");
		List<String> meto = ctxReq.getUriInfo().getMatchedURIs();
		String metod = meto.get(0);
		// System.out.println(metod);
		// TODO: revisar el usuario del token y el permiso de acceso al servicio
		if (!LoginRest.tokens.containsKey(token)) {
			RespuestaDTO dto = new RespuestaDTO(null, "No Autorizado", "-3");
			Response res = Response.status(401).entity(dto).build();
			ctxReq.abortWith(res);
		}
		int usere = LoginRest.tokens.get(token);
		if (meto != null) {
			List<Acceso> accs = acc.listarServicios(usere);
			//TODO: volver a poner en false, se coloca en true para probar ya que no hay registros en BD.
			boolean ex = true;
			if (accs != null) {
				for (int i = 0; i < accs.size(); i++) {
					// System.out.println(accs.get(i).getUrl());
					if (accs.get(i).getUrl().equals(metod)) {
						ex = true;
					}
				}
				if (!ex) {

					RespuestaDTO dto = new RespuestaDTO(null, "Servicio no Autorizado", "-3");
					Response res = Response.status(401).entity(dto).build();
					ctxReq.abortWith(res);

				}
			}
		}

	}

}
