var httpservice = app.service('httpservice', [ '$http', '$window',
		'$sessionStorage', function($http, $window, $sessionStorage) {
			var urlbase = '../rest/';
			return {

				get : function(url, datos, succes, error) {

					console.log('invocando get:' + url);
					return $http({
						url : urlbase + url,
						method : "GET",
						params : datos,
						headers : {
							//"Authorization" : $sessionStorage.usuario.token
						}
					}).error(function(data, status, headers, config) {
						if (status == 401) {
							$window.location.href = '#/';
							alert('no autorizado');
						} else {
							alert('Error general' + data.mensaje);
						}
						if (error) {
							error(data, status, headers, config);
						}
					}).success(function(data, status, headers, config) {
						console.log(data.obj);
						console.log(data.codigo);
						if (data.codigo != '00') {
							alert('Error general:' + data.mensaje);
						} else {
							if (succes) {
								succes(data, status, headers, config);
							}
						}

					});
				},
				post : function(url, datos, succes, error,contenttype) {
					
					var content='';
					if(contenttype=="application/x-www-form-urlencoded"){
						datos=$.param(datos);
						content="application/x-www-form-urlencoded";
					}else{
						content="application/json";
					}
					
					console.log('invocando post:' + url);
					return $http({
						url : urlbase + url,
						method : "POST",
						data : datos,
						headers : {
							"Content-Type" : content,
							"Authorization" : $sessionStorage.objeto.token
						}
					}).error(function(data, status, headers, config) {
						if (status == 401) {
							$window.location.href = '#/';
							console.log('no autorizado:' + url);
							alert('no autorizado');
						} else {
							alert('Error general:' + data.mensaje);
						}
						error(data, status, headers, config);
					}).success(function(data, status, headers, config) {
						console.log(data.obj);
						console.log(data.codigo);
						if (data.codigo != '00') {
							alert('Error general:' + data.mensaje);
						} else {
							succes(data, status, headers, config);
						}

					});
				}
			}
		} ]);