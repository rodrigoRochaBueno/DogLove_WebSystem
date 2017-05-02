var appCliente = angular.module("appCliente",["ngRoute"])

.config(function($routeProvider, $locationProvider){
	
	$routeProvider
	.when('/clientes', {templateUrl: 'cliente.html', controller:'indexController'})
	.when('/estados', {templateUrl: 'estado.html', controller:'estado-controller'})
	.when('/teste', {templateUrl: 'web.html', controller:'estado-controller'})
	.when('/cidades', {templateUrl: 'cidade.html', controller:'cidade-controller'})
	.when('/detalhes/:funcNome', {templateUrl: 'funcionario-detalhe.html', controller: 'funcionario-detalhe-controller'})
	.when('/login', {templateUrl: 'login.html', controller:'loginController'});
	
	
	
		
})

	.controller('mainController', function($scope, $location, $route, $routeParams){
		$scope.$location = $location;
		$scope.$route = $route;
		$scope.$routeParams = $routeParams;
});


