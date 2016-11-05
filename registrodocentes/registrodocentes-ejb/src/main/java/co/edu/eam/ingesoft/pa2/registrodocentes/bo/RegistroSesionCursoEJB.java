package co.edu.eam.ingesoft.pa2.registrodocentes.bo;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Registro;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.ConstantesNamedQueries;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.EJBGenerico;
   
@Stateless
@LocalBean
public class RegistroSesionCursoEJB extends EJBGenerico<Registro> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Registro.class;
	}     
	

	public double registrosAprobados(int docente, String asignatura, int semestre, int periodo) {
		try {
			List<Long> registrosAprobados = dao.ejecutarNamedQuery(ConstantesNamedQueries.REGISTROS_APROBADOS,
					asignatura, docente, semestre, periodo);
			List<Long> registrosTodos = dao.ejecutarNamedQuery(ConstantesNamedQueries.LISTAR_REGISTROS_SESION, 
					asignatura, docente, semestre, periodo);
			if (!registrosTodos.isEmpty()) {
				if (!registrosAprobados.isEmpty()) {
					double porcentajeAprobados = (registrosAprobados.get(0) * 100) / registrosTodos.get(0);
					return porcentajeAprobados;
				} else {
					return 0;
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
		return 0;

	}

}
