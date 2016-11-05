package co.edu.eam.ingesoft.pa2.registrodocentes.rest.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.registrodocentes.bo.AsignaturaDocenteEJB;
import co.edu.eam.ingesoft.pa2.registrodocentes.bo.RegistroSesionCursoEJB;
import co.edu.eam.ingesoft.pa2.registrodocentes.bo.SesionCursoTiempoEJB;
import co.edu.eam.ingesoft.pa2.registrodocentes.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Asignatura;
import co.edu.eam.ingesoft.pa2.registrodocentes.rest.dto.CalcularTiemposDTO;

@Path("/asignatura")
public class AsignaturaDocenteRest {

	@EJB
	private AsignaturaDocenteEJB asignaturaEJB;

	@EJB
	private SesionCursoTiempoEJB sesionCursoEJB;
 
	@EJB
	private RegistroSesionCursoEJB registroEJB;

	@Path("/listarAsignaturas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@POST
	public RespuestaDTO listarAsignatura(@FormParam(value = "docente") int docente) {

		List<Asignatura> lista = asignaturaEJB.listarAsignatura(docente);
		if (lista.isEmpty()) {
			return new RespuestaDTO(null, "El doncente no dicta ninguna asignatura", "-1");
		} else
			return new RespuestaDTO(lista);

	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/calcular")
	public RespuestaDTO calcular(@FormParam(value = "docente") int docente,
			@FormParam(value = "asignatura") String asignatura) {

		int tiempoSem = sesionCursoEJB.tiempoSemestre(docente, asignatura);
		int tiempoMes = sesionCursoEJB.tiempoMes(docente, asignatura);
		double porcentajeAprobados = registroEJB.registrosAprobados(docente, asignatura);
		CalcularTiemposDTO c = new CalcularTiemposDTO(tiempoSem + " h", tiempoMes + " h", porcentajeAprobados + "%");

		if (tiempoMes == 0 && tiempoSem == 0 && porcentajeAprobados == 0) {
			return new RespuestaDTO(null, "No hay registros", "-1");
		} else {
			return new RespuestaDTO(c);
		}
	}

}
