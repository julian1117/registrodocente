package co.edu.eam.ingesoft.pa2.registrodocentes.rest.dto;

public class RegistroSesionCursoDTO {
	
	private int mes;
	private int docente;
	private String asignatura;
	private int semestre;
	private int periodo;
	

	public RegistroSesionCursoDTO() {
		// TODO Auto-generated constructor stub
	}   

	public RegistroSesionCursoDTO(int mes, int docente, String asignatura, int semestre, int periodo) {
		super();
		this.mes = mes;
		this.docente = docente;
		this.asignatura = asignatura;
		this.semestre = semestre;
		this.periodo = periodo;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getDocente() {
		return docente;
	}

	public void setDocente(int docente) {
		this.docente = docente;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

}
