package co.edu.eam.ingesoft.pa2.registrodocentes.bo;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Rol;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.DAOGenerico;

@LocalBean
@Stateless
public class RolEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	private DAOGenerico dao;
	
	@PostConstruct
	public void init(){
		dao = new DAOGenerico(em);
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
}