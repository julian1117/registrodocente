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
import co.edu.eam.ingesoft.pa2.registrodocentes.util.ExcepcionNegocio;

/**
 * @author Alejandro
 *
 */
@LocalBean
@Stateless
public class UsuarioEJB extends EJBGenerico<Usuario> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Usuario.class;
	}

	public List<Usuario> listaUsuario() {
		return dao.ejecutarNamedQuery(ConstantesNamedQueries.LISTAR_USUARIOS);
	}

	/**
	 * Metodo para crear un nombre de usuario.
	 */
	@Override
	public void crear(Usuario entidad) throws ExcepcionNegocio {
		// busca los usuario por nombre usuario
		List<Usuario> lista = dao.ejecutarNamedQuery(ConstantesNamedQueries.CONSULTAR_USUARIO_POR_USER,
				entidad.getUsuario());
		// si no hay se puede crear.
		if (lista.isEmpty()) {

			super.crear(entidad);
		}else{
			throw new ExcepcionNegocio("Ya existe el usuario");
		}
	}

	@Override
	public void eliminar(Usuario entidad) throws ExcepcionNegocio {
		// TODO Auto-generated method stub
		Usuario us=buscar(entidad.getId());
		if(us!=null){
		super.eliminar(us);
		}else{
			throw new ExcepcionNegocio("No existe el usuario");
		}
	}
}
