app.controller(
				"programasDocentesController",
				function($scope, httpservice,$sessionStorage,$window,$location) {
					 var res = filtrod($window,$location);
						if (res == true) {

					$scope.programas = [];
					$scope.docentes = [];
					$scope.codigodocente = '';
					
					/**
					 * funcion que lista los programas 
					 */
					function refrescarProgramas(){
						console.log('refrescando.......');
						httpservice.get('programas/listar-programas', null,
								success = function(data, status, headers, config) {
									console.log('success.......');
									$scope.programas = data.obj;
								}, null);
					}
									
					/**
					 * funcion de inicializacion
					 */
					(function() {
						// cargar los programas					
						refrescarProgramas();
					}());
							
					/**
					 * funcion que lista los docentes segun el programa
					 * @param codigo, codigo del programa
					 */
					$scope.listardocentes=function(codigo){			
						console.log('refrescando.......'+codigo);
						httpservice.post('programas/listar-docentes', {codigo:codigo},success = function(data, status, headers,config) {
									console.log('success.......');
									$scope.docentes = data.obj;
								}, null,"application/x-www-form-urlencoded");											
					}
					
					/**
					 * funcion que guarda el documento del docente
					 * en el session storage
					 * @param cod, documento del docente
					 */
					$scope.guardarsesionstorage=function(cod){
						console.log("entrando........");
						$sessionStorage.cod=cod;
						console.log($sessionStorage.cod);
						$window.location.href = "#/asignaturas";
					}
					
						}
					
				});