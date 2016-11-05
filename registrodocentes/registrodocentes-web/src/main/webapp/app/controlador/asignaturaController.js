app.controller("asignaturaController", function($scope, $http, httpservice,
		$window, $sessionStorage) {
	/**
	 * Codigo asignatura
	 */
	$scope.docente = '';
	$scope.asignatura = '';
	$scope.listaAsignaturas = [];
	$scope.horasSemestre = '';
	$scope.horasMes = '';
	$scope.porcentaje = '';
	$sessionStorage.cod = 1;

	/**
	 * Metodo para listar asignaturas
	 */

	$scope.cargarAsignaturas = function() {
		httpservice.post('../rest/asignatura/listarAsignaturas', {
			docente : $sessionStorage.cod
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
			docente : $sessionStorage.cod,
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
		$sessionStorage.codeDoc = $sessionStorage.cod;
		$sessionStorage.codeAsig = asignatura.id;
		window.location.href = '../app/#/aprobar-registro';
	}

});
