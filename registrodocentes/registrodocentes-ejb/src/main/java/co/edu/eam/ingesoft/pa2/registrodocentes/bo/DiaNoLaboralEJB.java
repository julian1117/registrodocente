package co.edu.eam.ingesoft.pa2.registrodocentes.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.DiaNoLaborable;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Semestre;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.ConstantesNamedQueries;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.DiaNoLaboralDTO;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.EJBGenerico;

@Stateless
@LocalBean
public class DiaNoLaboralEJB extends EJBGenerico<DiaNoLaborable> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return DiaNoLaborable.class;
	}

	@EJB
	 SemestreEJB semestreEJb;
	
	
	
	/**
	 * Metodo para marcar()crear un dia no laboral
	 * @param dto , con los datos del semestre y del dia no laboral
	 * @return true si se persiste
	 */
	public boolean crear(DiaNoLaboralDTO dto) {
		if (dto != null) {

			
			Semestre semestre = semestreEJb.buscarSemestre(dto.getAnho(), dto.getPeriodo()).get(0);
			Date fecha = dto.getFechaNoLaboral();
			String causa = dto.getCausa();
			DiaNoLaborable dia = new DiaNoLaborable(fecha, causa, semestre);
			dao.persistir(dia);
			return true;
		} else {
			return false;
		}
	}

	
	/**
	 * Metodo para eliminar un semestre
	 * @param id , id del dia no laboral
	 * @return true si lo elimina
	 */
	public boolean eliminar(long id) {

		DiaNoLaborable dia = dao.obtenerReferencia(DiaNoLaborable.class, id);

		if (dia != null) {

			dao.eliminar(dia);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * lista los dias no laborales
	 * @param anho del semestre , periodo del semestre
	 * @return lista de dias
	 */
	public List<DiaNoLaborable> listarDias(int anho, int periodo) {
		List<DiaNoLaborable> li = new ArrayList<>();
		List<DiaNoLaborable> lista = dao.ejecutarNamedQuery(ConstantesNamedQueries.LISTAR_DIAS_NO_LABORALES);
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getSemestre().getAnho() == anho && lista.get(i).getSemestre().getPeriodo() == periodo) {
				li.add(lista.get(i));
			}
		}
		return li;
	}

}
