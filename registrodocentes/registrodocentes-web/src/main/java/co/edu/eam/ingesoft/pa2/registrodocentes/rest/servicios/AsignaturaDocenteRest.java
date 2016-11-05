package co.edu.eam.ingesoft.pa2.registrodocentes.rest.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.registrodocentes.ejb.AsignaturaDocenteEJB;
import co.edu.eam.ingesoft.pa2.registrodocentes.ejb.RegistroSesionCursoEJB;
import co.edu.eam.ingesoft.pa2.registrodocentes.ejb.SesionCursoTiempoEJB;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Asignatura;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.SesionCurso;
import co.edu.eam.ingesoft.pa2.registrodocentes.rest.dto.AsignaturaDocenteDTO;
import co.edu.eam.ingesoft.pa2.registrodocentes.rest.dto.RegistroSesionCursoDTO;
import co.edu.eam.ingesoft.pa2.registrodocentes.rest.dto.RespuestaDTO;

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
	public RespuestaDTO listarAsignatura(@FormParam(value = "docente") int usuario) {

		List<Asignatura> lista = asignaturaEJB.listarAsignatura(usuario);
		if (lista.isEmpty()) {
			return new RespuestaDTO(null, "El doncente no dicta ninguna asignatura", "-1");
		} else
			return new RespuestaDTO(lista);

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/tiempoSemestre")
	public RespuestaDTO tiempoSemestre(AsignaturaDocenteDTO a) {

		int tiempo = sesionCursoEJB.tiempoSemestre(a.getDocente(), a.getAsignatura(), a.getSemestre(), a.getPeriodo());
		if (tiempo == 0) {
			return new RespuestaDTO(null, "No hay horas registradas", "-1");
		} else {
			return new RespuestaDTO(tiempo);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/tiempoMes")
	public RespuestaDTO tiempoMes(RegistroSesionCursoDTO a) {

		int tiempo = sesionCursoEJB.tiempoMes(a.getMes(), a.getDocente(), a.getAsignatura(), a.getSemestre(), a.getPeriodo());
		if (tiempo == 0) {
			return new RespuestaDTO(null, "No hay horas registradas", "-1");
		} else {
			return new RespuestaDTO(tiempo);
		}
	}

	@Path("/registrosAprobados")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public RespuestaDTO registrosAprobados(AsignaturaDocenteDTO dto) {
		double porcentajeAprobados = registroEJB.registrosAprobados(dto.getDocente(), dto.getAsignatura(),
				dto.getSemestre(), dto.getPeriodo());
		if (porcentajeAprobados == -1) {
			return new RespuestaDTO(null, "La asigntura no contiene registros", "-1");
		} else {

			return new RespuestaDTO(porcentajeAprobados + "%");
		}
	}

}
