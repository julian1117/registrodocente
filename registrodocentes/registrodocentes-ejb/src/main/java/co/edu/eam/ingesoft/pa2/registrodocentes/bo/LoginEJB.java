package co.edu.eam.ingesoft.pa2.registrodocentes.bo;

import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Usuario;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.ConstantesNamedQueries;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.EJBGenerico;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.MD5Util;

/**
 * 
 * @author Jairo Andres
 *
 */
@LocalBean
@Stateless
public class LoginEJB extends EJBGenerico<Usuario> {

	@Override
	public Class getClase() {
		return Usuario.class;
	}

	/**
	 * Metodo para buscar un usuario
	 * 
	 * @param user
	 *            el usuario a buscar
	 * @param pass
	 *            la contrasenia del usuario
	 * @return el usuario si lo encuentra, de lo contrario excepcion
	 */
	public Usuario buscarUsuario(String user, String pass) {
		// pass = MD5Util.code(pass);
		List<Usuario> lista = dao.ejecutarNamedQuery(ConstantesNamedQueries.BUSCAR_POR_USER_PASS, user, pass);
		if (!lista.isEmpty()) {
			return lista.get(0);
		} else {
			return null;
		}
	}

}
