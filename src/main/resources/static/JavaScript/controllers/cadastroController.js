appDogLove.controller('cadastroController', function($scope, $http) {

	$scope.cliente = {};
	$scope.listaClientes = [];

	$scope.listarClientes = function() {
		$http.get("/listarClientes").then(function(response) {

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
			url : "http://localhost:8092/salvar",
			data : $scope.cliente
		}).then(
				function(response) {

					window.alert($scope.cliente.nome + " "
							+ "foi adicionado a lista de clientes");
					console.log(response.data);

					$scope.listarClientes();

				}, function() {

					console.log(response.data);

				});

	};
	
	$scope.listarClientes();

});