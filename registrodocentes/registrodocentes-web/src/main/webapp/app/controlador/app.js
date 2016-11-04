var app = angular.module("miApp", [ "ngRoute", "ngStorage" ]);

app.config(function($routeProvider) {
	$routeProvider.when("/", {
		controller : "menuController",
		controllerAs : "m1",
	}).when("/registros", {
		controller : "registrosController",
		controllerAs : "reg",
		templateUrl : "vistas/registros.html"
	}).when("/aprobar-registro", {
		controller : "aprobarRegistroController",
		controllerAs : "apr",
		templateUrl : "vistas/aprobar-registro.html"
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
	}).when("/menu", {
		controller : "menuController",
		controllerAs : "menu",
		templateUrl : "menu.html"
	}).when("/CrearRol", {
		controller : "crearRolController",
		templateUrl : "vistas/CrearRol.html"
	});
});

/**Filtro de seguridad de paginas
 * Jhohanns villa
 */
app.filter('cambiar', function($location, $window) {

	var objetoJson = $window.sessionStorage.getItem('objt');
	var objetoMane = JSON.parse(objetoJson);

	if (objetoMane.obj.usuario != '') {

		var exito = false;
		for (var i = 0, t = objetoMane.obj.accesos.length; i < t; i++) {

			alert(objetoMane.obj.accesos[i].url);
			var acceso = objetoMane.obj.accesos[i].url;
			if (("#" + $location.path()) == acceso) {
				exito = true;
			}
		}
		if (!exito) {
			$location.path('/');
		}
	} else {
		window.location.href = '../app/login.html';

	}

});
