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
        .when("/AsignarAcceso", {
            controller: "modulo1Controller",
            controllerAs: "tra",
            templateUrl: "vistas/AsignarAcceso.html"
        })
        .when("/pagina2", {
            controller: "modulo1Controller",
            controllerAs: "m1",
            templateUrl: "vistas/page2.html"
        })
        .when("/cliente", {
            controller: "clientecontroller",
            controllerAs: "cliente",
            templateUrl: "vistas/cliente.html"
        })
        .when("/pagina3", {
            controller: "inventariocontroller",
            
            templateUrl: "vistas/page3.html"
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
        });
});

