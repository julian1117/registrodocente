package co.edu.eam.ingesoft.pa2.registrodocentes.bo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.registrodocentes.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Registro;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.ConstantesNamedQueries;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.EJBGenerico;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.InterfaceEJBRemote;

@LocalBean
@Stateless
public class BORegistroEJB extends EJBGenerico<Registro> implements InterfaceEJBRemote<Registro> {

	@Override
	public Class getClase() {
		return Registro.class;
	}

	@Override
	public void crear(Registro entidad) {
		dao.persistir(entidad);
	}

	@Override
	public Registro buscar(Object pk) {
		return dao.encontrarPorId(Registro.class, pk);
	}

	@Override
	public void editar(Registro entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Registro entidad) {
		// TODO Auto-generated method stub

	}

	/**
	 * Metodo para listar los registros
	 * 
	 * @author Brayan Giraldo Correo : giraldo97@outlook.com
	 */
	public List<Registro> listarRegistros() {
		return dao.ejecutarNamedQuery(ConstantesNamedQueries.LISTAR_REGISTROS);
	}

	/**
	 * Método para listar los registros realizados por un docente en una
	 * asignatura 8 días antes y 8 días después de la fecha actual
	 * 
	 * @author Brian David Tafur Londoño<br/>
	 *         email: tafur2401@gmail.com <br/>
	 *         Fecha: 3 de nov. de 2016<br/>
	 * @param cod, código de la asignatura a la que se le buscan los registros
	 * @param ced, cédula del docente que realiza los registros
	 * @return una lista con todos los registros realizados en ese rango de fechas
	 */
	public List<Registro> listarRegistroEntreFechas(String cod, int ced) {
		Calendar fechaInicial = Calendar.getInstance();
		fechaInicial.add(Calendar.DAY_OF_YEAR, -8);
		Calendar fechaFinal = Calendar.getInstance();
		fechaFinal.add(Calendar.DAY_OF_YEAR, 8);

		List<Registro> lista = dao.ejecutarNamedQuery(ConstantesNamedQueries.LISTAR_REGISTROS_ENTREFECHAS,
				fechaInicial.getTime(), fechaFinal.getTime(), cod, ced);
		return lista;
	}
	
	/**
	 * Metodo para listar los registros de un docente en una
	 * asignatura especifica sin aprobar
	 * @param idDoc, es la identificacion del docente
	 * @param idAsig, es la identificacion de la asignatura
	 * @author Brayan Giraldo
	 * Correo : giraldo97@outlook.com
	 */
    public List<Registro> listarRegistrosDocenteAsignaturaNA(int idDoc, String idAsig){
    	return dao.ejecutarNamedQuery(ConstantesNamedQueries.LISTAR_REGISTROS_DOCENTE_ASIGNATURA_NA,
    			                       idDoc, idAsig);
    }
    
    /**
     * Aprueba un registro 
     * @param id, es el registro a aprobar
     * @param comentario, es el comentario para el registro
     * @author Brayan Giraldo
     * Correo : giraldo97@outlook.com
     */
    public String aprobarRegistro(Long id, String comentario) {
    	Registro reg = buscar(id);
		if ( reg != null) {
			reg.setComentario(comentario);
			reg.setAprobadoCoord(true);
			reg.setAprobadoRH(true);
			dao.actualizar(reg);
			return "Aprobado Correctamente";
		} else {
			throw new ExcepcionNegocio("No se puede aprobar el registro "
					+ "con codigo " + id
					+ " ya que a�n no esta registrado");
		}

	}

}
