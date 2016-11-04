package co.edu.eam.ingesoft.pa2.registrodocentes.bo;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Acceso;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Rol;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.DAOGenerico;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.EJBGenerico;

@LocalBean
@Stateless
public class RolEJB extends EJBGenerico<Acceso> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Rol.class;
	}
	
	/**
	 * Metodo para crear un rol
	 * @param rol, el Rol a crear
	 * @return True si lo creo, de lo contrario false
	 */
	public boolean crearRol(Rol rol){
		ArrayList<Rol> lista = (ArrayList<Rol>) dao.listarTodos(Rol.class);
		for (Rol rol2 : lista) {
			if(rol2.getDescripcion().equalsIgnoreCase(rol.getDescripcion())){
				return false;
			}
		}
		dao.persistir(rol);
		return true;
	}
	
	/**
	 * Metodo que busca un Rol por el nombre
	 * @param nombreRol, el nombre del Rol a buscar
	 * @return el Rol si lo encuentro, de lo contrario null
	 */
	public Rol buscarRol(String nombreRol) {
		ArrayList<Rol> lista = listarRoles();
		for (Rol rol2 : lista) {
			if(rol2.getDescripcion().equalsIgnoreCase(nombreRol)){
				return rol2;
			}
		}
		return null;
	}
	
	/**
	 * Metodo que lista todos los Roles
	 * @return la lista de Roles
	 */
	public ArrayList<Rol> listarRoles() {
		return (ArrayList<Rol>) dao.listarTodos(Rol.class);
	}
}