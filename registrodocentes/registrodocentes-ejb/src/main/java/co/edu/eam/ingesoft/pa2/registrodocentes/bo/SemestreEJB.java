package co.edu.eam.ingesoft.pa2.registrodocentes.bo;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Semestre;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.SemestrePK;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.ConstantesNamedQueries;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.EJBGenerico;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.ExcepcionNegocio;


@Stateless
@LocalBean
public class SemestreEJB extends EJBGenerico<Semestre> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Semestre.class;
	}

	 
	  /**
	 * Metodo para crear un semestre
	 * @param fecha , la fecha del inicio del semestre
	 * @return true si se persiste
	 */
	public boolean crear(Date fecha) {

		if (fecha != null) {
			String formato = "yyyy";
			SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
			int anho = Integer.parseInt(dateFormat.format(fecha));

			String formato2 = "MM";
			SimpleDateFormat dateFormat2 = new SimpleDateFormat(formato2);
			int mes = Integer.parseInt(dateFormat2.format(fecha));

			int periodo = 0;
			if (mes <= 6) {
				periodo = 1;
			} else {
				periodo = 2;
			}
			if (buscarSemestre(anho, periodo).isEmpty()) {
				Semestre semestre = new Semestre(fecha, anho, periodo);
				dao.persistir(semestre);
			} else {
				throw new ExcepcionNegocio("este semestre ya se encuentra creado");
			}
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Lista todos los semestres
	 * @return la lista de semestres
	 */
	public List<Semestre> listarSemestres(){
		return dao.ejecutarNamedQuery(ConstantesNamedQueries.LISTA_SEMESTRES);
	}
	
	
	
	/**
	 * Lista semestres por su a�o y periodo
	 * @return lista de sememestres
	 */
	public List<Semestre> buscarSemestre(int anio, int periodo){
		return dao.ejecutarNamedQuery(ConstantesNamedQueries.BUSCAR_SEMESTRE, anio, periodo);
	}	
	
	
	/**
	 * Metodo para eliminar un semestre
	 * @param anho del semestre, periodo del semestre
	 * @return true si lo elimina
	 */
	public boolean eliminar(int anio, int periodo){
		Semestre se = buscarSemestre(anio, periodo).get(0);
		if(se != null){
			dao.eliminar(se);
			return true;
		}
		return false;
	}
}
