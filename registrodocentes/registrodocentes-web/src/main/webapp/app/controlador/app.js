var app = angular.module("miApp", [ "ngRoute", "ngStorage" ]);

app.config(function($routeProvider) {
	$routeProvider.when("/", {
		controller : "modulo1Controller",
		controllerAs : "m1",
		templateUrl : "vistas/form.html"
	}).when("/registros", {
		controller : "registrosController",
		controllerAs : "reg",
		templateUrl : "vistas/registros.html"
	}).when("/aprobar-registro", {
		controller : "aprobarRegistroController",
		controllerAs : "apr",
		templateUrl : "vistas/aprobar-registro.html"
	}).when("/AsignarAcceso", {
		controller : "modulo1Controller",
		controllerAs : "tra",
		templateUrl : "vistas/AsignarAcceso.html"
	}).when("/login", {
		controller : "modulo1Controller",
		controllerAs : "m1",
		templateUrl : "vistas/login.html"
	}).when("/cliente", {
		controller : "clientecontroller",
		controllerAs : "cliente",
		templateUrl : "vistas/cliente.html"
	}).when("/RegSemAnteriores", {
		controller : "inventariocontroller",
		templateUrl : "vistas/RegSemAnteriores.html"
	}).when("/ReporteRegistros", {
		controller : "inventariocontroller",
		templateUrl : "vistas/ReporteRegistros.html"
	}).when("/programasDocentes", {
		controller : "programasDocentesController",
		templateUrl : "vistas/programasDocentes.html"
	}).when("/asignaturas", {
		controller : "inventariocontroller",
		templateUrl : "vistas/asignaturas.html"
	}).when("/Semestre", {
		controller : "inventariocontroller",
		templateUrl : "vistas/Semestre.html"
	}).when("/CrearRol", {
		controller : "inventariocontroller",
		templateUrl : "vistas/CrearRol.html"
	});
});

/**
 * Filtro de accesos
 * Jhohanns villa vasquez, Miguel tamayo
 */
app.filter(function($location) {
	if (sessionStorage.Usuario != null) {

		var exito = false;
		for (var i = 0, t = sessionStorage.Accesos.length; i < t; i++) {
			key = sessionStorage.Accesos.key(i);
			if ($location.path().equals(key)) {
				exito = true;
			}
		}
		if (!exito) {
			$location.path('/');
		}
	} else {
		$location.path('/login');
	}

});
