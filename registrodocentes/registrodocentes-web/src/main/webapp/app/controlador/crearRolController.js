/**
 * Controlador para las funciones de la vista CrearRol
 */
app.controller("crearRolController", function($scope,$http,httpservice,$window,$sessionStorage,$location) {
	 var res = filtrod($window,$location);
		if (res == true) {
	$scope.nombreRol = '';
	$scope.botonCrear = function() {
		var json = {
				rol : {
					descripcion : $scope.nombreRol
				}
		};
		httpservice.post('gestionRol/crearRol', json,
				success = function(data, status, headers,
						config) {
					if(data.obj) {
						alert(data.mensaje);
						limpiar();
						$sessionStorage.rol = $scope.nombreRol;
					} else {
						alert(data.mensaje);
					}
				}, null, "application/json");
	};
	function limpiar() {
		$scope.nombreRol = '';
	}
		}
});