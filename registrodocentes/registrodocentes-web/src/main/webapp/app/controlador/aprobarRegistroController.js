/**
 * Controlador para las funciones de la vista aprobarRegistro.html
 */
app.controller("aprobarRegistroController", function($scope, $http, httpservice,
		$sessionStorage) {
	
	$scope.registros = [];
	
	function cargarRegistros(){
		
		$http({
			url:'../rest/registro/listar-registros',
			method : "GET",
			
			headers : {
				"Content-Type" : "application/x-www-form-urlencoded",
				
			}
			
			
			
		}).success (function (data, headers, config){
			if (data.codigo == 1) {
				$scope.registros = data.obj;
				console.log($sessionStorage.usuario);
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
		cargarRegistros();
	}());
	
	
});
