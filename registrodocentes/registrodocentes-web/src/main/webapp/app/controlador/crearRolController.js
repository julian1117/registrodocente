app.controller("crearRolController", function($scope,$http,$window,$sessionStorage) {
	$scope.nombreRol = '';
	var rol=document.getElementById('idRol').value;
	$scope.botonCrear = function() {
		$sessionStorage.rol = $scope.nombreRol;
	};
});