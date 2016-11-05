/**
 * Controlador para las funciones de la vista registros.html
 */
app.controller("registrosController", function($scope, $http, httpservice,
		$sessionStorage) {

	$scope.registros = [];

	/**
	 * Función para cargar los registros
	 */
	function cargarRegistros() {
		//Se cargan los registros del curso y docente indicados
		//Deben ser reemplazados por los valores del sessionstorage
		var xsrf = $.param({
			cod : 1,
			ced : 123
		});
		console.log(xsrf);
		$http({
			url : '../rest/registro/listarregistrosfechas',
			method : "POST",

			data : xsrf,
			headers : {
				"Content-Type" : "application/x-www-form-urlencoded"// ,
			// "Authorization" : $sessionStorage.usuario.token
			}

		}).success(function(data, status, headers, config) {
			if (data.codigo == '00') {
				$scope.registros = data.obj;
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
	(function() {
		console.log('llegué al controlador');
		cargarRegistros();
	}());

	/**
	 * Función para editar registro
	 */
	$scope.editarRegistro = function(registro) {
		var xsrf = $.param({
			id : registro.id,
			coment : registro.comentario
		});
		console.log(xsrf);
		$http({
			url : '../rest/registro/editarregistro',
			method : "POST",
			data : xsrf,
			headers : {
				"Content-Type" : "application/x-www-form-urlencoded"// ,
			// "Authorization" : $sessionStorage.usuario.token
			}
		}).success(function(data, status, headers, config) {
			if (data.codigo == '00') {
				alert(data.mensaje);
			} else {
				alert(data.mensaje);
			}
		}).error(function(data, status, headers, config) {
			alert('error::' + data.mensaje);
		});
		cargarRegistros();
	}
});
