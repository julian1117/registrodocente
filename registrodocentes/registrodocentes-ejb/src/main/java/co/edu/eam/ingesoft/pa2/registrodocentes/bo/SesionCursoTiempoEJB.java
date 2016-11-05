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
		// TODO Auto-generated method stub
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

	public int tiempoMes( int mes, int docente, String asignatura, int anho, int periodo) {
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

}
