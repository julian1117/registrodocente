var app = angular.module("miApp",["ngRoute","ngStorage"]);

app.config(function($routeProvider){
    $routeProvider
        .when("/", {
            controller: "modulo1Controller",
            controllerAs: "m1",
            templateUrl: "vistas/form.html"
        })
        .when("/comprar", {
            controller: "compracontroller",
            controllerAs: "m1",
            templateUrl: "vistas/compra.html"
        })
        .when("/pagina1", {
            controller: "modulo1Controller",
            controllerAs: "m1",
            templateUrl: "vistas/page1.html"
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
        });
});
