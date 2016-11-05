package co.edu.eam.ingesoft.pa2.registrodocentes.bo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.SesionCurso;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.ConstantesNamedQueries;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.EJBGenerico;

/**
 * 
 * @author Laura
 *
 */  
@Stateless
@LocalBean
public class SesionCursoTiempoEJB extends EJBGenerico<SesionCurso> {

	@Override
	public Class getClase() {
		return SesionCurso.class;
	}

	/**
	 * Calcular tiempo total de registros de sesiones de curso del docente en
	 * una asignatura en el semestre
	 * 
	 * @param docente
	 * @param asignatura
	 * @param anho
	 * @param periodo
	 * @return tiempo total de registros de sesiones de curso
	 */
	public int tiempoSemestre(int docente, String asignatura) {
		try {
			Date fecha = new Date();
			String formato = "yyyy";
			SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
			int anho = Integer.parseInt(dateFormat.format(fecha));

			String formato2 = "MM";
			SimpleDateFormat dateFormat2 = new SimpleDateFormat(formato2);
			int mes = Integer.parseInt(dateFormat2.format(fecha));

			int periodo = 0;
			if (mes <= 06) {
				periodo = 1;
			} else {
				periodo = 2;
			}
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

	/**
	 * Calcular tiempo total de registros de sesiones de curso del docente en
	 * una asignatura de cada mes
	 * 
	 * @param mes
	 * @param docente
	 * @param asignatura
	 * @param anho
	 * @param periodo
	 * @return tiempo total
	 */
	public int tiempoMes(int docente, String asignatura) {
		try {
			Date fecha = new Date();
			String formato = "yyyy";
			SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
			int anho = Integer.parseInt(dateFormat.format(fecha));

			String formato2 = "MM";
			SimpleDateFormat dateFormat2 = new SimpleDateFormat(formato2);
			int mes = Integer.parseInt(dateFormat2.format(fecha));

			int periodo = 0;
			if (mes <= 06) {
				periodo = 1;
			} else {
				periodo = 2;
			}
			List<Double> tiempoMes = dao.ejecutarNamedQuery(ConstantesNamedQueries.TIEMPO_MES, mes, docente, asignatura,
					anho, periodo);
			if (!tiempoMes.isEmpty()) {
				return Integer.valueOf(tiempoMes.get(0).intValue());
			}
		} catch (Exception e) {
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
