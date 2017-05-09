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
	}).when('/clienteDetalhe/:clienteId', {
		templateUrl : 'ClienteDetalhe.html',
		controller : 'clienteDetalheController'
	})

})

.controller('mainController',
		function($scope, $location, $route, $routeParams) {

			$scope.$location = $location;
			$scope.$route = $route;
			$scope.$routeParams = $routeParams;

		})

.controller("clienteDetalheController", function($scope, $http, $routeParams) {

	$scope.clientes = [];
	$scope.buscar = {};
	$scope.cliente = {};
	
	$scope.excluir = function(){
		if(window.confirm("Tem certeza de que deseja excluir esse cliente permanentemente??")){
		$http({method: "DELETE", url: "/deletarCliente/" + $scope.cliente.id})
		.then(function(response){
			console.log(response.data);
			
		}, function(){
			
			console.log(response.data);
			
		});
	   };
	};

	$http.get('/getById/' + $routeParams.clienteId).then(function(response) {

		$scope.cliente = response.data;
		console.log(response.data);

	}, function(response) {
		console.log(response.data);
	});

	$scope.getByName = function() {
		$http.get("/getByName/" + $scope.buscar.nome).then(function(response) {

			$scope.clientes = response.data;
			console.log(response.data);

		}, function(response) {

			console.log(response.data);

		});

	};

});