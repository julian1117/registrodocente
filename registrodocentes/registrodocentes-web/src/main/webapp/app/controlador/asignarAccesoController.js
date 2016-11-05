/**
 * Controlador para las funciones de la vista AsignarAcceso
 */
app.controller("asignarAccesoController", function($scope,$http,httpservice,$window,$sessionStorage) {
	$scope.listarRoles = function () {
		var combo = document.getElementById("rolSelect");
		httpservice.get('gestionRol/listarRoles',null,success = function(data, status, headers,config) {
			if(data.obj != null) {
				$scope.roles = data.obj;
				alert(combo);
			}
		},null)
	}
	var prueba = function () {
		httpservice.get('gestionRol/listarAccesos',null,success = function(data, status, headers,config) {
			if(data.obj != null) {
				$scope.accesos = data.obj;
			}
		},null)
	}
});