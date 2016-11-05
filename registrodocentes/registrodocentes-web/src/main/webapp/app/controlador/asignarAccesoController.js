/**
 * Controlador para las funciones de la vista AsignarAcceso
 */
app.controller("asignarAccesoController", function($scope,$http,httpservice,$window,$sessionStorage) {
	$scope.prueba='';
	$scope.listarRoles = function () {
		httpservice.get('gestionRol/listarRoles',null,success = function(data, status, headers,config) {
			if(data.obj != null) {
				$scope.roles = data.obj;
//				alert(combo);
			}
		},null)
	}
	$scope.prueba = function () {
		httpservice.get('gestionRol/listarAccesos',null,success = function(data, status, headers,config) {
			if(data.obj != null) {
				$scope.accesos = data.obj;
			}
		},null)
	}
	$scope.asd = function() {
		alert($scope.rolSelect)
	};
});