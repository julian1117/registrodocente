/**
 * Controlador para las funciones de la vista AsignarAcceso
 */
app.controller("asignarAccesoController", function($scope,$http,httpservice,$window,$sessionStorage) {
	$scope.listarRoles = function () {
		httpservice.get('gestionRol/listarRoles',null,success = function(data, status, headers,config) {
			if(data.obj != null) {
//				alert(data.mensaje);
				$scope.roles = data.obj;
			}
		},null)
	}
});