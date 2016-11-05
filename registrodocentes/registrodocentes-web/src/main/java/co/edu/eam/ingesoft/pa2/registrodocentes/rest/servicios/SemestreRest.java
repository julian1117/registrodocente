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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.registrodocentes.bo.DiaNoLaboralEJB;
import co.edu.eam.ingesoft.pa2.registrodocentes.bo.SemestreEJB;
import co.edu.eam.ingesoft.pa2.registrodocentes.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.DiaNoLaborable;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Semestre;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.DiaNoLaboralDTO;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.ExcepcionNegocio;



@Path("/semestre")
public class SemestreRest {

	//ejb de semestre
	@EJB
	 private SemestreEJB semestreEjb;
	
	//ejb del diaNoLaborable
	@EJB
	private DiaNoLaboralEJB diaNoLaborableEjb;

	public SemestreRest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo rest para crear un semestre
	 * @param fecha , la fecha del inicio del semestre
	 * @return RespuestaDTO true si se creo
	 */
	@Path("/crearSemestre")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public RespuestaDTO crearSemestre(@FormParam(value = "fecha") Date fecha) {
		try {
			if (semestreEjb.crear(fecha)) {
				return new RespuestaDTO(true, "semestre creado correctamente", "00");
			} else {
				return new RespuestaDTO(false, "error al crear", "-2");
			}
		} catch (ExcepcionNegocio e) {
			return new RespuestaDTO(false, e.getMessage(), "-1");
		}
	}

	/**
	 * metodo rest para listar los semestres
	 * @return Respuesta dto con la lista de semestres
	 */
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
	
	/**
	 * Metodo rest para eliinar un semestre
	 * @param anho del semestre, periodo del semestre
	 * @return RespuestaDTO true si se elimino corectamente
	 */
	@Path("/eliminarSemestre")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public RespuestaDTO eliminarSemestre(@FormParam(value = "anho") int anio, @FormParam(value = "periodo") int periodo ) {
		if (semestreEjb.eliminar(anio, periodo)) {
			return new RespuestaDTO(true, "se elimino correctamente", "00");
		} else {
			return new RespuestaDTO(false, "error al eliminar", "-1");
		}
	}

	
	/**
	 * Metodo rest para listar diasNoLaborales de un semestre
	 * @param anho del semestre, periodo del semestre
	 * @return RespuestaDTO lista de dias no laborales
	 */
	@Path("/listarDiasNoLaborales")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listarDiasNoLaborales(@FormParam(value = "anho") int anho ,@FormParam(value = "periodo") int periodo) {
		List<DiaNoLaborable> dias = diaNoLaborableEjb.listarDias(anho, periodo);
		if (dias.isEmpty()) {
			return new RespuestaDTO(null, "no hay dias no laborales registrados", "-1");
		} else {
			return new RespuestaDTO(dias);
		}
	}
	

	
	/**
	 * Metodo rest para Marcar o asignar un dia no laborales a un semestre
	 * @param dto , con el anho y periodo del semestre y la fecha y causa del dia
	 * @return RespuestaDTO true si se creo
	 */
	@Path("/marcarDia")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RespuestaDTO marcarDia(DiaNoLaboralDTO dto) {
		if (diaNoLaborableEjb.crear(dto)) {
			return new RespuestaDTO(true, "el dia se marco correctamente", "00");
		} else {
			return new RespuestaDTO(false, "error al marcar dia", "-1");
		}
	}
	
	
	
	/**
	 * Metodo rest para eliminar un dia no laboral de un semestre
	 * @param id , identificados del dia no laboral
	 * @return RespuestaDTO true si se elimino
	 */
	@Path("/eliminarDia")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public RespuestaDTO eliminarSemestre(@FormParam(value = "id") long id) {
		if (diaNoLaborableEjb.eliminar(id)) {
			return new RespuestaDTO(true, "se elimino correctamente", "00");
		} else {
			return new RespuestaDTO(false, "error al eliminar", "-1");
		}
	
} 
} 