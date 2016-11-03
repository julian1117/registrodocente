package co.edu.eam.ingesoft.pa2.registrodocentes.bo;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.registrodocentes.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa2.registrodocentes.model.entidades.Registro;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.EJBGenerico;
import co.edu.eam.ingesoft.pa2.registrodocentes.util.InterfaceEJBRemote;

@LocalBean
@Stateless
public class BORegistroEJB extends EJBGenerico<Registro> implements InterfaceEJBRemote<Registro> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crear(Registro entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Registro buscar(Object pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(Registro entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Registro entidad) {
		// TODO Auto-generated method stub
		
	}
	
	public RespuestaDTO listarRegistros(){
		return null;
	}
	

}
