app.controller(
				"semestresAnterioresRegController",
				function($scope,$http , httpservice,$sessionStorage) {

					$scope.usuarios = [];
					$scope.cursos = [];		
					$scope.registros = [];
					
					
					function listarUsuarios(){
						console.log('refrescando.......');
						httpservice.get('semestresAnteriores/listaUsuarios', null,
								success = function(data, status, headers,
										config) {
									console.log('success.......');
									$scope.usuarios = data.obj;
								}, null);
					}
					
					
					
					/**
					 * funcion de inicializacion
					 */
					(function() {						
						listarUsuarios();
					}());
					
					
					
					$scope.listarCurso=function(){
						
						var parametro = $.param({
							anio : $scope.anio,
							periodo : $scope.periodo,
							docente : $scope.docente
							
						});

						$http({
							url: '../rest/semestresAnteriores/listarCursos',
						    method: "POST",
						    data : parametro,
						    headers: {
						    		"Content-type" : "application/x-www-form-urlencoded"
						    }
						    
						}).success(function(data, status, headers, config) {
							
							if(data.codigo=='00'){
								$scope.cursos = data.obj;
								alert('El Curso con estos datos es: '+anio+periodo+docente);
							}else{
								alert(data.mensaje);
							}
							
						}).error(function(data, status, headers, config) {
							alert('Error:'+data.mensaje);
						});
						
					}
					
					
//					$scope.listarRegistros=function(){
//						
//						alert( $scope.docente)
//						var parametro = $.param({
//							docente : $scope.docente
//							
//						});
//
//						$http({
//							url: '../rest/semestresAnteriores/listarRegistros',
//						    method: "POST",
//						    data : parametro,
//						    headers: {
//						    		"Content-type" : "application/x-www-form-urlencoded"
//						    }
//						    
//						}).success(function(data, status, headers, config) {
//							
//							if(data.codigo=='00'){
//								$scope.registros = data.obj;
//								alert('El Curso con estos datos es: '+anio+periodo+docente);
//							}else{
//								alert(data.mensaje);
//							}
//							
//						}).error(function(data, status, headers, config) {
//							alert('Error:'+data.mensaje);
//						});
//						
//					}
					
					
					$scope.listarRegistros=function(docente){			
						console.log('refrescando.......'+docente);
						httpservice.post('semestresAnteriores/listarRegistros',
								{docente:docente},success = function(data, status, headers,config) {
									console.log('success.......');
									$scope.registros = data.obj;
								}, null,"application/x-www-form-urlencoded");											
					}
					
				});