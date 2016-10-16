package co.edu.eam.ingesoft.pa2.registrodocentes.util;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class ExcepcionNegocio extends RuntimeException {

	
	public ExcepcionNegocio(String mejs) {
		super(mejs);
	}
}
