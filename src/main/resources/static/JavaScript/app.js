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
	}).when('/login', {
		templateUrl: 'login2.html',
		controller: 'loginController'
	});

})

.controller('mainController',
		function($scope, $location, $route, $routeParams) {

			$scope.$location = $location;
			$scope.$route = $route;
			$scope.$routeParams = $routeParams;
			
			window.open("http://localhost:8092/#/login", "_self");

		})


.controller("clienteDetalheController", function($scope, $http, $routeParams) {

	$scope.clientes = [];
	$scope.buscar = {};
	$scope.cliente = {};
	
	$scope.excluir = function(){
		if(window.confirm("Tem certeza de que deseja excluir esse cliente permanentemente??")){
		$http({method: "DELETE", url: "/security/deletarCliente/" + $scope.cliente.id})
		.then(function(response){
			console.log(response.data);
			
		}, function(){
			
			console.log(response.data);
			
		});
	   };
	};

	$http.get('/security/getById/' + $routeParams.clienteId).then(function(response) {

		$scope.cliente = response.data;
		console.log(response.data);

	}, function(response) {
		console.log(response.data);
	});

	$scope.getByName = function() {
		$http.get("/security/getByName/" + $scope.buscar.nome).then(function(response) {

			$scope.clientes = response.data;
			console.log(response.data);

		}, function(response) {

			console.log(response.data);

		});

	};

});

appDogLove.config(function($httpProvider){
	$httpProvider.interceptors.push('tokenInterceptor');
	
});