package co.edu.eam.ingesoft.pa2.registrodocentes.util;

/**
 * 
 * Clase responsable de alojar los nombres de las NAMEDQUeries <br>
 * 
 * @author EAM <br>
 *         Camilo Andres Ferrer Bustos<br>
 * 
 * 
 * @date 19/10/2016
 * @version 1.0
 */
public class ConstantesNamedQueries {
	
	/*ASIGNATURA DOCENTE LAURA*/
	public static final String LISTAR_CURSO_DOCENTE = "Curso.listarCursoDocente";
	public static final String TIEMPO_SEMESTRE = "SesionCurso.TiempoSemestre";
	public static final String REGISTROS_APROBADOS = "Registro.listarAprobados";
	public static final String LISTAR_REGISTROS = "Registro.listarTodos";
	public static final String TIEMPO_MES = "SesionCurso.TiempoMes";
	
	
	
	public static final String LISTAR_PROGRAMAS = "Programa.listarTodos";
	
	
	public static final String LISTAR_ROLES_USUARIO = "Rol.listarRolesUsuario";

	
	public static final String BUSCAR_POR_USERNAME = "Usuario.buscarUser";
	
	
	
	
	
	private ConstantesNamedQueries() {
		// TODO Auto-generated constructor stub
	}

}
