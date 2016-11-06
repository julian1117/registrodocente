/**
 * 
 */
app.controller(
				"ReporteRegistroController",
				function($scope, httpservice,$sessionStorage,$window) {
					
					
					$sessionStorage.idDocente=document.getElementById('documentoDoc');
					$scope.listaAsignaturas = [];
					$scope.docente = {};
					$scope.asignatura = '';
					
					$scope.cargarAsignaturas = function() {
						var id = $scope.docente.id;
						httpservice.post('asignatura/listarAsignaturas', {
							
							docente : id
						}, success = function(data, status, headers, config) {
							
							$scope.listaAsignaturas = data.obj;
						}, null, "application/x-www-form-urlencoded");
					}
					
					$scope.abrirReporte = function() {
						$window.location.href = "../reporte?docenteid="+$scope.docente.id+"" +
								"&asignatura="+$scope.asignatura;
					}
					
					
					
				});