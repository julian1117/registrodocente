/**
 * 
 */
package co.edu.eam.ingesoft.pa2.registrodocentes.bo;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Registro;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.ConstantesNamedQueries;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.EJBGenerico;

/**
 * @author Alejandro
 *
 */
@LocalBean
@Stateless
public class RegistroCursoEJB extends EJBGenerico<Registro> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Registro.class;
	}
	
	/**
	 * Lista con los registros de un docente
	 * @return, los registros del docente
	 */
	public List<Registro> listarRegistro(int docente){
		return dao.ejecutarNamedQuery(ConstantesNamedQueries.LISTAR_REGISTROS_DOCENTE, docente);
	}

	
}
