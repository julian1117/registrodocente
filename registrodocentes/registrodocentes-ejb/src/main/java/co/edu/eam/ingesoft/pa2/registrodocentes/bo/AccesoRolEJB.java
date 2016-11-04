package co.edu.eam.ingesoft.pa2.registrodocentes.bo;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Acceso;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Rol;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.ConstantesNamedQueries;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.EJBGenerico;

/**
 * 
 * @author Jairo Andres
 *
 */ 
@LocalBean
@Stateless
public class AccesoRolEJB extends EJBGenerico<Acceso> {
	/**
	 * lista de roles
	 */
	private List<Rol> lista;

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Acceso.class;
	}

	/**
	 * metodo que lista los roles de un suario
	 * 
	 * @param user
	 *            el usuario
	 * @return una lista con los roles de un usuario
	 */
	public List<Rol> listarRoles(String user) {
		lista = new ArrayList<>();
		lista = dao.ejecutarNamedQuery(ConstantesNamedQueries.BUSCAR_ROL_USER, user);
		return lista;
	}

	/**
	 * metodo que lista los accesos de los roles
	 * 
	 * @return una lista de accesos
	 */
	public List<Acceso> listarAccesos() {
		List<Acceso> accesos = new ArrayList<>();
		if (!lista.isEmpty()) {
			for (int i = 0; i < lista.size(); i++) {
				List<Acceso> accesosRol = dao.ejecutarNamedQuery(ConstantesNamedQueries.BUSCAR_ACCESO_ROL,
						lista.get(i));
				if (!accesosRol.isEmpty()) {
					for (int j = 0; j < accesosRol.size(); j++) {
						accesos.add(accesosRol.get(j));
					}
				}
			}
		}
		return accesos;
	}

}
