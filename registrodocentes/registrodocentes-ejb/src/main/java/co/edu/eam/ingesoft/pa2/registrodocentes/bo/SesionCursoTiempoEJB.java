package co.edu.eam.ingesoft.pa2.registrodocentes.bo;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.SesionCurso;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.ConstantesNamedQueries;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.EJBGenerico;

@Stateless
@LocalBean
public class SesionCursoTiempoEJB extends EJBGenerico<SesionCurso> {

	@Override
	public Class getClase() {
		return SesionCurso.class;
	}

	public int tiempoSemestre(int docente, String asignatura, int anho, int periodo) {
		try {
			List<Double> tiempoSemestre = dao.ejecutarNamedQuery(ConstantesNamedQueries.TIEMPO_SEMESTRE, docente,
					asignatura, anho, periodo);
			if (!tiempoSemestre.isEmpty()) {
				return Integer.valueOf(tiempoSemestre.get(0).intValue());
			}
		} catch (Exception e) {
			return 0;
		}
		return 0;
	}

	public int tiempoMes(int mes, int docente, String asignatura, int anho, int periodo) {
		try {
			List<Double> tiempoMes = dao.ejecutarNamedQuery(ConstantesNamedQueries.TIEMPO_MES, mes, docente, asignatura,
					anho, periodo);
			if (!tiempoMes.isEmpty()) {
				return Integer.valueOf(tiempoMes.get(0).intValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 0;
	}

	/**
	 * Método para listar las sesiones de un curso
	 * 
	 * @author Brian David Tafur Londoño<br/>
	 *         email: tafur2401@gmail.com <br/>
	 *         Fecha: 4 de nov. de 2016<br/>
	 * @param cod,
	 *            código del curso al que se le listarán las sesiones
	 * @return una lista con todas las sesiones que tenga el curso
	 */
	public List<SesionCurso> listarSesionesCurso(String cod) {
		return dao.ejecutarNamedQuery(ConstantesNamedQueries.LISTAR_SESIONES_CURSO, cod);
	}

}
