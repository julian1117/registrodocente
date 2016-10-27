package co.edu.eam.ingesoft.pa2.registrodocentes.util;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Clase EJB encargada de inicializar el EntityManager, contiene las actividades
 * básicas de un ejb
 * 
 * @author Brian David Tafur Londoño<br/>
 *         email: tafur2401@gmail.com <br/>
 *         Fecha: 27 de oct. de 2016<br/>
 */
public abstract class EJBGenerico<T> {

	/**
	 * Se inicializa el entity manager
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * Instancia del DAO Genérico
	 */
	protected DAOGenerico dao;

	/**
	 * Método encargado de iniciar el dao, después de ser construido el EJB
	 * 
	 * @author Brian David Tafur Londoño<br/>
	 *         email: tafur2401@gmail.com <br/>
	 *         Fecha: 27 de oct. de 2016<br/>
	 */
	@PostConstruct
	public void inicializar() {
		dao = new DAOGenerico(em);
	}

	/**
	 * Método para persistir una entidad
	 * 
	 * @author Brian David Tafur Londoño<br/>
	 *         email: tafur2401@gmail.com <br/>
	 *         Fecha: 27 de oct. de 2016<br/>
	 * @param entidad,
	 *            la entidad que se desea persistir
	 * @throws ExcepcionNegocio
	 */
	public void crear(T entidad) throws ExcepcionNegocio {
		dao.persistir(entidad);
	}

	/**
	 * Método para editar una entidad
	 * 
	 * @author Brian David Tafur Londoño<br/>
	 *         email: tafur2401@gmail.com <br/>
	 *         Fecha: 27 de oct. de 2016<br/>
	 * @param entidad,
	 *            la entidad editada que se proporciona para realizar el cambio
	 * @throws ExcepcionNegocio
	 */
	public void editar(T entidad) throws ExcepcionNegocio {
		dao.actualizar(entidad);
	}

	/**
	 * Método para eliminar una entidad
	 * 
	 * @author Brian David Tafur Londoño<br/>
	 *         email: tafur2401@gmail.com <br/>
	 *         Fecha: 27 de oct. de 2016<br/>
	 * @param entidad,
	 *            la entidad que se desea eliminar
	 * @throws ExcepcionNegocio
	 */
	public void eliminar(T entidad) throws ExcepcionNegocio {
		dao.eliminar(entidad);
	}

	/**
	 * Método para buscar une entidad por su pk
	 * 
	 * @author Brian David Tafur Londoño<br/>
	 *         email: tafur2401@gmail.com <br/>
	 *         Fecha: 27 de oct. de 2016<br/>
	 * @param entidad,
	 *            el tipo de entidad que se desea buscar
	 * @param pk,
	 *            la pk de la entidad a buscar
	 * @return la entidad si la encuentra, de lo contrario null
	 */
	public T buscar(Object pk) {
		return (T) dao.encontrarPorId(getClase(), pk);
	}

	/**
	 * Método...
	 * @author Brian David Tafur Londoño<br/>
	 *         email: tafur2401@gmail.com <br/>
	 *         Fecha: 27 de oct. de 2016<br/>
	 * @return
	 */
	public abstract Class getClase();

}
