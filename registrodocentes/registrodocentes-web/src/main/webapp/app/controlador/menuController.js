app.controller("menuController", function($scope, $http, $window,
		$sessionStorage) {
	$scope.accesos = [];
	$scope.cargarAccesos = function() {
		var xsrf = $.param({
			usuario : $sessionStorage.objeto.usuario
		});
		$http({
			url : '../rest/login/accesos',
			method : "POST",
			data : xsrf,
			headers : {
				"Content-Type" : "application/x-www-form-urlencoded",
				"Authorization" : $sessionStorage.objeto.token
			}
		}).success(function(data, status, headers, config) {
			if (data.codigo == '1') {
				$scope.accesos = data.obj.accesos;
				$sessionStorage.objt = data.obj;
			} else {
				alert(data.mensaje);
			}
		}).error(function(data, status, headers, config) {
			alert('error::' + data.mensaje); 
		});
	}
	$scope.iniciar = function() {
		$scope.cargarAccesos(); 
	}
	$scope.iniciar(); 
});