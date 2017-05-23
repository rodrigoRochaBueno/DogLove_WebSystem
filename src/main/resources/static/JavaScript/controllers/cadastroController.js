appDogLove.controller('cadastroController', function($scope, $http) {

	$scope.cliente = {};
	$scope.listaClientes = [];
	$scope.buscar = {};
	$scope.resulBusca = [];
	$scope.global = {};
	$scope.global2 = {};

	$scope.getByName = function() {
		$http.get("/security/v1/clientes/" + $scope.buscar.nome).then(
				function(response) {

					$scope.resulBusca = response.data;

					console.log(response.data);

				}, function(response) {

					console.log(response.data);

				});
	};

	$scope.listarClientes = function() {
		$http.get("/security/v1/clientes/").then(function(response) {

			$scope.listaClientes = response.data;

			console.log(response.data);

		}, function(response) {

			window.alert("Oops! Ocorreu um erro ao tentar listar os clientes");
			
			console.log(response.data);

		});

	};

	$scope.salvarCliente = function() {
		$http({
			method : "POST",
			url : "http://localhost:8092/security/v1/clientes",
			data : $scope.cliente
		}).then(
				function(response) {

					window.alert($scope.cliente.nome + " "
							+ "foi adicionado a lista de clientes");
					$scope.cliente.nome = "";
					console.log(response.data);

					$scope.listarClientes();

				}, function() {

					console.log(response.data);

				});

	};

	$scope.listarClientes();

});