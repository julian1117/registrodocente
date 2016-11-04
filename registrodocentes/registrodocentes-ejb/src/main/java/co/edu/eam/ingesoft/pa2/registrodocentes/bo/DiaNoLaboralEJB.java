package co.edu.eam.ingesoft.pa2.registrodocentes.bo;


import java.util.Date;
import java.util.List;

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
	
  
	
	public boolean crear(DiaNoLaboralDTO dto){
		if(dto != null){
		Semestre semestre = dto.getSemestre();
		Date fecha = dto.getFecha();
		String causa = dto.getCausa();
		DiaNoLaborable dia = new DiaNoLaborable(fecha, causa, semestre);
		dao.persistir(dia);
		return true;
		}else{
			return false;
		}
	}
	
	
	
	
	
	
	public boolean eliminar(long id){
		
		DiaNoLaborable dia = dao.obtenerReferencia(DiaNoLaborable.class, id);
		
		if(dia != null){
		
		dao.eliminar(dia);
		return true;
		}else{
			return false;
		}
	}
	
	
	
	public List<DiaNoLaborable> listarDias(int anho, int periodo){
		return dao.ejecutarNamedQuery(ConstantesNamedQueries.LISTAR_DIAS_NO_LABORALES, anho, periodo );
	}
	
}
