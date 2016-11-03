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


@Stateless
@LocalBean
public class SemestreEJB extends EJBGenerico<Semestre> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Semestre.class;
	}

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
			Semestre semestre = new Semestre(fecha, anho, periodo);
			dao.persistir(semestre);
			return true;
		} else {
			return false;
		}
	}
	
	 
	public List<Semestre> listarSemestres(){
		return dao.ejecutarNamedQuery(ConstantesNamedQueries.LISTA_SEMESTRES);
	}
	
	
	
	public List<Semestre> buscarSemestre(int anio, int periodo){
		return dao.ejecutarNamedQuery(ConstantesNamedQueries.BUSCAR_SEMESTRE, anio, periodo);
	}	
	public boolean eliminar(int anio, int periodo){
		Semestre se = buscarSemestre(anio, periodo).get(0);
		if(se != null){
			dao.eliminar(se);
			return true;
		}
		return false;
	}
}
