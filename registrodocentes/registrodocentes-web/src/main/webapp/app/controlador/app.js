var app = angular.module("miApp",["ngRoute","ngStorage"]);

app.config(function($routeProvider){
    $routeProvider
        .when("/", {
            controller: "modulo1Controller",
            controllerAs: "m1",
            templateUrl: "vistas/form.html"
        })
        .when("/registros", {
            controller: "registrosController",
            controllerAs: "reg",
            templateUrl: "vistas/registros.html"
        })
        .when("/aprobar-registro", {
            controller: "aprobarRegistroController",
            controllerAs: "apr",
            templateUrl: "vistas/aprobar-registro.html"
        })
        .when("/AsignarAcceso", {
            controller: "modulo1Controller",
            controllerAs: "tra",
            templateUrl: "vistas/AsignarAcceso.html"
        })
        .when("/login", {
            controller: "modulo1Controller",
            controllerAs: "m1",
            templateUrl: "vistas/login.html"
        })
        .when("/cliente", {
            controller: "clientecontroller",
            controllerAs: "cliente",
            templateUrl: "vistas/cliente.html"
        })
        .when("/RegSemAnteriores", {
            controller: "inventariocontroller",
            
            templateUrl: "vistas/RegSemAnteriores.html"
        })
	    .when("/reporteregistro", {
	        controller: "inventariocontroller",
	        
	        templateUrl: "vistas/ReporteRegistros.html"
	    })
    	.when("/programasDocentes", {
        controller: "inventariocontroller",
        
        templateUrl: "vistas/programasDocentes.html"
    	})
        .when("/CrearRol", {
            controller: "inventariocontroller",
            
            templateUrl: "vistas/CrearRol.html"
        })
        
        .when("/RegSemAnteriores", {
            controller: "regSemAnteriores",
            
            templateUrl: "vistas/RegSemAnteriores.html"
        })
        ;
});

