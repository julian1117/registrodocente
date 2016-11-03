package co.edu.eam.ingesoft.pa2.registrodocentes.rest.servicios;


import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.registrodocentes.bo.DiaNoLaboralEJB;
import co.edu.eam.ingesoft.pa2.registrodocentes.bo.SemestreEJB;
import co.edu.eam.ingesoft.pa2.registrodocentes.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Semestre;



@Path("/semestre")
public class SemestreRest {

	@EJB
	private SemestreEJB semestreEjb;

	
	
	@EJB
	private DiaNoLaboralEJB diaNoLaborableEjb;

	public SemestreRest() {
		// TODO Auto-generated constructor stub
	}

	@Path("/crearSemestre")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public RespuestaDTO crearSemestre(@FormParam(value = "fecha") Date fecha) {
		System.out.println(fecha+"entroooooooooooooooo");
		if (semestreEjb.crear(fecha)) {
			return new RespuestaDTO(true, "semestre creado correctamente", "00");
		} else {
			return new RespuestaDTO(false, "error al crear", "-1");
		}
	}

	@Path("/listarSemestres")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listarSemestres() {
		List<Semestre> semestres = semestreEjb.listarSemestres();
		if (semestres.isEmpty()) {
			return new RespuestaDTO(null, "no hay semestres", "-1");
		} else {
			return new RespuestaDTO(semestres);
		}
	}
	
	
	@Path("/eliminarSemestre")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public RespuestaDTO eliminarSemestre(@FormParam(value = "anho") int anio, @FormParam(value = "periodo") int periodo ) {
		System.out.println("");
		if (semestreEjb.eliminar(anio, periodo)) {
			return new RespuestaDTO(true, "se elimino correctamente", "00");
		} else {
			return new RespuestaDTO(false, "error al eliminar", "-1");
		}
	
} 
	
//
//	@Path("/marcarDia")
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public RespuestaDTO marcarDia(DiaNoLaboralDTO dto) {
//		if (diaNoLaborableEjb.crear(dto)) {
//			return new RespuestaDTO(true, "el dia se marco correctamente", "00");
//		} else {
//			return new RespuestaDTO(false, "error al marcar dia", "-1");
//		}
//	}
}
