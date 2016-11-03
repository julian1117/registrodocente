/**
 * 
 */
package co.edu.eam.ingesoft.pa2.registrodocentes.data;

import java.util.List;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Docente;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.ConstantesNamedQueries;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.EJBGenerico;

/**
 * @author Alejandro
 *
 */
public class RegSemAnterioresEJB extends EJBGenerico<Docente> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Docente.class;
	}

	/**
	 * 
	 * @return
	 
	public List<Docente> listaDocentes() {
		return dao.ejecutarNamedQuery(ConstantesNamedQueries.LISTAR_DOCENTES);
	}
	*/
}
