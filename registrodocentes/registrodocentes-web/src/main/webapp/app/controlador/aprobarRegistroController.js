/**
 * Controlador para las funciones de la vista aprobarRegistro.html
 */
app
		.controller(
				"aprobarRegistroController",
				function($scope, $http, httpservice, $sessionStorage) {

					$scope.registrosDA = [];

					function cargarRegistrosDocenteAsignatura() {
						var xsrf = $.param({
							doc : 1,// $sessionStorage.object.docente.id,
							asig : 1
						// $sessionStorage.object.asignatura.id
						});

						$http(
								{
									url : '../rest/registro/listar-registros-docente-asignatura-sin-aprobar',
									method : "POST",
									data : xsrf,
									headers : {
										"Content-Type" : "application/x-www-form-urlencoded",
										"Authorization" : $sessionStorage.objeto.token
									}
								}).success(
								function(data, status, headers, config) {
									if (data.codigo == '00') {
										$scope.registrosDA = data.obj;
										// $sessionStorage.listaRegistrosDA =
										// data.obj;
									} else {
										alert(data.mensaje);
									}
								}).error(
								function(data, status, headers, config) {
									alert('error::' + data.mensaje);
								});
					}

					(function() {
						cargarRegistrosDocenteAsignatura();
					});

					$scope.init = function() {
						$scope.cargarRegistrosDocenteAsignatura;
						console.log("entre");
					}
					$scope.init();

					$scope.aprobarRegistro = function() {
						var xsrf = $.param({
							idRegistro : $scope.formData.idReg,
							comentario : $scope.formData.coment
						});

						$http(
								{
									url : '../rest/registro/aprobar-registro',
									method : "POST",
									data : xsrf,
									headers : {
										"Content-Type" : "application/x-www-form-urlencoded",
										"Authorization" : $sessionStorage.objeto.token
									}
								}).success(
								function(data, status, headers, config) {
									if (data.codigo == '00') {
										$scope.resp = data.obj;
										alert(resp);
										// $sessionStorage.listaRegistrosDA =
										// data.obj;
									} else {
										alert(data.mensaje);
									}
								}).error(
								function(data, status, headers, config) {
									alert('error::' + data.mensaje);
								});
					}

				});
