app.controller("semestreController", function($scope, $http) {

	$scope.anho ='';
	$scope.periodo ='';
	$scope.semestres = [];
	$scope.fecha = new Date();
	

	
	$scope.crearSemestre= function() {
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
	
	
	
	$scope.cargarSemestres= function() {

		$http({
			url : '../rest/semestre/listarSemestres',
			method : "GET"
		}).success(function(data, headers, config) {
			if (data.codigo == '00') {
				$scope.semestres = data.obj;
			} else {
				alert(data.mensaje);
			}

		}).error(function(data, status, headers, config) {
			alert('error::' + data.mensaje);
		});

	}

	
	
	
	$scope.eliminarSemestre= function(s) {
		var dato1 = $.param({
			anho : s.anho,
			periodo : s.periodo
		});
		alert(dato1);
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
	 * funcion de inicializacion
	 */
	$scope.iniciar= function() {
		$scope.cargarSemestres();
	}
	$scope.iniciar();

});
