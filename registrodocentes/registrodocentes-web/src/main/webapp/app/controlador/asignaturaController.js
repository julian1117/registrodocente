/**
 * Laura
 * Controlador para las funciones sobre la vista asignturas.html
 */

app.controller("asignaturaController", function($scope, $http, httpservice,
		$window, $sessionStorage,$location) {
	 var res = filtrod($window,$location);
		if (res == true) {
	/**
	 * Codigo docente
	 */
	$scope.docente = '';
	/**
	 * codigo asignatura
	 */
	$scope.asignatura = '';
	/**
	 * lista asignaturas
	 */
	$scope.listaAsignaturas = [];
	/**
	 * total horas por semestre
	 */
	$scope.horasSemestre = '';
	/**
	 * total horas por mes
	 */
	$scope.horasMes = '';
	/**
	 * porcentaje de registros aprobados
	 */
	$scope.porcentaje = '';
	
	 $sessionStorage.docente=$sessionStorage.docenteid;
	
	
	/**
	 * Metodo para listar asignaturas
	 */

	$scope.cargarAsignaturas = function() {
		httpservice.post('../rest/asignatura/listarAsignaturas', {
			docente : $sessionStorage.docente 
		}, success = function(data, status, headers, config) {
			$scope.listaAsignaturas = data.obj;
		}, null, "application/x-www-form-urlencoded");
	}

	/**
	 * Funcion para calcular las horas registradas en el mes y el semestre y los
	 * registros aprobados
	 */
	$scope.calcular = function(a) {

		var xsrf = $.param({
			docente : $sessionStorage.docente,
			asignatura : a.id
		});
		$http({
			url : '../rest/asignatura/calcular',
			method : "POST",
			data : xsrf,
			headers : {
				"Content-Type" : "application/x-www-form-urlencoded"
			}
		}).success(function(data, status, headers, config) {
			if (data.codigo == '00') {
				$scope.horasSemestre = data.obj.tiempoSem;

				$scope.horasMes = data.obj.tiempoMes;
				$scope.porcentaje = data.obj.porcentajeAprobados;

			} else {
				alert(data.mensaje);
			}
		}).error(function(data, status, headers, config) {
			alert('error::' + data.mensaje);
		});
	};

	/**
	 * constructor
	 */
	$scope.iniciar = function() {
		$scope.cargarAsignaturas();
	}
	$scope.iniciar()

	/**
	 * Redicrrecionamiento
	 */
	$scope.ver = function(asignatura) {
		$sessionStorage.codeDoc = $sessionStorage.docente;
		$sessionStorage.codeAsig = asignatura.id;
		window.location.href = '../app/#/aprobar-registro';
	}
		}
});
