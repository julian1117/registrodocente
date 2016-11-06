var app = angular.module("miApp", [ "ngRoute", "ngStorage" ]);

app.config(function($routeProvider) {
	$routeProvider.when("/", {
		controller : "menuController",
		controllerAs : "m1",
	}).when("/registros", {
		controller : "registrosController",
		controllerAs : "reg",
		templateUrl : "vistas/registros.html"
	}).when("/AsignarAcceso", {
		controller : "asignarAccesoController",
		controllerAs : "tra",
		templateUrl : "vistas/AsignarAcceso.html"
	}).when("/cliente", {
		controller : "clientecontroller",
		controllerAs : "cliente",
		templateUrl : "vistas/cliente.html"
	}).when("/RegSemAnteriores", {
		controller : "semestresAnterioresRegController",
		templateUrl : "vistas/RegSemAnteriores.html"
	}).when("/ReporteRegistros", {
		controller : "ReporteRegistroController",
		templateUrl : "vistas/ReporteRegistros.html"
	}).when("/programasDocentes", {
		controller : "programasDocentesController",
		templateUrl : "vistas/programasDocentes.html"
	}).when("/asignaturas", {
		controller : "asignaturaController",
		templateUrl : "vistas/asignaturas.html"
	}).when("/Semestre", {
		controller : "semestreController",
		templateUrl : "vistas/Semestre.html"
	}).when("/menu", {
		controller : "menuController",
		controllerAs : "menu",
		templateUrl : "menu.html"
	}).when("/CrearRol", {
		controller : "crearRolController",
		templateUrl : "vistas/CrearRol.html"
	}).when("/aprobar-registro", {
		controller : "aprobarRegistroController",
		controllerAs : "apr",
		templateUrl : "vistas/aprobar-registro.html"
	});
});

/**Filtro de seguridad de paginas
 * Jhohanns villa
 */
//app.filter('cambiar', function($location, $window) {
//	var objetoJson = $window.sessionStorage.getItem('ngStorage-objt');
//	var objetoMane = JSON.parse(objetoJson);
//
//	
//	if (objetoMane.usuario != undefined) {
//
//
//		var exito = false;
//		for (var i = 0, t = objetoMane.accesos.length; i < t; i++) {
//			var acceso = objetoMane.accesos[i].url;
//			if (("#" + $location.path()) == acceso) {
//				exito = true;
//			}
//		}
//		if (!exito) {
//			$location.path('/');
//		}
//	} else {
//		window.location.href = '../app/login.html';
//	}
//});
var filtrod = function($window,$location) {
	
	var objetoJson = $window.sessionStorage.getItem('ngStorage-objt');
	var objetoMane = JSON.parse(objetoJson);

	


		var exito = false;
		for (var i = 0, t = objetoMane.accesos.length; i < t; i++) {
			var acceso = objetoMane.accesos[i].url;
			if (("#" + $location.path()) == acceso) {
				exito = true;
			}
		}
		if (!exito) {
			return $location.path('/');
		}
		return true;
	
	
};
