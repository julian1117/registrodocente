app.controller("semestreController", function($scope, $http) {

	$scope.causa = '';
	$scope.fechaNoLaboral = new Date();
	$scope.id = '';
	$scope.sem = '';
	$scope.anho = '';
	$scope.periodo = '';
	$scope.semestres = [];
	$scope.fecha = new Date();
	$scope.dias = [];

	$scope.estado = {
		estado1 : false
	}

	/**
	 * funcion que consume el metodo rest para crear un semestre
	 */
	$scope.crearSemestre = function() {
		var dato = $.param({
			fecha : $scope.fecha
		});
		$http({
			url : '../rest/semestre/crearSemestre',
			method : "POST",

			data : dato,
			headers : {
				"Content-Type" : "application/x-www-form-urlencoded"
			}

		}).success(function(data, status, headers, config) {
			if (data.codigo == '00') {
				alert(data.mensaje);
				$scope.cargarSemestres();
			} else {
				alert(data.mensaje);
			}

		}).error(function(data, status, headers, config) {
			alert('error::' + data.mensaje);
		});

	}

	
	/**
	 * funcion que consume el metodo rest para listar los semestres y cargan en una tabla
	 */
	$scope.cargarSemestres = function() {

		$http({
			url : '../rest/semestre/listarSemestres',
			method : "GET"
		}).success(function(data, headers, config) {
			if (data.codigo == '00') {
				$scope.semestres = data.obj;
			}

		}).error(function(data, status, headers, config) {
			alert('error::' + data.mensaje);
		});

	}

	
	/**
	 * funcion que consume el metodo rest para eliminar un semestre
	 */
	$scope.eliminarSemestre = function(s) {
		var dato1 = $.param({
			anho : s.anho,
			periodo : s.periodo
		});

		$http({
			url : '../rest/semestre/eliminarSemestre',
			method : "POST",

			data : dato1,
			headers : {
				"Content-Type" : "application/x-www-form-urlencoded"
			}

		}).success(function(data, status, headers, config) {
			if (data.codigo == '00') {
				alert(data.mensaje);
				$scope.cargarSemestres();
			} else {
				alert(data.mensaje);
			}

		}).error(function(data, status, headers, config) {
			alert('error::' + data.mensaje);
		});

	}

	
	/**
	 * funcion que consume el metodo rest para listar dias no laborales
	 */
	$scope.listarDiasSemestre = function(s) {
		$scope.sem = s;
		$scope.estado.estado1 = true;
		var dato2 = $.param({
			anho : s.anho,
			periodo : s.periodo
		});
		$http({
			url : '../rest/semestre/listarDiasNoLaborales',
			method : "POST",

			data : dato2,
			headers : {
				"Content-Type" : "application/x-www-form-urlencoded"
			}

		}).success(function(data, status, headers, config) {
			if (data.codigo == '00') {
				$scope.dias = data.obj;
			} else {
				$scope.dias = data.obj;
			}

		}).error(function(data, status, headers, config) {
			alert('error::' + data.mensaje);
		});

	}

	
	/**
	 * funcion que consume el metodo rest para crear o marcar un dia no laboral a un semestre
	 */
	$scope.marcarDia = function() {
		var dato3 = JSON.stringify({
			anho : $scope.sem.anho,
			periodo : $scope.sem.periodo,
			fechaNoLaboral : $scope.fechaNoLaboral,
			causa : $scope.causa
		});
		$http({
			url : '../rest/semestre/marcarDia',
			method : "POST",

			data : dato3,
			headers : {
				"Content-Type" : "application/json"
			}

		}).success(function(data, status, headers, config) {
			if (data.codigo == '00') {
				alert(data.mensaje);
				$scope.listarDiasSemestre($scope.sem);
			} else {
				alert(data.mensaje);
			}

		}).error(function(data, status, headers, config) {
			alert('error::' + data.mensaje);
		});

	}

	
	
	/**
	 * funcion que consume el metodo rest para eliminar un dia no laboral de un semestre
	 */
	$scope.eliminarDia = function(d) {
		var dato5 = $.param({
			id : d.id
		});
		$http({
			url : '../rest/semestre/eliminarDia',
			method : "POST",

			data : dato5,
			headers : {
				"Content-Type" : "application/x-www-form-urlencoded"
			}

		}).success(function(data, status, headers, config) {
			if (data.codigo == '00') {
				alert(data.mensaje);
				$scope.listarDiasSemestre($scope.sem);
			} else {
				alert(data.mensaje);
			}

		}).error(function(data, status, headers, config) {
			alert('error::' + data.mensaje);
		});

	}

	/**
	 * funcion de inicializacion
	 */
	$scope.iniciar = function() {
		$scope.cargarSemestres();
	}
	$scope.iniciar();

});
