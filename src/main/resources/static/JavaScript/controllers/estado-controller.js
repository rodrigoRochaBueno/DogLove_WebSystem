appCliente.controller("estado-controller", function($scope, $http){
	
	$scope.estado={};
	$scope.estados=[];
	$scope.deletar;
	
	$scope.salvarEstado = function(){
		$http({method:"POST", url:"http://localhost:8092/admin/estados", data:$scope.estado})
		.then(function(response){
			$scope.estados = response.data;
			
			console.log(response.data);
			console.log(response.status);
			
			window.alert("Estado Salvo com sucesso!");
			
			
		}, function(response){
			
			console.log(response.data);
			console.log(response.status);
			
		});
		
	};
	
	$scope.carregarEstados = function(){
		$http.get('admin/estados')
		.then(function(response){
			$scope.estados=response.data;
			
			console.log(response.data);
			console.log(response.status);
			
		}, function(response){
			
			console.log(response.data)
			console.log(response.status);
			
			
		});
		
		
	};
	
	$scope.deletarEstado = function(){
	
		$http({method:"DELETE", url:"admin/estados/" + $scope.deletar})
		.then(function(response){
			
			console.log(response.data);
			console.log(response.status);
			
			window.alert("Estado " + $scope.deletar + " deletado com sucesso !");
			
		}, function(reponse){
			
			console.log(response.data);
			console.log(response.status);
			
		});
	
	};
	
	
});