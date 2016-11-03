package co.edu.eam.ingesoft.pa2.registrodocentes.util;

import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Usuario;

@LocalBean
@Stateless
public class LoginEJB extends EJBGenerico<Usuario> {

	@Override
	public Class getClase() {
		return Usuario.class;
	}

	public Usuario buscarUsuario(String user, String pass) {
		List<Usuario> lista = dao.ejecutarNamedQuery(ConstantesNamedQueries.BUSCAR_POR_USER_PASS, user, pass);
		if (!lista.isEmpty()) {
			return lista.get(0);
		} else {
			throw new ExcepcionNegocio("El usuario o la contraseña son incorrectos");
		}
	}

}
