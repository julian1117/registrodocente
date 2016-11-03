/**
 * 
 */
package co.edu.eam.ingesoft.pa2.registrodocentes.data;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Curso;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Docente;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.ConstantesNamedQueries;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.EJBGenerico;

/**
 * @author Alejandro
 *
 */
@LocalBean
@Stateless
public class CursosEJB extends EJBGenerico<Curso>{

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Curso.class;
	}

	/**
	 * Query para listar todos los cursos de un profesor en determinada fecha y en cierto periodo
	 * @return, lista de cursos
	 */
	public List<Curso> listaCursos(int anio, int periodo, int docente){
		return dao.ejecutarNamedQuery(ConstantesNamedQueries.LISTAR_CURSOS, anio, periodo, docente);
	}
}
