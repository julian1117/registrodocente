app.controller("usuarioscontroller", function($scope, httpservice) {

	$scope.roles = [];
	$scope.nombre = '';
	$scope.apellido = '';
	$scope.usuario = '';
	$scope.password = '';
	$scope.usuarios = [];

	/**
	 * funcion que consume el metodo rest para crear un semestre
	 */
	$scope.crearUsuario = function() {
		var dato = {
			nombre : $scope.nombre,
			apellido : $scope.apellido,
			usuario : $scope.usuario,
			password : $scope.password
		}
		$httpservice.post("/usuario/crear", dato, function(data, status,
				headers, config) {
			alert("Usuario creado exitosamente");
		}, null);
	}

	/**
	 * funcion que consume el metodo rest para listar los usuarios
	 */
	$scope.cargarUsuarios = function() {
		$httpservice.get("/usuario/listar", null, function(data, status,
				headers, config) {
			$scope.usuarios = data.obj;
		}, null);
	}

	/**
	 * funcion que consume el metodo rest para eliminar un usuario
	 */
	$scope.eliminarUsuario = function(u) {
		$httpservice.post("/usuario/eliminar", u, function(data, status,
				headers, config) {
			alert("Usuario creado exitosamente");
		}, null);
	}

	/**
	 * funcion que consume el metodo rest para listar los roles
	 */
	$scope.listarroles = function() {
		$httpservice.get("/gestionRol/listarRoles", null, function(data,
				status, headers, config) {
			$scope.roles = data.obj;
		}, null);
	}

	/**
	 * funcion de inicializacion
	 */
	$scope.iniciar = function() {
		$scope.cargarUsuarios();
		$scope.listarroles();
	}
	$scope.iniciar();

});
