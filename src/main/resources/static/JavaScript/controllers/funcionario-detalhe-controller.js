appCliente.controller('funcionario-detalhe-controller', function($scope, $routeParams, $http){
	
	$scope.funcionario = {};
	$scope.func = {};
	
	
	$http.get('/funcionarios/'+ $routeParams.funcNome).then(function(response){
		
		$scope.func = response.data;
		
	}, function(response){
		
		console.log(response);
		
	});
	
});