package co.edu.eam.ingesoft.pa2.registrodocentes.bo;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Asignatura;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Curso;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Programa;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.ConstantesNamedQueries;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.EJBGenerico;

/**
 * 
 * @author Laura
 *
 */
@Stateless
@LocalBean
public class AsignaturaDocenteEJB extends EJBGenerico<Asignatura> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Asignatura.class;
	}

	/**
	 * Listar asignaturas docente
	 * 
	 * @param docente,
	 *            codigo del docente
	 * @return listaAsignatura, la lista de asignaturas del docente
	 */
	public List<Asignatura> listarAsignatura(int docente) { // espera el codigo,
															// no el docente
															// como tal
		List<Curso> listaCurso = dao.ejecutarNamedQuery(ConstantesNamedQueries.LISTAR_CURSO_DOCENTE, docente);
		List<Asignatura> listaAsignatura = new ArrayList<>();
		for (int i = 0; i < listaCurso.size(); i++) {
			if (listaAsignatura.isEmpty()) {
				listaAsignatura.add(listaCurso.get(i).getAsignatura());
			}
			for (int j = 0; j < listaAsignatura.size(); j++) {
				if (listaAsignatura.get(j).getId() != listaCurso.get(i).getAsignatura().getId()) {
					listaAsignatura.add(listaCurso.get(i).getAsignatura());
				}
			}

		}
		return listaAsignatura;
	}

}
