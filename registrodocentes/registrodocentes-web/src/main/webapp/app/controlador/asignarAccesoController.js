/**
 * Controlador para las funciones de la vista AsignarAcceso
 */
app.controller("asignarAccesoController", function($scope,$http,httpservice,$window,$sessionStorage,$location) {
	
	 var res = filtrod($window,$location);
		if (res == true) {
			
	$scope.prueba='';
	$scope.listarRoles = function () {
		httpservice.get('gestionRol/listarRoles',null,success = function(data, status, headers,config) {
			if(data.obj != null) {
				$scope.roles = data.obj;
				listarAccesos();
			}
		},null)
	}
	function listarAccesos() {
		httpservice.get('gestionRol/listarAccesos',null,success = function(data, status, headers,config) {
			if(data.obj != null) {
				$scope.accesos = data.obj;
			}
		},null)
	}
	$scope.agregar = function () {
		httpservice.get('gestionRol/listarAccesos',null,success = function(data, status, headers,config) {
			if(data.obj != null) {
				$scope.accesosRol = data.obj;
			}
		},null)
	}
	$scope.eliminar = function () {
		
	}
	$scope.combo = function () {
		console.log('Entraaaaa');
		alert('ASDASDIO');
	}
		}
});