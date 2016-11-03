package co.edu.eam.ingesoft.pa2.registrodocentes.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Acceso;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.DAOGenerico;

@LocalBean
@Stateless
public class AccesoEJB {

	@PersistenceContext
	private EntityManager em;
	
	private DAOGenerico dao;
	
	@PostConstruct
	public void init() {
		dao = new DAOGenerico(em);
	}
	
	public List<Acceso> listarAcceso() {
		return dao.listarTodos(Acceso.class);
	}
}