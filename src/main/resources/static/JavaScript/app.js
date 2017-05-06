var appDogLove = angular.module("appDogLove", [ "ngRoute" ])

.config(function($routeProvider, $locationProvider) {

	$routeProvider.when('/home', {
		templateUrl : 'home.html',
		controller : 'homeController'
	}).when('/cadastro', {
		templateUrl : 'cadastro.html',
		controller : 'cadastroController'
	}).when('/agenda', {
		templateUrl : 'agenda.html',
		controller : 'agendaController'
	});

})

.controller('mainController',
		function($scope, $location, $route, $routeParams) {

			$scope.$location = $location;
			$scope.$route = $route;
			$scope.$routeParams = $routeParams;

		});