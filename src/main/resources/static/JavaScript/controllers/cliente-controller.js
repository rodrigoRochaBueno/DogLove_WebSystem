//Controllers
appCliente.controller("indexController", function($scope, $http){
	
	$scope.nome="Rodrigo";
	$scope.sobreNome=" Rocha Bueno";
	$scope.funcionarios=[];
	$scope.estados=[];
	$scope.funcNome;
	
	$scope.funcionario={};
	
	token = localStorage.getItem("userToken");
	
	//$http.defaults.headers.common.Authorization = 'Bearer ' + token;
	
	$scope.carregarFuncionarios = function(){
		
		$http({method:"GET", url:"http://localhost:8092/admin/funcionarios"})
		.then(function(response){
			$scope.funcionarios = response.data;
		
		}, function(response){
			
			console.log(response.data);
			console.log(response.status);
			
		});

		
	};
	
	
	$scope.salvarFuncionario = function(){
		
		
		$http({method:"POST", url:"http://localhost:8092/admin/funcionarios", data:$scope.funcionario})
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
		
		$http({method:"DELETE", url:"http://localhost:8092/admin/funcionarios/" + $scope.funcNome})
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
		
		$http({method:"PUT", url:"http://localhost:8092/admin/funcionarios/" + $scope.funcionario.id, data: $scope.funcionario})
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
		$http.get("http://localhost:8092/admin/estados/")
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