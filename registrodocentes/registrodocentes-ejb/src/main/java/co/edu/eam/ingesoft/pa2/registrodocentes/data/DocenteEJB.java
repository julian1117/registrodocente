package co.edu.eam.ingesoft.pa2.registrodocentes.data;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Docente;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.ConstantesNamedQueries;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.EJBGenerico;

@LocalBean
@Stateless
public class DocenteEJB extends EJBGenerico<Docente>{

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Docente.class;
	}
	
	public List<Docente> listarDocentes(String codigo){
		return dao.ejecutarNamedQuery(ConstantesNamedQueries.LISTAR_DOCENTES_POR_PROGRAMA, codigo);
	}

}
