package co.edu.eam.ingesoft.pa2.registrodocentes.bo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Registro;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.ConstantesNamedQueries;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.EJBGenerico;

/**
 * 
 * @author Laura
 * 
 */
@Stateless
@LocalBean
public class RegistroSesionCursoEJB extends EJBGenerico<Registro> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Registro.class;
	}

	/**
	 * Calcular porcentaje de registros apobados de la asignatura del docente
	 * 
	 * @param docente
	 * @param asignatura
	 * @param semestre
	 * @param periodo
	 * @return porcentajeAprobados, procentaje de registros aprobados
	 */
	public double registrosAprobados(int docente, String asignatura) {
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
			List<Long> registrosAprobados = dao.ejecutarNamedQuery(ConstantesNamedQueries.REGISTROS_APROBADOS,
					asignatura, docente, anho, periodo);
			List<Long> registrosTodos = dao.ejecutarNamedQuery(ConstantesNamedQueries.LISTAR_REGISTROS_SESION,
					asignatura, docente, anho, periodo);
			if (!registrosTodos.isEmpty()) {
				if (!registrosAprobados.isEmpty()) {
					double porcentajeAprobados = (registrosAprobados.get(0) * 100) / registrosTodos.get(0);
					return porcentajeAprobados;
				} else {
					return 0;
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		return 0;

	}

}
