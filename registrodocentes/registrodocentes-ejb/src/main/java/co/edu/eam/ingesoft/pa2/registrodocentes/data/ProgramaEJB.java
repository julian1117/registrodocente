package co.edu.eam.ingesoft.pa2.registrodocentes.data;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Programa;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.ConstantesNamedQueries;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.EJBGenerico;

@LocalBean
@Stateless
public class ProgramaEJB extends EJBGenerico<Programa>{

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Programa.class;
	}
	
	
	public List<Programa> listarProgramas(){
		return dao.ejecutarNamedQuery(ConstantesNamedQueries.LISTAR_PROGRAMAS);
	}

}
