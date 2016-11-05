/**
 * Controlador para las funciones de la vista AsignarAcceso
 */
app.controller("asignarAccesoController", function($scope,$http,httpservice,$window,$sessionStorage) {
//	$scope.nombreRol = '';
	function validar() {
		if($sessionStorage.rol != null) {
			$scope.comboRoles = $sessionStorage.rol;
		}
	}
	function listarRoles() {
		httpservice.get('gestionRol/listarRoles',null,success = function(data, status, headers,config) {
			if(data.obj != null) {
				alert(data.mensaje);
				$scope.roles = data.obj;
			}else{
				alert(data.mensaje);
			}
		},null)
	}
	
	(function() {
		validar();
		listarRoles();
	}());
});