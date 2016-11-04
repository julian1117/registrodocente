app.controller("crearRolController", function($scope,$http,httpservice,$window,$sessionStorage) {
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
						$window.location.href = '#/AsignarAcceso';
						$sessionStorage.rol = rol;
					} else {
						alert('Error');
						alert(data.mensaje);
					}
				}, null, "application/json");
	};
});