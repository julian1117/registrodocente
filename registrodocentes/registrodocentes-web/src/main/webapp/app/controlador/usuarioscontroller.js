app.controller("usuarioscontroller", function($scope, httpservice) {

	$scope.roles = [];
	$scope.nombre = '';
	$scope.apellido = '';
	$scope.usuario = '';
	$scope.password = '';
	$scope.usuarios = [];

	/**
	 * funcion de inicializacion
	 */
	(function() {
		// cargar los programas					
		refrescarProgramas();
		cargarUsuarios();
	}());
	/**
	 * funcion que consume el metodo rest para crear un semestre
	 */
	$scope.crearUsuario = function() {
		var dato = {
			nombre : $scope.nombre,
			apellido : $scope.apellido,
			usuario : $scope.usuario,
			pass : $scope.password
		}
		httpservice.post("usuario/crear", dato, function(data, status,
				headers, config) {
			alert(data.obj);
			cargarUsuarios();

		}, null);
			}

	/**
	 * funcion que consume el metodo rest para listar los usuarios
	 */
	 function cargarUsuarios() {
		httpservice.get("usuario/listar", null, function(data, status,
				headers, config) {
			$scope.usuarios = data.obj;
		}, null);
	}

	/**
	 * funcion que consume el metodo rest para eliminar un usuario
	 */
	$scope.eliminarUsuario = function(u) {
		//alert('que cosa!!!!');
		httpservice.post("usuario/eliminar", u, function(data, status,
				headers, config) {
			alert(data.obj);
			cargarUsuarios();

		}, null);
	}

	/**
	 * funcion que consume el metodo rest para listar los roles
	 */
	function refrescarProgramas() {
		//alert('que cosa roles!!!!');
		httpservice.get("gestionRol/listarRoles", null, function(data,
				status, headers, config) {
			$scope.roles = data.obj;
		}, null);
	}

	

});
