app.controller("loginController", function($scope, $http, $window,
		$sessionStorage) {
	$scope.user = '';
	$scope.pass = '';
	$scope.token = '';
	$scope.login = function() {
		var xsrf = $.param({
			usuario : $scope.user,
			contrasenia : $scope.pass
		});
		$http({
			url : '../rest/login/verificar',
			method : "POST",
			data : xsrf,
			headers : {
				"Content-Type" : "application/x-www-form-urlencoded"
			}
		}).success(function(data, status, headers, config) {
			if (data.codigo == '00') {
				$sessionStorage.usuario = data.obj.usuario;
				$sessionStorage.token = data.obj.token;
				$window.sessionStorage = $sessionStorage.usuario;
				$window.sessionStorage = $sessionStorage.token;
				$window.location.href = '../app/menu.html#/';

			} else {
				alert(data.mensaje);
			}
		}).error(function(data, status, headers, config) {
			alert('error::' + data.mensaje);
		});
	};
});