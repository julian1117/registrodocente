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

	/* ASIGNATURA DOCENTE LAURA */
	public static final String LISTAR_CURSO_DOCENTE = "Curso.listarCursoDocente";
	public static final String TIEMPO_SEMESTRE = "SesionCurso.TiempoSemestre";
	public static final String REGISTROS_APROBADOS = "Registro.listarAprobados";
	public static final String LISTAR_REGISTROS_SESION = "Registro.listarTodos";
	public static final String TIEMPO_MES = "SesionCurso.TiempoMes";
	public static final String LISTAR_ACCESOS_SERVICIOS_POR_USUARIO = "AccesoRol.ListarServiciosUsuario";
	public static final String LISTAR_SESIONES_CURSO = "SesionCurso.listarSesionesCurso";

	public static final String LISTAR_PROGRAMAS = "Programa.listarTodos";

	public static final String LISTAR_DOCENTES_POR_PROGRAMA = "Docente.listarPorPrograma";

	public static final String LISTAR_ROLES_USUARIO = "Rol.listarRolesUsuario";

	public static final String BUSCAR_POR_USERNAME = "Usuario.buscarUser";

	public static final String LISTAR_USUARIOS = "Usuario.listarUsuarios";

	public static final String LISTAR_CURSOS = "Curso.listarcursos";

	public static final String LISTAR_REGISTROS = "Registro.listar";

	public static final String BUSCAR_POR_USER_PASS = "Usuario.buscarUserPass";

	public static final String BUSCAR_ROL_USER = "Usuario.roles";

	public static final String BUSCAR_ACCESO_ROL = "Acceso.buscarRol";

	public static final String LISTAR_REGISTROS_ENTREFECHAS = "Registro.listarentrefechas";

	public static final String LISTAR_REGISTROS_DOCENTE_ASIGNATURA = "Registro.listarRegistrosDocenteAsignatura";

	public static final String LISTAR_REGISTROS_DOCENTE_ASIGNATURA_NA = "Registro.listarRegistrosDocenteAsignaturaNA";

	public static final String LISTA_SEMESTRES = "Semestre.listar";

	public static final String BUSCAR_SEMESTRE = "Semestre.buscarSemestres";

	public static final String LISTAR_DIAS_NO_LABORALES = "DiaNoLaborable.listarDias";
	public static final String LISTAR_REGISTROS_DOCENTE = "Registro.listarRegistroDocente";

	
	public static final String CONSULTAR_USUARIO_POR_USER="Usuario.buscarPorUsuario";
	private ConstantesNamedQueries() {
		// TODO Auto-generated constructor stub
	}

}
