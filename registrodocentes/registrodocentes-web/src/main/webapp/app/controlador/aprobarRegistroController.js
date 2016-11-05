/**
 * Controlador para las funciones de la vista aprobarRegistro.html
 */
app
		.controller(
				"aprobarRegistroController",
				function($scope, $http, httpservice, $sessionStorage,$window,$location) {
					 var res = filtrod($window,$location);
						if (res == true) {

					$scope.registrosDA = [];
				//	$sessionStorage.doc = 1; // recibo id docente de la ventana 7 por SS 
				//	$sessionStorage.asig = 1; // recibo id asignatura de la ventana 7 por SS
					$sessionStorage.doc = $sessionStorage.codeDoc;
					$sessionStorage.asig = $sessionStorage.codeAsig;
					
					$sessionStorage.registrosAprobados = [];

					/**
					 * metodo para cargar la lista de registros no aprobados
					 */
					function cargarRegistrosDocenteAsignatura() {
						httpservice
								.post(
										'registro/listar-registros-docente-asignatura-sin-aprobar',
										{
											doc : $sessionStorage.doc,
											asig : $sessionStorage.asig
										}, success = function(data, status,
												headers, config) {
											console.log('success.......'
													+ $sessionStorage.doc + "-"
													+ $sessionStorage.asig);

												$scope.registrosDA = data.obj;
												$sessionStorage.regList = data.obj;
											
										}, null,
										"application/x-www-form-urlencoded");
					}

					/*
					 * Inicializa la lista de registros
					 */
					$scope.cargarLista = function() {
						cargarRegistrosDocenteAsignatura();
					};

					$scope.cargarLista();

					/**
					 * metodo para agregar un comentario a un registro
					 * @param reg, es el registro a agregarle el comentario
					 */
					$scope.agregarComentario = function(reg) {
						$sessionStorage.reto = reg;
					}

					/**
					 * setea el comentario al registro enviado 
					 * desde agregarcomentario por sessionStorage
					 */
					$scope.guardarComentario = function() {
						$sessionStorage.reto.comentario = document.getElementById('comentario').value;
					}

					/**
					 * Metodo que limpia el text area
					 * si el modal es cerrado desde el boton
					 * cerrar
					 */
					$scope.cerrarComentario = function() {
						document.getElementById('comentario').value = '';
						
					}

					/**
					 * recorro los registros aprobados y los
					 * registro en la BD utilizando el 
					 * servicio rest
					 */
					$scope.confirmar = function() {
						var regList = $sessionStorage.regList;
						var registrosAprobados = $sessionStorage.registrosAprobados;

						for (var int = 0; int < regList.length; int++) {
							elemento = document.getElementById(regList[int].id);
							if (elemento.checked) {
								registrosAprobados.push(regList[int]);
							}
						}

						for (var int = 0; int < registrosAprobados.length; int++) {
							var re = registrosAprobados[int];
							httpservice.post('registro/aprobar-registro', {
								idReg : re.id,
								coment : re.comentario
							},
									success = function(data, status, headers,
											config) {
										console.log('success.......');
									}, null,
									"application/x-www-form-urlencoded");
						}
						window.location.reload();
					}
						}
				});
