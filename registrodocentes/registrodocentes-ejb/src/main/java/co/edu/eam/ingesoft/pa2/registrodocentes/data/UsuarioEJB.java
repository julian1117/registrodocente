/**
 * 
 */
package co.edu.eam.ingesoft.pa2.registrodocentes.data;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Usuario;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.ConstantesNamedQueries;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.EJBGenerico;

/**
 * @author Alejandro
 *
 */
@LocalBean
@Stateless
public class UsuarioEJB extends EJBGenerico<Usuario>{

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Usuario.class;
	}

	public List<Usuario> listaUsuario() {
		return dao.ejecutarNamedQuery(ConstantesNamedQueries.LISTAR_USUARIOS);
	}
	
	
	
	
}
