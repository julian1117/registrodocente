package co.edu.eam.ingesoft.pa2.registrodocentes.rest.dto;

public class AsignaturaDocenteDTO {
	
	
	private int docente;
	private String asignatura;
	private int semestre;
	private int periodo;
	
	
	public AsignaturaDocenteDTO() {
		// TODO Auto-generated constructor stub
	}   

	public AsignaturaDocenteDTO(int docente, String asignatura, int semestre, int periodo) {
		super();
		this.docente = docente;
		this.asignatura = asignatura;
		this.semestre = semestre;
		this.periodo = periodo;
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
