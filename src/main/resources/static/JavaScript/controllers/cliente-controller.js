//Controllers
appCliente.controller("indexController", function($scope, $http){
	
	$scope.nome="Rodrigo";
	$scope.sobreNome=" Rocha Bueno";
	$scope.funcionarios=[];
	$scope.estados=[];
	$scope.funcNome;
	
	$scope.funcionario={};
	
	$scope.carregarFuncionarios = function(){
		
		$http({method:"GET", url:"http://localhost:8092/funcionarios"})
		.then(function(response){
			$scope.funcionarios = response.data;
		
		}, function(response){
			
			console.log(response.data);
			console.log(response.status);
			
		});

		
	};
	
	
	$scope.salvarFuncionario = function(){
		
		$http({method:"POST", url:"http://localhost:8092/funcionarios", data:$scope.funcionario})
		.then(function(response){
			$scope.funcionarios=response.data;
			
			console.log(response.data);
			console.log(response.status);
			
			
		
		}, function(response){
			
			console.log(response.data);
			console.log(response.status);
			
		});

		
	};
	
$scope.excluirFuncionario = function(){
		
		$http({method:"DELETE", url:"http://localhost:8092/funcionarios/" + $scope.funcNome})
		.then(function(response){
			$scope.funcionarios=response.data;
			
			console.log(response.data);
			console.log(response.status);
		
		}, function(response){
			
			console.log(response.data);
			console.log(response.status);
			
		});

		
	};
	
$scope.alterarFuncionario = function(){
		
		$http({method:"PUT", url:"http://localhost:8092/funcionarios/" + $scope.funcionario.id, data: $scope.funcionario})
		.then(function(response){
			$scope.funcionarios=response.data;
			
			console.log(response.data);
			console.log(response.status);
		
		}, function(response){
			
			console.log(response.data);
			console.log(response.status);
			
		});

		
	};
	
	$scope.carregarEstados = function(){
		$http.get('/estados')
		.then(function(response){
			$scope.estados=response.data;
			
			console.log(response.data);
			console.log(response.status);
			
		}, function(response){
			
			console.log(response.data)
			console.log(response.status);
			
			
		});
		
		
	};
	
	$scope.carregarEstados();
	$scope.carregarFuncionarios();
});