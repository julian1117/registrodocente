package co.edu.eam.ingesoft.pa2.registrodocentes.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Asignatura;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Curso;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Programa;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.ConstantesNamedQueries;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.EJBGenerico;

@Stateless
@LocalBean
public class AsignaturaDocenteEJB extends EJBGenerico<Asignatura>  {
	

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Asignatura.class;
	}
	
	public List<Asignatura> listarAsignatura(int docente){
		List<Curso> listaCurso = dao.ejecutarNamedQuery(ConstantesNamedQueries.LISTAR_CURSO_DOCENTE, docente);
		List<Asignatura> listaAsignatura = new ArrayList<>();
		for (int i = 0; i < listaCurso.size(); i++) {
			listaAsignatura.add(listaCurso.get(i).getAsignatura());
			
		}
		return listaAsignatura;
	}
	
	
	
	
	

	
	

}
