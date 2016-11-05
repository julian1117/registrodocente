package co.edu.eam.ingesoft.pa2.registrodocentes.rest.dto;

public class CalcularTiemposDTO {
	
	private String tiempoSem;
	private String tiempoMes;
	private String porcentajeAprobados;
	
	public CalcularTiemposDTO() {
		// TODO Auto-generated constructor stub
	}
 
	public CalcularTiemposDTO(String tiempoSem, String tiempoMes, String porcentajeAprobados) {
		super();
		this.tiempoSem = tiempoSem;
		this.tiempoMes = tiempoMes;
		this.porcentajeAprobados = porcentajeAprobados;
	}

	public String getTiempoSem() {
		return tiempoSem;
	}

	public void setTiempoSem(String tiempoSem) {
		this.tiempoSem = tiempoSem;
	}

	public String getTiempoMes() {
		return tiempoMes;
	}

	public void setTiempoMes(String tiempoMes) {
		this.tiempoMes = tiempoMes;
	}

	public String getPorcentajeAprobados() {
		return porcentajeAprobados;
	}

	public void setPorcentajeAprobados(String porcentajeAprobados) {
		this.porcentajeAprobados = porcentajeAprobados;
	}
	
	

}
