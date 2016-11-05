app.controller(
				"semestresAnterioresRegController",
				function($scope,$http , httpservice,$sessionStorage) {

					$scope.usuarios = [];
					$scope.cursos = [];
//					$scope.anio=0;
//					$scope.periodo=0;
//					$scope.docente=0;
					
					
					
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
						// cargar los productos.
						
						listarUsuarios();
						

					}());
					
					
					
					$scope.listarCurso=function(){
						
						alert($scope.anio + 'locota'+ $scope.periodo + $scope.docente)
						var parametro = $.param({
							anio : $scope.anio,
							periodo : $scope.periodo,
							docente : $scope.docente
							
						});
//						console.log('refrescando.......'+anio+periodo+docente);
//						httpservice.post('semestresAnteriores/listarCursos', {anio:anio},
//								{periodo:periodo},{docente:docente},
//								success = function(data, status, headers,config) {
//									console.log('success.......');
//									$scope.docentes = data.obj;
//								}, null,"application/x-www-form-urlencoded");
//					}
					
				//	$scope.listadoCursos=function(anio, periodo,docente){
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
					
//					$scope.listarCurso=function(){
//						alert($scope.anio + 'locota'+ $scope.periodo + $scope.docente)
//						var parametro =$.param({
//							anio : $scope.anio,
//							periodo : $scope.periodo,
//							docente : $scope.docente
//							
//						});
//						httpservice.post('semestresAnteriores/listarCursos',success = function(data, status, headers,config) {
//									console.log('success.......');
//									$scope.cursos = data.obj;
//								}, null,"application/x-www-form-urlencoded");
//					}
//					
////					$scope.listadoCursos=function(){
////						$http({
////							url: '../rest/semestresAnteriores/listarCursos',
////						    method: "POST",
////						    headers: {
////						    		"Content-type":"application/x-www-form-urlencoded"
////						    }
////						    
////						}).success(function(data, status, headers, config) {
////							
////							if(data.codigo=='00'){
////								alert("Ya entroooooooooooooooooooooooooo")
////							}else{
////								alert(data.mensaje);
////							}
////							
////						}).error(function(data, status, headers, config) {
////							alert('Error:'+data.mensaje);
////						});
////						
////					}
					
				});