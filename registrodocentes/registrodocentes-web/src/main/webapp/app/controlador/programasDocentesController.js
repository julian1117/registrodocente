app.controller(
				"programasDocentesController",
				function($scope, httpservice,$sessionStorage) {

					$scope.programas = [];
					$scope.docentes = [];
					
					function refrescarProgramas(){
						console.log('refrescando.......');
						httpservice.get('programas/listar-programas', null,
								success = function(data, status, headers,
										config) {
									console.log('success.......');
									$scope.programas = data.obj;
								}, null);
					}
					
					
					
					/**
					 * funcion de inicializacion
					 */
					(function() {
						// cargar los productos.
						
						refrescarProgramas();
						

					}());
					
					
					
					$scope.listardocentes=function(codigo){
						console.log('refrescando.......'+codigo);
						httpservice.post('programas/listar-docentes', {codigo:codigo},success = function(data, status, headers,config) {
									console.log('success.......');
									$scope.docentes = data.obj;
								}, null,"application/x-www-form-urlencoded");
					}
					
					$scope.listadocentes=function(codigo){
						$http({
							url: '../rest/programas/listar-docentes',
						    method: "POST",
						    headers: {
						    		"Content-type":"application/x-www-form-urlencoded"
						    }
						    
						}).success(function(data, status, headers, config) {
							
							if(data.codigo=='00'){
								//alert('Se creo exitosamente');
								alert('El docente es: '+codigo);
							}else{
								alert(data.mensaje);
							}
							
						}).error(function(data, status, headers, config) {
							alert('Error:'+data.mensaje);
						});
						
					}
					
				});